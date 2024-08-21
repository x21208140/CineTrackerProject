package com.example.CineTracker;

import org.springframework.data.jpa.repository.JpaRepository;

// The MovieRepository interface is a data access layer for performing CRUD operations on Movie entities.
// It extends JpaRepository, which provides JPA functionalities for the Movie entity.
public interface MovieRepository extends JpaRepository<Movie, String> {
    // JpaRepository<Movie, String> specifies that this repository manages Movie entities with a primary key of type String.
    // By extending JpaRepository, MovieRepository inherits several methods for working with Movie persistence, including
    // methods for saving, deleting, and finding Movie entities.
}
