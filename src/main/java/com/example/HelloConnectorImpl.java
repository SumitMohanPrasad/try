package com.example;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * A concrete implementation of the HelloConnector.
 */
@Component
public class HelloConnectorImpl implements HelloConnector {

    private static final Logger LOGGER = Logger.getLogger(HelloConnectorImpl.class.getName());

    @Override
    public void connect() {
        LOGGER.info("Connecting to hello service...");
        System.out.println("Hello, World!");
    }
}