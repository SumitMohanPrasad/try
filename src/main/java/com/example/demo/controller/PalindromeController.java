package com.example.demo.controller;

import com.example.demo.dto.PalindromeResponse;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class PalindromeController {

    @GetMapping("/palindrome/{text}")
    public ResponseEntity<PalindromeResponse> getPalindrome(@PathVariable @NotBlank String text) {
        boolean isPalindrome = new StringBuilder(text).reverse().toString().equals(text);
        return ResponseEntity.ok(new PalindromeResponse(text, isPalindrome));
    }
}