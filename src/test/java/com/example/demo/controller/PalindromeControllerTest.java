package com.example.demo.controller;

import com.example.demo.dto.PalindromeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PalindromeController.class)
class PalindromeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPalindrome() throws Exception {
        mockMvc.perform(get("/palindrome/racecar")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"text\":\"racecar\",\"isPalindrome\":true}"));
    }

    @Test
    void testNotPalindrome() throws Exception {
        mockMvc.perform(get("/palindrome/hello")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"text\":\"hello\",\"isPalindrome\":false}"));
    }

    @Test
    void testBlankInput() throws Exception {
        mockMvc.perform(get("/palindrome/   ")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}