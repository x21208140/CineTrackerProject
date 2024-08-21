package com.example.CineTracker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByMovieId(String movieId);
    List<Rating> findByUserId(Long userId);
}
