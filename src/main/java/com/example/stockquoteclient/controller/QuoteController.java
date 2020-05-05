package com.example.stockquoteclient.controller;

import com.example.stockquoteclient.domain.Quote;
import com.example.stockquoteclient.service.QuoteMonitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class QuoteController {

    private final QuoteMonitorService quoteMonitorService;

    public QuoteController(QuoteMonitorService quoteMonitorService) {
        this.quoteMonitorService = quoteMonitorService;
    }

    @GetMapping("/getQuotes")
    Flux<Quote> getQuotes() {
        return this.quoteMonitorService.getQuotes();
    }

}
