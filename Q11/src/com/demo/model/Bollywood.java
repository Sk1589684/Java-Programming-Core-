package com.demo.model;

//The word "extends" means Bollywood borrows all the basic boxes from Movie
public class Bollywood extends Movie {
 
 // Extra boxes only for Bollywood movies
 private String language;
 private String leadActor;

 // Setup step for a Bollywood movie
 public Bollywood(int movieId, String movieName, double duration, double rating, String language, String leadActor) {
     // "super" means give the basic details to the parent (Movie) to handle
     super(movieId, movieName, duration, rating); 
     
     // Save the extra Bollywood details
     this.language = language;
     this.leadActor = leadActor;
 }

 // Add the extra Bollywood details to the printed sentence
 @Override
 public String toString() {
     return "[Bollywood] " + super.toString() + " | Lang: " + language + " | Actor: " + leadActor;
 }
}
