package com.example.quotes.controller;

import com.example.quotes.model.Quote;
import com.example.quotes.service.QuoteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(QuoteController.class)
class QuoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuoteService quoteService;

    @Test
    @DisplayName("GET /random-quote returns 200 and a Quote JSON")
    void testGetRandomQuote_Returns200WithQuote() throws Exception {
        Quote quote = new Quote("Test quote for endpoint");
        Mockito.when(quoteService.getRandomQuote()).thenReturn(quote);

        mockMvc.perform(get("/random-quote")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.text").value(quote.getText()));
    }

    @Test
    @DisplayName("GET /random-quote returns correct content type")
    void testGetRandomQuote_ReturnsCorrectContentType() throws Exception {
        Quote quote = new Quote("Another test quote");
        Mockito.when(quoteService.getRandomQuote()).thenReturn(quote);

        mockMvc.perform(get("/random-quote"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"));
    }

    @Test
    @DisplayName("GET /random-quote returns a non-empty text")
    void testGetRandomQuote_ReturnsNonEmptyText() throws Exception {
        Quote quote = new Quote("Non-empty text");
        Mockito.when(quoteService.getRandomQuote()).thenReturn(quote);

        mockMvc.perform(get("/random-quote"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").isNotEmpty());
    }
}
