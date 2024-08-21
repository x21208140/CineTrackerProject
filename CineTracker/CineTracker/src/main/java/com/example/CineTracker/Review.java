package com.example.CineTracker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a review in the CineTracker application.
 */
@Entity
@Table(name = "reviews") // Specifies the table name in the database
@Data // Generates getters, setters, equals, hashcode, and toString methods
@NoArgsConstructor // Generates a no-arguments constructor
@AllArgsConstructor // Generates a constructor with all fields as parameters
public class Review {
    
    /**
     * Unique identifier for the review. This is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates values for this field
    private Long id;

    /**
     * The user who wrote the review. This is a many-to-one relationship with the User entity.
     * The 'user_id' column in the 'reviews' table references the User entity.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Specifies the column in the 'reviews' table
    private User user;

    /**
     * The movie being reviewed. This is a many-to-one relationship with the Movie entity.
     * The 'movie_id' column in the 'reviews' table references the Movie entity.
     */
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false) // Specifies the column in the 'reviews' table
    private Movie movie;

    /**
     * The text of the review. This field cannot be null.
     */
    @Column(nullable = false) // Specifies that this column cannot be null
    private String reviewText;

    /**
     * The date and time when the review was created.
     */
    private LocalDateTime createdAt;

    /**
     * The date and time when the review was last updated.
     */
    private LocalDateTime updatedAt;
}
