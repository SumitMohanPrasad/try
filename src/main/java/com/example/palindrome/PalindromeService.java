package com.example.palindrome;

public class PalindromeService {

    public boolean isPalindrome(String text) {
        return isPalindromeLogic(text);
    }

    private boolean isPalindromeLogic(String text) {
        int i = 0;
        int j = text.length() - 1;
        while (i < j) {
            if (text.charAt(i) != text.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}