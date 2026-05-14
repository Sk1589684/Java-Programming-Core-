package com.demo.model;

//Borrows the basic boxes from Movie
public class Hollywood extends Movie {
 
 // Extra boxes only for Hollywood movies
 private String studioName;
 private double budget;

 // Setup step for a Hollywood movie
 public Hollywood(int movieId, String movieName, double duration, double rating, String studioName, double budget) {
     // Give basic details to the parent
     super(movieId, movieName, duration, rating); 
     
     // Save the extra Hollywood details
     this.studioName = studioName;
     this.budget = budget;
 }

 // Add the extra Hollywood details to the printed sentence
 @Override
 public String toString() {
     return "[Hollywood] " + super.toString() + " | Studio: " + studioName + " | Budget: $" + budget + "M";
 }
}