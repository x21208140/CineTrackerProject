package com.example.CineTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing user-related operations.
 * 
 * This class provides endpoints for CRUD operations on `User` entities.
 */
@RestController
@RequestMapping("/api/users") // Base URL for all user-related endpoints
public class UserController {

    @Autowired
    private UserService userService; // Service layer to handle business logic for users

    /**
     * Retrieve a list of all users.
     * 
     * @return a list of all users
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers(); // Delegate to service layer to fetch all users
    }

    /**
     * Retrieve a user by its ID.
     * 
     * @param id the ID of the user
     * @return a ResponseEntity containing the user if found, or a not found status
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user); // Return the user with HTTP 200 status
        }
        return ResponseEntity.notFound().build(); // Return HTTP 404 if the user was not found
    }

    /**
     * Create a new user.
     * 
     * @param user the user object to be created
     * @return the created user object
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user); // Delegate to service layer to create a new user
    }

    /**
     * Update an existing user by its ID.
     * 
     * @param id the ID of the user to be updated
     * @param userDetails the new details to be updated
     * @return a ResponseEntity containing the updated user or a not found status
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser); // Return the updated user with HTTP 200 status
        }
        return ResponseEntity.notFound().build(); // Return HTTP 404 if the user was not found
    }

    /**
     * Delete a user by its ID.
     * 
     * @param id the ID of the user to be deleted
     * @return a ResponseEntity with no content to indicate successful deletion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id); // Delegate to service layer to delete the user
        return ResponseEntity.noContent().build(); // Return HTTP 204 to indicate successful deletion
    }
}
