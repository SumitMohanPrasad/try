package com.example;

import com.example.HelloConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConnectorController {

    private final HelloConnectorService helloConnectorService;

    @Autowired
    public HelloConnectorController(HelloConnectorService helloConnectorService) {
        this.helloConnectorService = helloConnectorService;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        return helloConnectorService.sayHello(name);
    }

}