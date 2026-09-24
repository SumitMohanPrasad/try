package com.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloConnector {

    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

}