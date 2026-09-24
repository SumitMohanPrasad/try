package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class.
 */
@SpringBootApplication
public class Application {

    /**
     * Entry point for the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}