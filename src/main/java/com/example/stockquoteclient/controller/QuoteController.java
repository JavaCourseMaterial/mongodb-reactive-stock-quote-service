package com.example.stockquoteclient.controller;

import com.example.stockquoteclient.domain.Quote;
import com.example.stockquoteclient.domain.QuoteRequest;
import com.example.stockquoteclient.service.QuoteMonitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

@RestController
public class QuoteController {

    private final QuoteMonitorService quoteMonitorService;

    public QuoteController(QuoteMonitorService quoteMonitorService) {
        this.quoteMonitorService = quoteMonitorService;
    }

    @GetMapping("/getQuotes")
    public Flux<Quote> getQuotes() {
        return this.quoteMonitorService.getQuotes();
    }

    @GetMapping("/getSpecificQuote")
    public Flux<Quote> getSpecificQuote(@Valid @RequestBody QuoteRequest targetQuote) {
        return this.quoteMonitorService.getSpecificQuote(targetQuote);
    }



}
