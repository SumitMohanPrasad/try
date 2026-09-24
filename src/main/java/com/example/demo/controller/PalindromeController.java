package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @GetMapping("/palindrome/{text}")
    public ResponseEntity<String> isPalindrome(@PathVariable String text) {
        try {
            if (text == null || text.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input text cannot be empty");
            }
            boolean isPalindrome = palindromeService.isPalindrome(text);
            return ResponseEntity.ok(isPalindrome ? "The text is a palindrome" : "The text is not a palindrome");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while checking palindrome: " + e.getMessage());
        }
    }
}