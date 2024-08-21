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
 * This class represents the Rating entity, which maps to the "ratings" table in the database.
 * It holds information about a user's rating for a particular movie.
 */
@Entity
@Table(name = "ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    // Primary key for the Rating entity, generated automatically by the database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-one relationship with the User entity. A user can have many ratings.
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key column to reference the User entity.
    private User user;

    // Many-to-one relationship with the Movie entity. A movie can have many ratings.
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false) // Foreign key column to reference the Movie entity.
    private Movie movie;

    // Stores the rating value given by the user. This column cannot be null.
    @Column(nullable = false)
    private int rating;

    // Timestamp of when the rating was created.
    private LocalDateTime createdAt;

    // Timestamp of the last update to the rating.
    private LocalDateTime updatedAt;
}
