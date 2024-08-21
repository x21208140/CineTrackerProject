package com.example.CineTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This class is a REST controller that handles HTTP requests related to movie operations.
@RestController
@RequestMapping("/api/movies") // Base URL for all endpoints in this controller.
public class MovieController {

    // Injects the MovieService bean, which contains business logic for movie operations.
    @Autowired
    private MovieService movieService;

    // Handles HTTP GET requests to retrieve all movies.
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies(); // Delegates to the service layer to fetch all movies.
    }

    // Handles HTTP GET requests to retrieve a specific movie by its ID.
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
        Movie movie = movieService.getMovieById(id); // Fetches the movie by ID using the service.
        if (movie != null) {
            return ResponseEntity.ok(movie); // Returns 200 OK with the movie data if found.
        }
        return ResponseEntity.notFound().build(); // Returns 404 Not Found if the movie does not exist.
    }

    // Handles HTTP POST requests to create a new movie entry.
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie); // Delegates to the service layer to save the new movie.
    }

    // Handles HTTP PUT requests to update an existing movie's details.
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String id, @RequestBody Movie movieDetails) {
        Movie updatedMovie = movieService.updateMovie(id, movieDetails); // Updates the movie using the service.
        if (updatedMovie != null) {
            return ResponseEntity.ok(updatedMovie); // Returns 200 OK with updated movie data if successful.
        }
        return ResponseEntity.notFound().build(); // Returns 404 Not Found if the movie does not exist.
    }

    // Handles HTTP DELETE requests to remove a movie by its ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id); // Delegates to the service layer to delete the movie.
        return ResponseEntity.noContent().build(); // Returns 204 No Content indicating successful deletion.
    }
}
