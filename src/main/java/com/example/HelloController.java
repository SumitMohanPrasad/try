package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling hello world endpoint.
 */
@RestController
public class HelloController {

    /**
     * Handles GET request to /hello endpoint.
     * @return a simple "Hello World!" message
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}