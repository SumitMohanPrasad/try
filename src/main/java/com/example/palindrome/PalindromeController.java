package com.example.palindrome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    private final PalindromeService palindromeService;

    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @GetMapping("/palindrome/{text}")
    public String isPalindrome(@PathVariable String text) {
        return "Result: " + palindromeService.isPalindrome(text);
    }
}