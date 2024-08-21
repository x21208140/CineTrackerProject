package com.example.CineTracker;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This class represents a Movie entity mapped to the "movies" table in the database.
@Entity
@Table(name = "movies") // Specifies the table name in the database
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public class Movie {

    @Id // Marks this field as the primary key for the entity
    private String id; // Unique identifier for the movie, typically the OMDb ID

    // Specifies that this field maps to a column in the "movies" table
    @Column(name = "title")
    private String title; // Movie title

    @Column(name = "year")
    private String year; // Release year of the movie

    @Column(name = "genre")
    private String genre; // Genre(s) of the movie

    @Column(name = "director")
    private String director; // Director of the movie

    @Column(name = "actors")
    private String actors; // Main actors in the movie

    @Column(name = "plot", columnDefinition = "TEXT") // Maps to a TEXT column for longer plots
    private String plot; // Plot summary of the movie

    @Column(name = "poster")
    private String poster; // URL or path to the movie's poster image

    @Column(name = "created_at")
    private LocalDateTime createdAt; // Timestamp when the record was created

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // Timestamp when the record was last updated
}
