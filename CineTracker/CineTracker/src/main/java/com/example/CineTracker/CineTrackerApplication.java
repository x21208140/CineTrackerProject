package com.example.CineTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This is the main class for the CineTracker application.
// The @SpringBootApplication annotation indicates that this is a Spring Boot application.
@SpringBootApplication
public class CineTrackerApplication {

    // The main method is the entry point of the application.
    // SpringApplication.run() method launches the application.
    public static void main(String[] args) {
        // This line starts the Spring Boot application by bootstrapping the CineTrackerApplication class.
        SpringApplication.run(CineTrackerApplication.class, args);
    }

}
