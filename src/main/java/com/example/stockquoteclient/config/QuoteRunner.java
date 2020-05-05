package com.example.stockquoteclient.config;


import com.example.stockquoteclient.client.StockQuoteClient;
import com.example.stockquoteclient.domain.Quote;
import com.example.stockquoteclient.repositories.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

@Component
public class QuoteRunner implements CommandLineRunner {

    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository repository;

    public QuoteRunner(StockQuoteClient stockQuoteClient, QuoteRepository repository) {
        this.stockQuoteClient = stockQuoteClient;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        Flux<Quote> quoteFlux = repository.findWithTailableCursorBy();

        Disposable disposable = quoteFlux.subscribe(quote -> {
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#* Id: " + quote.getId());
        });

        disposable.dispose();
    }
}
