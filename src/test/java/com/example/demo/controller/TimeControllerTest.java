package com.example.demo.controller;

import com.example.demo.model.TimeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TimeController.class)
class TimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCurrentTime_ShouldReturnOkStatus() throws Exception {
        mockMvc.perform(get("/api/time")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getCurrentTime_ShouldReturnJsonContentType() throws Exception {
        mockMvc.perform(get("/api/time"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCurrentTime_ShouldReturnTimestampField() throws Exception {
        mockMvc.perform(get("/api/time"))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void getCurrentTime_ShouldReturnValidIsoInstantFormat() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/time"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        
        // Parse the JSON to extract timestamp
        // The timestamp should be a valid ISO_INSTANT format
        assertThat(responseBody).contains("timestamp");
        
        // Verify it can be parsed as Instant
        Instant timestamp = parseTimestampFromResponse(responseBody);
        assertThat(timestamp).isNotNull();
    }

    @Test
    void getCurrentTime_ShouldReturnRecentTimestamp() throws Exception {
        Instant beforeRequest = Instant.now();
        
        MvcResult result = mockMvc.perform(get("/api/time"))
                .andExpect(status().isOk())
                .andReturn();
        
        Instant afterRequest = Instant.now();
        
        String responseBody = result.getResponse().getContentAsString();
        Instant timestamp = parseTimestampFromResponse(responseBody);
        
        // Timestamp should be between before and after request (with small buffer)
        assertThat(timestamp).isBetween(beforeRequest.minusSeconds(2), afterRequest.plusSeconds(2));
    }

    @Test
    void getCurrentTime_ShouldReturnConsistentFormat() throws Exception {
        // Make multiple requests to verify consistent format
        for (int i = 0; i < 3; i++) {
            MvcResult result = mockMvc.perform(get("/api/time"))
                    .andExpect(status().isOk())
                    .andReturn();

            String responseBody = result.getResponse().getContentAsString();
            Instant timestamp = parseTimestampFromResponse(responseBody);
            assertThat(timestamp).isNotNull();
        }
    }

    private Instant parseTimestampFromResponse(String responseBody) {
        // Extract timestamp from JSON response
        // Format: {"timestamp":"2024-01-15T10:30:45.123Z"}
        try {
            String timestampStr = responseBody
                    .replaceAll("^.*\"timestamp\"\s*:\s*\"([^\"]+)\".*$", "$1");
            return Instant.parse(timestampStr);
        } catch (Exception e) {
            return null;
        }
    }
}