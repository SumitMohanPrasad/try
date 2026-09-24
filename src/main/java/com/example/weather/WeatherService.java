package com.example.weather;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherService {

    /**
     * Returns a mock weather response.
     *
     * @return a WeatherResponse object containing mock weather data
     */
    public WeatherResponse getMockWeather() {
        // For demonstration purposes, return a hardcoded mock weather response
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setTemperature(22.5);
        weatherResponse.setHumidity(60);
        weatherResponse.setCondition("Sunny");
        return weatherResponse;
    }
}