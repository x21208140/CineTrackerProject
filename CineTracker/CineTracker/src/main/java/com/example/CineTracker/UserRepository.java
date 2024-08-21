package com.example.CineTracker;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing `User` entities.
 * 
 * This interface extends `JpaRepository` to provide basic CRUD operations
 * and additional query methods for `User` entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by their username.
     * 
     * @param username the username of the user to be found
     * @return the user with the given username, or null if no such user exists
     */
    User findByUsername(String username);
}
