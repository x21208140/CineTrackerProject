package com.example.CineTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service class for managing user-related operations.
 * 
 * This class contains business logic for managing users, including retrieving,
 * creating, updating, and deleting user records.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Repository for performing CRUD operations on User entities

    /**
     * Retrieve a list of all users.
     * 
     * @return a list of all users in the system
     */
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Delegate to repository to fetch all users
    }

    /**
     * Retrieve a user by their ID.
     * 
     * @param id the ID of the user to be retrieved
     * @return the user with the given ID, or null if no such user exists
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null); // Fetch the user by ID from the repository
    }

    /**
     * Create a new user and set creation and update timestamps.
     * 
     * @param user the user object to be created
     * @return the created user object with timestamps set
     */
    public User createUser(User user) {
        // Set creation and update timestamps to the current time
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        return userRepository.save(user); // Save the user to the repository
    }

    /**
     * Update an existing user with new details.
     * 
     * @param id the ID of the user to be updated
     * @param userDetails the new details to update the user with
     * @return the updated user object, or null if the user was not found
     */
    public User updateUser(Long id, User userDetails) {
        // Retrieve the user to be updated
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            // Update the user details
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
        }
        return user;
    }

    public User getUserById(String username) {
       
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    public void deleteUser(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }}

