package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * A service that uses the HelloConnector to print a hello message.
 */
@Service
public class HelloService {

    private static final Logger LOGGER = Logger.getLogger(HelloService.class.getName());

    private final HelloConnector connector;

    @Autowired
    public HelloService(HelloConnector connector) {
        this.connector = connector;
    }

    /**
     * Prints a hello message using the connector.
     */
    public void printHello() {
        try {
            connector.connect();
        } catch (Exception e) {
            LOGGER.severe("Error printing hello message: " + e.getMessage());
        }
    }
}