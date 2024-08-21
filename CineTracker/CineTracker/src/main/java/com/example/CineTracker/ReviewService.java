package com.example.CineTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service class for managing business logic related to reviews.
 * 
 * This class provides methods to interact with the Review repository,
 * including retrieving, creating, updating, and deleting reviews.
 */
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository; // Repository for performing CRUD operations on Review entities

    /**
     * Retrieve a list of reviews associated with a specific movie ID.
     * 
     * @param movieId the ID of the movie
     * @return a list of reviews for the given movie ID
     */
    public List<Review> getReviewsByMovieId(String movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    /**
     * Retrieve a list of reviews written by a specific user ID.
     * 
     * @param userId the ID of the user
     * @return a list of reviews written by the given user ID
     */
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    /**
     * Create a new review, setting the creation and update timestamps.
     * 
     * @param review the review object to be created
     * @return the created review object with timestamps set
     */
    public Review createReview(Review review) {
        // Set creation and update timestamps to the current time
        LocalDateTime now = LocalDateTime.now();
        review.setCreatedAt(now);
        review.setUpdatedAt(now);
        return reviewRepository.save(review); // Save the review to the repository
    }

    /**
     * Update an existing review by its ID with new details.
     * 
     * @param id the ID of the review to be updated
     * @param reviewDetails the new details to be updated
     * @return the updated review object, or null if the review was not found
     */
    public Review updateReview(Long id, Review reviewDetails) {
        // Retrieve the review to be updated
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            // Update the review text and set the update timestamp
            review.setReviewText(reviewDetails.getReviewText());
            review.setUpdatedAt(LocalDateTime.now());
            return reviewRepository.save(review); // Save the updated review to the repository
        }
        return null; // Return null if the review was not found
    }

    /**
     * Delete a review by its ID.
     * 
     * @param id the ID of the review to be deleted
     */
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id); // Delete the review from the repository
    }
}
