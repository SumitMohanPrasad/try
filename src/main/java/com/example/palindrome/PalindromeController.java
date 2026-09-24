package com.example.palindrome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    @GetMapping("/palindrome/{text}")
    public String getPalindrome(@PathVariable String text) {
        return PalindromeService.isPalindrome(text);
    }
}