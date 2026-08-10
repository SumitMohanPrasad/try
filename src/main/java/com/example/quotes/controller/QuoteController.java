package com.example.quotes.controller;

import com.example.quotes.model.Quote;
import com.example.quotes.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/random-quote")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }
}