package com.example.controller;

import com.example.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverseController {

    private final ReverseService reverseService;

    @Autowired
    public ReverseController(ReverseService reverseService) {
        this.reverseService = reverseService;
    }

    @PostMapping("/reverse")
    public ResponseEntity<String> reverseString(@RequestBody String input) {
        try {
            String reversed = reverseService.reverse(input);
            return new ResponseEntity<>(reversed, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}