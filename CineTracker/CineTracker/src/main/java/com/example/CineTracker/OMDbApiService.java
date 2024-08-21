package com.example.CineTracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

// This service class handles communication with the OMDb API to fetch movie details.
@Service
public class OMDbApiService {

    // Injects the OMDb API key from the application properties file.
    @Value("${omdb.api.key}")
    private String apiKey;

    // Injects the OMDb API base URL from the application properties file.
    @Value("${omdb.api.url}")
    private String apiUrl;

    // RestTemplate is used to make HTTP requests to external services.
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Fetches movie details from the OMDb API using the provided movie ID.
     * 
     * @param movieId The ID of the movie to fetch details for.
     * @return A Movie object containing the movie details, or null if not found or an error occurs.
     */
    public Movie fetchMovieDetails(String movieId) {
        // Constructs the URL for the API request with the movie ID and API key.
        String url = String.format("%s?i=%s&apikey=%s", apiUrl, movieId, apiKey);
        try {
            // Sends a GET request to the OMDb API and parses the response into a Movie object.
            return restTemplate.getForObject(url, Movie.class);
        } catch (RestClientException e) {
            // Logs the error and returns null if an error occurs during the API request.
            
            System.err.println("Error fetching movie details: " + e.getMessage());
            return null;
        }
    }

    }

