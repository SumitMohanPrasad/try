package com.example.fibonacci;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FibonacciController {

    @PostMapping("/fibonacci")
    public List<Integer> getFibonacci(@RequestBody List<Integer> numbers) {
        // Implement the Fibonacci calculation logic here
        return calculateFibonacci(numbers);
    }

    private List<Integer> calculateFibonacci(List<Integer> numbers) {
        // Implement the Fibonacci calculation logic here
        // For example:
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            result.add(numbers.get(i));
            if (i > 1) {
                result.add(numbers.get(i - 1) + numbers.get(i - 2));
            }
        }
        return result;
    }
}