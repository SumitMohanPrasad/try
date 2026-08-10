package com.example.demo.controller;

import com.example.demo.model.TimeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api")
public class TimeController {

    @GetMapping("/time")
    public TimeResponse getCurrentTime() {
        return new TimeResponse(Instant.now());
    }
}