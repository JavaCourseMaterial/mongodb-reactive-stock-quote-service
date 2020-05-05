package com.example.stockquoteclient.config;


import com.example.stockquoteclient.domain.Quote;
import com.example.stockquoteclient.repositories.QuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class QuoteRunner implements CommandLineRunner {

    private final MongoOperations mongoOperations;
    private final QuoteRepository repository;

    public QuoteRunner(MongoOperations mongoOperations, QuoteRepository repository) {
        this.mongoOperations = mongoOperations;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (mongoOperations.collectionExists("quote")) {
            mongoOperations.dropCollection("quote");
        }

        // Capped collections need to be created manually
        mongoOperations.createCollection("quote", CollectionOptions.empty().capped().size(9999999L).maxDocuments(500L));

        Flux<Quote> quoteFlux = repository.findWithTailableCursorBy();

        Disposable disposable = quoteFlux.subscribe(quote -> {
            log.info("*#*#*#*#*#*#*#*#*#*#*#*#* Id: " + quote.getId());
        });

        disposable.dispose();
    }
}
