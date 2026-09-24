package com.example.reverse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverseController {

    private final ReverseService reverseService;

    public ReverseController(ReverseService reverseService) {
        this.reverseService = reverseService;
    }

    @PostMapping("/reverse")
    public String reverseString(@RequestParam("input") String input) {
        try {
            return reverseService.reverseString(input);
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}