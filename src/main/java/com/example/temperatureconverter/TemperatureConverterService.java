package com.example.temperatureconverter;

import java.util.logging.Logger;

public class TemperatureConverterService {

    private static final Logger LOGGER = Logger.getLogger(TemperatureConverterService.class.getName());

    /**
     * Converts temperature from Celsius to Fahrenheit.
     *
     * @param celsius temperature in Celsius
     * @return temperature in Fahrenheit
     */
    public double convertCelsiusToFahrenheit(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Temperature cannot be less than absolute zero");
        }
        return (celsius * 9 / 5) + 32;
    }
}