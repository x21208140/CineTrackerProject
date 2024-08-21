package com.example.CineTracker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing `Review` entities.
 * 
 * This interface extends `JpaRepository`, providing basic CRUD operations
 * and query methods for `Review` entities.
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /**
     * Find all reviews associated with a specific movie ID.
     * 
     * @param movieId the ID of the movie
     * @return a list of reviews for the given movie ID
     */
    List<Review> findByMovieId(String movieId);

    /**
     * Find all reviews written by a specific user ID.
     * 
     * @param userId the ID of the user
     * @return a list of reviews written by the given user ID
     */
    List<Review> findByUserId(Long userId);
}
