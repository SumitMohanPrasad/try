package com.example.palindrome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PalindromeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPalindrome() throws Exception {
        mockMvc.perform(get("/palindrome/level"))
                .andExpect(status().isOk())
                .andExpect(content().string("The text is a palindrome."));
    }

    @Test
    public void testGetPalindromeInvalidInput() throws Exception {
        mockMvc.perform(get("/palindrome/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Error: Input text is empty or null."));
    }
}