package com.example.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Returns a mock weather response.
     *
     * @return a ResponseEntity containing the mock weather data
     */
    @GetMapping("/weather/mock")
    public ResponseEntity<WeatherResponse> getMockWeather() {
        try {
            WeatherResponse weatherResponse = weatherService.getMockWeather();
            return ResponseEntity.status(HttpStatus.OK).body(weatherResponse);
        } catch (Exception e) {
            log.error("Error fetching mock weather", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}