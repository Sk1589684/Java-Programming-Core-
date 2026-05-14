package com.demo.service;

import com.demo.dao.MovieDao;
import com.demo.model.Bollywood;
import com.demo.model.Hollywood;
import com.demo.model.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MovieService {
    
    // The Manager connects to the Filing Cabinet (DAO) to save and find things
    private MovieDao dao = new MovieDao();

    // a. Add a new Movie
    public void addMovie(Movie movie) {
        dao.saveMovie(movie); // Tell the cabinet to save it
        System.out.println("Success: Movie added!");
    }

    // b. Remove a movie
    public void removeMovie(int movieId) {
        Movie movie = dao.getMovieById(movieId); // Look for the movie
        if (movie != null) { 
            dao.deleteMovie(movieId); // Throw it away
            System.out.println("Success: Movie removed!");
        } else {
            System.out.println("Error: Cannot find that movie ID.");
        }
    }

    // c. Change the rating
    public void updateRating(int movieId, double newRating) {
        Movie movie = dao.getMovieById(movieId); 
        if (movie != null) {
            movie.setRating(newRating); // Update the number inside the box
            System.out.println("Success: Rating updated!");
        } else {
            System.out.println("Error: Cannot find that movie ID.");
        }
    }

    // d. Mark as unavailable
    public void markUnavailable(int movieId) {
        Movie movie = dao.getMovieById(movieId); 
        if (movie != null) {
            movie.setStatus("Unavailable"); // Change the status text
            System.out.println("Success: Movie is now unavailable!");
        } else {
            System.out.println("Error: Cannot find that movie ID.");
        }
    }

    // e. Recommend movie (THIS FIXES YOUR ERROR!)
    // Notice how it asks for the number (double) first, and the text (String) second!
    public void recommendMovie(double minRating, String type) {
        boolean found = false;
        
        // Look at every single movie in our cabinet
        for (Movie movie : dao.getAllMovies()) {
            
            // Step 1: Is the rating high enough?
            if (movie.getRating() >= minRating) {
                
                // Step 2: Is it a Bollywood movie, and did the user ask for Bollywood?
                if (type.equalsIgnoreCase("Bollywood") && movie instanceof Bollywood) {
                    System.out.println("We recommend: " + movie.toString());
                    found = true;
                } 
                // Step 3: Is it a Hollywood movie, and did the user ask for Hollywood?
                else if (type.equalsIgnoreCase("Hollywood") && movie instanceof Hollywood) {
                    System.out.println("We recommend: " + movie.toString());
                    found = true;
                }
            }
        }
        
        // If we looked at everything and found nothing, tell the user
        if (!found) {
            System.out.println("Sorry, no movies match that rating and type.");
        }
    }

    // f. Print all movies to the screen
    public void displayAllMovies() {
        if (dao.getAllMovies().isEmpty()) {
            System.out.println("No movies in the database yet.");
            return;
        }
        for (Movie movie : dao.getAllMovies()) {
            System.out.println(movie.toString());
        }
    }

    // g. Print movies by a specific type (Bollywood or Hollywood)
    public void displayByType(String type) {
        boolean found = false;
        for (Movie movie : dao.getAllMovies()) {
            if (type.equalsIgnoreCase("Bollywood") && movie instanceof Bollywood) {
                System.out.println(movie.toString());
                found = true;
            } else if (type.equalsIgnoreCase("Hollywood") && movie instanceof Hollywood) {
                System.out.println(movie.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No movies found for that type.");
    }

    // h. Display movies with a rating above a certain number
    public void displayAboveRating(double rating) {
        boolean found = false;
        for (Movie movie : dao.getAllMovies()) {
            if (movie.getRating() > rating) {
                System.out.println(movie.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No movies found above that rating.");
    }

    // i. Sort movies from shortest to longest duration
    public void sortMoviesByDuration() {
        // Put movies in a temporary list to organize them
        ArrayList<Movie> listToSort = new ArrayList<>(dao.getAllMovies());
        
        if (listToSort.isEmpty()) {
            System.out.println("No movies to sort.");
            return;
        }

        // Organize the list by comparing durations
        Collections.sort(listToSort, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return Double.compare(m1.getDuration(), m2.getDuration());
            }
        });

        System.out.println("--- Movies Sorted by Duration (Shortest to Longest) ---");
        for (Movie movie : listToSort) {
            System.out.println(movie.toString());
        }
    }

    // j. Search movie by name
    public void searchByName(String searchName) {
        boolean found = false;
        for (Movie movie : dao.getAllMovies()) {
            // Check if the typed letters are part of the movie's real name
            if (movie.getMovieName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Found: " + movie.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Sorry, couldn't find a movie with that name.");
    }
}