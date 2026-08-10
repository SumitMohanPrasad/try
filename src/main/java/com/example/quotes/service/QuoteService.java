package com.example.quotes.service;

import com.example.quotes.model.Quote;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class QuoteService {
    private final List<Quote> quotes = Arrays.asList(
        new Quote("The only way to do great work is to love what you do."),
        new Quote("Innovation distinguishes between a leader and a follower."),
        new Quote("Don't cry because it's over, smile because it happened."),
        new Quote("The best way to predict the future is to invent it."),
        new Quote("The most dangerous disease is inactivity."),
        new Quote("The only limit to our realization of tomorrow will be our doubts of today."),
        new Quote("Education is not the filling of a pail, but the lighting of a fire."),
        new Quote("If you can't explain it simply, you don't understand it well enough."),
        new Quote("Success is not final, failure is not fatal: It is the courage to continue that counts."),
        new Quote("A life spent making mistakes is not a wasted life.")
    );

    public Quote getRandomQuote() {
        Collections.shuffle(quotes);
        return quotes.get(0);
    }
}