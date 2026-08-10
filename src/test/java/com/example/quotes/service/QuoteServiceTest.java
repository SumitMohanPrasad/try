package com.example.quotes.service;

import com.example.quotes.model.Quote;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

class QuoteServiceTest {

    private final QuoteService service = new QuoteService();

    @Test
    @DisplayName("getRandomQuote should never return null")
    void getRandomQuoteNeverReturnsNull() {
        Quote quote = service.getRandomQuote();
        Assertions.assertNotNull(quote, "Quote should not be null");
    }

    @Test
    @DisplayName("getRandomQuote should return a non-empty text")
    void getRandomQuoteReturnsNonEmptyText() {
        Quote quote = service.getRandomQuote();
        Assertions.assertNotNull(quote.getText(), "Quote text should not be null");
        Assertions.assertFalse(quote.getText().isBlank(), "Quote text should not be blank");
    }

    @Test
    @DisplayName("getRandomQuote should return a quote from the predefined list")
    void getRandomQuoteReturnsValidQuote() {
        String[] expectedQuotes = {
            "The only way to do great work is to love what you do.",
            "Innovation distinguishes between a leader and a follower.",
            "Don't cry because it's over, smile because it happened.",
            "The best way to predict the future is to invent it.",
            "The most dangerous disease is inactivity.",
            "The only limit to our realization of tomorrow will be our doubts of today.",
            "Education is not the filling of a pail, but the lighting of a fire.",
            "If you can't explain it simply, you don't understand it well enough.",
            "Success is not final, failure is not fatal: It is the courage to continue that counts.",
            "A life spent making mistakes is not a wasted life."
        };

        for (int i = 0; i < 100; i++) {
            Quote quote = service.getRandomQuote();
            Assertions.assertTrue(
                Arrays.stream(expectedQuotes).anyMatch(q -> q.equals(quote.getText())),
                "Returned quote must be one of the predefined quotes"
            );
        }
    }
}
