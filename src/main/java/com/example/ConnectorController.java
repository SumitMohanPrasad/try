package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectorController {

    @Autowired
    private ConnectorService connectorService;

    @GetMapping("/connectors")
    public String getConnectors() {
        connectorService.printMessage();
        return "Hello, Connectors!";
    }
}