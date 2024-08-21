package com.example.CineTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository; // Repository for performing CRUD operations on Movie entities

    @Autowired
    private OMDbApiService omdbApiService; // Inject the OMDb API service with correct naming

    public List<Movie> getAllMovies() {
        return movieRepository.findAll(); // Delegate to repository to fetch all movies
    }

    public Movie getMovieById(String id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            // Movie not found locally, fetch it from OMDb API
            movie = omdbApiService.fetchMovieDetails(id); // Use the actual service
            if (movie != null) {
                LocalDateTime now = LocalDateTime.now();
                movie.setCreatedAt(now);
                movie.setUpdatedAt(now);
                movieRepository.save(movie); // Save the newly fetched movie
            }
        }
        return movie; // Return the movie (can be null if not found anywhere)
    }

    public Movie createMovie(Movie movie) {
        LocalDateTime now = LocalDateTime.now();
        movie.setCreatedAt(now);
        movie.setUpdatedAt(now);
        return movieRepository.save(movie);
    }

    public Movie updateMovie(String id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            movie.setTitle(movieDetails.getTitle());
            movie.setYear(movieDetails.getYear());
            movie.setGenre(movieDetails.getGenre());
            movie.setDirector(movieDetails.getDirector());
            movie.setActors(movieDetails.getActors());
            movie.setPlot(movieDetails.getPlot());
            movie.setPoster(movieDetails.getPoster());
            movie.setUpdatedAt(LocalDateTime.now());
            return movieRepository.save(movie);
        }
        return null;
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
}
