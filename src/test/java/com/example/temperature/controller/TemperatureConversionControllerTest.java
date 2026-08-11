package com.example.temperature.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.temperature.service.TemperatureConversionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.math.RoundingMode;

@WebMvcTest(TemperatureConversionController.class)
class TemperatureConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TemperatureConversionService temperatureConversionService;

    private static final String BASE_URL = "/convert/temperature";

    @Nested
    @DisplayName("Valid conversion requests")
    class ValidRequests {

        @Test
        @DisplayName("Should convert Celsius to Fahrenheit")
        void celsiusToFahrenheit() throws Exception {
            // Given
            Double value = 0.0;
            String from = "C";
            String to = "F";
            Double expected = 32.0;
            when(temperatureConversionService.convert(value, from, to)).thenReturn(expected);

            // When + Then
            mockMvc.perform(get(BASE_URL)
                            .param("value", value.toString())
                            .param("from", from)
                            .param("to", to))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.convertedValue").value(expected));

            verify(temperatureConversionService).convert(value, from, to);
            verifyNoMoreInteractions(temperatureConversionService);
        }

        @Test
        @DisplayName("Should convert Fahrenheit to Celsius")
        void fahrenheitToCelsius() throws Exception {
            // Given
            Double value = 212.0;
            String from = "F";
            String to = "C";
            Double expected = 100.0;
            when(temperatureConversionService.convert(value, from, to)).thenReturn(expected);

            // When + Then
            mockMvc.perform(get(BASE_URL)
                            .param("value", value.toString())
                            .param("from", from)
                            .param("to", to))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.convertedValue").value(expected));

            verify(temperatureConversionService).convert(value, from, to);
        }

        @Test
        @DisplayName("Should convert Celsius to Kelvin with rounding")
        void celsiusToKelvin() throws Exception {
            // Given
            Double value = -40.0;
            String from = "C";
            String to = "K";
            Double expected = 233.15; // -40 + 273.15
            when(temperatureConversionService.convert(value, from, to)).thenReturn(expected);

            // When + Then
            mockMvc.perform(get(BASE_URL)
                            .param("value", value.toString())
                            .param("from", from)
                            .param("to", to))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.convertedValue").value(expected));

            verify(temperatureConversionService).convert(value, from, to);
        }

        @Test
        @DisplayName("Should handle large positive value")
        void largeValue() throws Exception {
            // Given
            Double value = 1000000.0;
            String from = "K";
            String to = "F";
            Double expected = 1.799954e+6; // approximate, we rely on mock
            when(temperatureConversionService.convert(value, from, to)).thenReturn(expected);

            // When + Then
            mockMvc.perform(get(BASE_URL)
                            .param("value", value.toString())
                            .param("from", from)
                            .param("to", to))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.convertedValue").value(expected));

            verify(temperatureConversionService).convert(value, from, to);
        }
    }

    @Nested
    @DisplayName("Invalid request validation")
    class InvalidRequests {

        @Test
        @DisplayName("Should return 400 when 'from' unit is invalid")
        void invalidFromUnit() throws Exception {
            mockMvc.perform(get(BASE_URL)
                            .param("value", "0")
                            .param("from", "X")
                            .param("to", "C"))
                    .andExpect(status().isBadRequest());

            verifyNoInteractions(temperatureConversionService);
        }

        @Test
        @DisplayName("Should return 400 when 'to' unit is invalid")
        void invalidToUnit() throws Exception {
            mockMvc.perform(get(BASE_URL)
                            .param("value", "0")
                            .param("from", "C")
                            .param("to", "Z"))
                    .andExpect(status().isBadRequest());

            verifyNoInteractions(temperatureConversionService);
        }

        @Test
        @DisplayName("Should return 400 when value is not a number")
        void nonNumericValue() throws Exception {
            mockMvc.perform(get(BASE_URL)
                            .param("value", "abc")
                            .param("from", "C")
                            .param("to", "F"))
                    .andExpect(status().isBadRequest());

            verifyNoInteractions(temperatureConversionService);
        }

        @Test
        @DisplayName("Should return 400 when missing 'value' parameter")
        void missingValue() throws Exception {
            mockMvc.perform(get(BASE_URL)
                            .param("from", "C")
                            .param("to", "F"))
                    .andExpect(status().isBadRequest());

            verifyNoInteractions(temperatureConversionService);
        }

        @Test
        @DisplayName("Should return 400 when missing 'from' parameter")
        void missingFrom() throws Exception {
            mockMvc.perform(get(BASE_URL)
                            .param("value", "0")
                            .param("to", "F"))
                    .andExpect(status().isBadRequest());

            verifyNoInteractions(temperatureConversionService);
        }

        @Test
        @DisplayName("Should return 400 when missing 'to' parameter")
        void missingTo() throws Exception {
            mockMvc.perform(get(BASE_URL)
                            .param("value", "0")
                            .param("from", "C"))
                    .andExpect(status().isBadRequest());

            verifyNoInteractions(temperatureConversionService);
        }
    }

    @Nested
    @DisplayName("Service exception handling")
    class ServiceExceptions {

        @Test
        @DisplayName("Should return 500 when service throws an exception")
        void serviceThrowsException() throws Exception {
            // Given
            Double value = 10.0;
            String from = "C";
            String to = "F";
            when(temperatureConversionService.convert(value, from, to))
                    .thenThrow(new IllegalArgumentException("Unsupported conversion"));

            // When + Then
            mockMvc.perform(get(BASE_URL)
                            .param("value", value.toString())
                            .param("from", from)
                            .param("to", to))
                    .andExpect(status().isInternalServerError());

            verify(temperatureConversionService).convert(value, from, to);
        }
    }
}
