package com.example.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItWorksController.class)
class ItWorksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /it-works should return 200 status")
    void testGetItWorksReturnsOkStatus() throws Exception {
        mockMvc.perform(get("/it-works"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /it-works should return expected response body")
    void testGetItWorksReturnsExpectedBody() throws Exception {
        mockMvc.perform(get("/it-works"))
                .andExpect(content().string("Yayy It works"));
    }

    @Test
    @DisplayName("GET /it-works should return 200 status with correct body")
    void testGetItWorksReturns200WithCorrectBody() throws Exception {
        mockMvc.perform(get("/it-works"))
                .andExpect(status().isOk())
                .andExpect(content().string("Yayy It works"));
    }

    @Test
    @DisplayName("GET /it-works with trailing slash should also work")
    void testGetItWorksWithTrailingSlash() throws Exception {
        mockMvc.perform(get("/it-works/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Yayy It works"));
    }
}
