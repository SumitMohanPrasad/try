package com.example.weather;

import lombok.Data;

@Data
public class WeatherResponse {
    private double temperature;
    private int humidity;
    private String condition;
}