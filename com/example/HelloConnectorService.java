package com.example;

import com.example.HelloConnector;
import org.springframework.stereotype.Service;

@Service
public class HelloConnectorService {

    private final HelloConnector helloConnector;

    public HelloConnectorService(HelloConnector helloConnector) {
        this.helloConnector = helloConnector;
    }

    public String sayHello(String name) {
        return helloConnector.sayHello(name);
    }

}