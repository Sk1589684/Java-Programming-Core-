package com.demo.model;

//This is the basic blueprint for ANY movie
public class Movie {
 
 // These are locked storage boxes to hold the movie's details
 private int movieId;
 private String movieName;
 private double duration; // Time in hours
 private double rating;   // Rating out of 10
 private String status;   // "Available" or "Unavailable"

 // This is the setup step. When we create a new movie, we fill these boxes.
 public Movie(int movieId, String movieName, double duration, double rating) {
     this.movieId = movieId;
     this.movieName = movieName;
     this.duration = duration;
     this.rating = rating;
     this.status = "Available"; // Every brand new movie is automatically available
 }

 // "Getters" are safe ways to read what is inside the locked boxes
 public int getMovieId() { return movieId; }
 public String getMovieName() { return movieName; }
 public double getDuration() { return duration; }
 public double getRating() { return rating; }
 public String getStatus() { return status; }

 // "Setters" are safe ways to change what is inside a box later on
 public void setRating(double rating) { this.rating = rating; }
 public void setStatus(String status) { this.status = status; }

 // This tells Java how to print the movie details as a neat text sentence
 @Override
 public String toString() {
     return "ID: " + movieId + " | Name: " + movieName + 
            " | Time: " + duration + "h | Rating: " + rating + " | Status: " + status;
 }
}