package com.example.temperatureconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TemperatureConverterController {

    private static final Logger LOGGER = Logger.getLogger(TemperatureConverterController.class.getName());

    private final TemperatureConverterService temperatureConverterService;

    @Autowired
    public TemperatureConverterController(TemperatureConverterService temperatureConverterService) {
        this.temperatureConverterService = temperatureConverterService;
    }

    /**
     * Converts temperature from Celsius to Fahrenheit.
     *
     * @param celsius temperature in Celsius
     * @return temperature in Fahrenheit
     */
    @GetMapping("/convert/temperature/{celsius}")
    public ResponseEntity<String> convertTemperature(@PathVariable double celsius) {
        try {
            double fahrenheit = temperatureConverterService.convertCelsiusToFahrenheit(celsius);
            return ResponseEntity.status(HttpStatus.OK).body("Temperature in Fahrenheit: " + fahrenheit);
        } catch (Exception e) {
            LOGGER.severe("Error converting temperature: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting temperature");
        }
    }
}