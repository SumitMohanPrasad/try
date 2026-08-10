package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseService {

    public String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
}