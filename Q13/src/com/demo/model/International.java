package com.demo.model;

//Borrows the basic boxes from the main Flight class
public class International extends Flight {
 
 // Extra boxes that ONLY International flights have
 private String countryName;         // Which country it is going to
 private boolean passportRequired;   // True if you need a passport, False if not

 // Setup machine for an International flight
 public International(int flightId, String flightName, int capacity, double fare, String countryName, boolean passportRequired) {
     // Give the basic details to the parent
     super(flightId, flightName, capacity, fare);
     
     // Save the extra International details
     this.countryName = countryName;
     this.passportRequired = passportRequired;
 }

 // Add the extra International details to the end of our printed sentence
 @Override
 public String toString() {
     // If passportRequired is true, say "Yes". Otherwise, say "No".
     String passportText = passportRequired ? "Yes" : "No";
     return "[International] " + super.toString() + " | Country: " + countryName + " | Passport Needed: " + passportText;
 }
}
