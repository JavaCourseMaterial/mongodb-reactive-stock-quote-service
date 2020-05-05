package com.example.stockquoteclient.repositories;

import com.example.stockquoteclient.domain.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {

    @Tailable
    Flux<Quote> findWithTailableCursorBy(); //must be capped collection

    Flux<Quote> findAllByTicker(String quote);
}
