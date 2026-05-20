package com.demo.model;

//'extends' means Domestic flight borrows all the basic boxes from the main Flight class
public class Domestic extends Flight {
 
 // Extra boxes that ONLY Domestic flights have
 private String stateName;       // Which state it flies within
 private int terminalNumber;     // Which gate/terminal to go to

 // Setup machine for a Domestic flight
 public Domestic(int flightId, String flightName, int capacity, double fare, String stateName, int terminalNumber) {
     // 'super' means: "Give the basic details to the parent (Flight) to handle"
     super(flightId, flightName, capacity, fare);
     
     // Save the extra Domestic details
     this.stateName = stateName;
     this.terminalNumber = terminalNumber;
 }

 // Add the extra Domestic details to the end of our printed sentence
 @Override
 public String toString() {
     return "[Domestic] " + super.toString() + " | State: " + stateName + " | Terminal: " + terminalNumber;
 }
}
