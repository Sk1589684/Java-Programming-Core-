package com.demo.dao;

import com.demo.model.Movie;
import java.util.TreeMap;
import java.util.Collection;

public class MovieDao {
    
    // This is our filing cabinet. A TreeMap automatically sorts files by their ID number!
    private TreeMap<Integer, Movie> movieDatabase = new TreeMap<>();

    // Put a new movie file into the cabinet
    public void saveMovie(Movie movie) {
        // We use the Movie ID as the unique label on the file folder
        movieDatabase.put(movie.getMovieId(), movie);
    }

    // Throw a movie file out of the cabinet
    public void deleteMovie(int movieId) {
        movieDatabase.remove(movieId);
    }

    // Grab ALL the movie files from the cabinet to look at them
    public Collection<Movie> getAllMovies() {
        return movieDatabase.values(); // "values" means hand over the movies, not the ID labels
    }

    // Find one specific movie file using its ID number
    public Movie getMovieById(int movieId) {
        return movieDatabase.get(movieId); // Grab it and hand it over
    }
}