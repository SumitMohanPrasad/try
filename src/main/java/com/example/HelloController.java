package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling hello world requests.
 */
@RestController
public class HelloController {

    /**
     * Handles GET requests to the root path and returns a simple "Hello World!" message.
     *
     * @return a string containing the greeting
     */
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }
}