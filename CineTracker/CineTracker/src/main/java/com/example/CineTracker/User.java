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
import jakarta.persistence.Table;

/**
 * Entity class representing a user in the CineTracker application.
 * 
 * This class maps to the 'users' table in the database and contains user-related information.
 */
@Entity
@Table(name = "users") // Specifies the name of the table in the database
@Data // Generates getters, setters, equals, hashCode, and toString methods
@NoArgsConstructor // Generates a no-arguments constructor
@AllArgsConstructor // Generates a constructor with all fields as parameters
public class User {

    /**
     * Unique identifier for the user. This is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates values for this field
    private Long id;

    /**
     * Username of the user. This field must be unique and cannot be null.
     */
    @Column(nullable = false, unique = true) // Specifies that this column cannot be null and must be unique
    private String username;

    /**
     * Password of the user. This field cannot be null.
     */
    @Column(nullable = false) // Specifies that this column cannot be null
    private String password;

    /**
     * Email address of the user. This field must be unique and cannot be null.
     */
    @Column(nullable = false, unique = true) // Specifies that this column cannot be null and must be unique
    private String email;

    /**
     * The date and time when the user was created.
     */
    private LocalDateTime createdAt;

    /**
     * The date and time when the user was last updated.
     */
    private LocalDateTime updatedAt;
}
