package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItWorksController {

    @GetMapping("/it-works")
    public String getItWorks() {
        return "Yayy It works";
    }
}