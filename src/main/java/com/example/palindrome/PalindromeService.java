package com.example.palindrome;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

    public String isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            return "Error: Input text is empty or null.";
        }

        StringBuilder reversedText = new StringBuilder(text).reverse();
        return text.equals(reversedText.toString()) ? "The text is a palindrome." : "The text is not a palindrome.";
    }
}