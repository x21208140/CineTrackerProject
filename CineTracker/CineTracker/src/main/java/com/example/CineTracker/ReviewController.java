package com.example.CineTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing reviews in the CineTracker application.
 */
@RestController
@RequestMapping("/api/reviews") // Base URL for all review-related endpoints
public class ReviewController {

    @Autowired
    private ReviewService reviewService; // Service layer to handle business logic for reviews

    /**
     * Get a list of reviews for a specific movie by its ID.
     * 
     * @param movieId the ID of the movie
     * @return a list of reviews for the specified movie
     */
    @GetMapping("/movie/{movieId}")
    public List<Review> getReviewsByMovieId(@PathVariable String movieId) {
        return reviewService.getReviewsByMovieId(movieId);
    }

    /**
     * Get a list of reviews written by a specific user by their ID.
     * 
     * @param userId the ID of the user
     * @return a list of reviews written by the specified user
     */
    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUserId(@PathVariable Long userId) {
        return reviewService.getReviewsByUserId(userId);
    }

    /**
     * Create a new review.
     * 
     * @param review the review object to be created
     * @return the created review object
     */
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    /**
     * Update an existing review by its ID.
     * 
     * @param id the ID of the review to be updated
     * @param reviewDetails the updated review details
     * @return a ResponseEntity containing the updated review or a not found status
     */
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        Review updatedReview = reviewService.updateReview(id, reviewDetails);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview); // Return the updated review with HTTP 200 status
        }
        return ResponseEntity.notFound().build(); // Return HTTP 404 if the review was not found
    }

    /**
     * Delete a review by its ID.
     * 
     * @param id the ID of the review to be deleted
     * @return a ResponseEntity with no content to indicate successful deletion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build(); // Return HTTP 204 to indicate successful deletion
    }
}
