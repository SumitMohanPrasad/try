package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class FibonacciController {

    @PostMapping("/fibonacci")
    public ResponseEntity<List<Long>> getFibonacci(@RequestBody List<Long> numbers) {
        // Validate input
        if (numbers == null || numbers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // Calculate Fibonacci sequence
        List<Long> fibonacciSequence = calculateFibonacci(numbers.get(0), numbers.get(1));

        return ResponseEntity.ok(fibonacciSequence);
    }

    private List<Long> calculateFibonacci(Long a, Long b) {
        List<Long> sequence = List.of(a, b);
        while (sequence.size() < 10) {
            sequence.add(sequence.get(sequence.size() - 1) + sequence.get(sequence.size() - 2));
        }
        return sequence;
    }
}