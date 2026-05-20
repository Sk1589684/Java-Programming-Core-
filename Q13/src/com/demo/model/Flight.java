package com.demo.model;

//This is the basic blueprint. ANY flight in our system will have these details.
public class Flight {
 
 // 'private' means these boxes are locked. No one can change them by accident.
 private int flightId;      // Holds the flight number (like 101)
 private String flightName; // Holds the name (like Air India)
 private int capacity;      // Holds the number of seats on the plane
 private double fare;       // Holds the ticket price (like 500.50)
 private String status;     // Holds "Available" or "Booked"

 // This is the "Setup Machine" (Constructor). 
 // When we make a brand new flight, we must provide these 4 pieces of information.
 public Flight(int flightId, String flightName, int capacity, double fare) {
     this.flightId = flightId;         // Save the ID we were given
     this.flightName = flightName;     // Save the name we were given
     this.capacity = capacity;         // Save the capacity we were given
     this.fare = fare;                 // Save the price we were given
     this.status = "Available";        // A brand new flight is always "Available" at first
 }

 // "Getters": Since the boxes are locked (private), these methods are safe peepholes 
 // to let us look at what is inside the boxes.
 public int getFlightId() { return flightId; }
 public String getFlightName() { return flightName; }
 public int getCapacity() { return capacity; }
 public double getFare() { return fare; }
 public String getStatus() { return status; }

 // "Setters": Safe doors that let us change the value inside the box later.
 public void setFare(double fare) { this.fare = fare; }
 public void setStatus(String status) { this.status = status; }

 // This takes all the boxes and turns them into one neat English sentence for printing.
 @Override
 public String toString() {
     return "ID: " + flightId + " | Name: " + flightName + 
            " | Seats: " + capacity + " | Fare: $" + fare + " | Status: " + status;
 }
}