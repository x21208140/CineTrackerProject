package com.example.CineTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class is a REST controller handling authentication-related requests
@RestController
@RequestMapping("/api/auth") // Base URL for authentication-related requests
public class AuthController {

    @Autowired
    private UserService userService; // Service for managing user data

    @Autowired
    private PasswordEncoder passwordEncoder; // Password encoder for encrypting passwords

    // Endpoint for user registration
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Encrypt the user's password before storing it
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Create and return the newly registered user
        return userService.createUser(user);
    }

    // Endpoint for user login
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        // Retrieve existing user by username
        User existingUser = userService.getUserById(user.getUsername()); // Fixed method name
        // Check if user exists and passwords match
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return "Login successful";
        }
        // Return invalid credentials message if authentication fails
        return "Invalid credentials";
    }
}
