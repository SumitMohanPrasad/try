package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    /**
     * Returns the current time.
     *
     * @return the current time in the format "HH:mm:ss"
     */
    @GetMapping("/time")
    public String getTime() {
        return java.time.LocalTime.now().toString();
    }
}