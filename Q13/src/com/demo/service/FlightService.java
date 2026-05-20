package com.demo.service;

import com.demo.dao.FlightDao;
import com.demo.model.Domestic;
import com.demo.model.Flight;
import com.demo.model.International;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FlightService {
    
    // The Manager needs a connection to the Filing Cabinet (DAO) so he can store things
    private FlightDao dao = new FlightDao();

    // a. Add a new flight
    public void addFlight(Flight flight) {
        dao.saveFlight(flight); // Tell the cabinet to store it
        System.out.println("Success: Flight added!");
    }

    // b. Remove a flight
    public void removeFlight(int flightId) {
        // Ask the cabinet to go find the flight first
        Flight flight = dao.getFlightById(flightId);
        
        if (flight != null) { // If the cabinet actually found it...
            dao.deleteFlight(flight); // Tell the cabinet to delete it
            System.out.println("Success: Flight removed!");
        } else {
            System.out.println("Error: Cannot find that flight ID.");
        }
    }

    // c. Change the ticket price
    public void updateFare(int flightId, double newFare) {
        Flight flight = dao.getFlightById(flightId); // Find the flight
        if (flight != null) {
            flight.setFare(newFare); // Change the price box
            System.out.println("Success: Fare updated!");
        } else {
            System.out.println("Error: Cannot find that flight ID.");
        }
    }

    // d. Book the flight
    public void bookFlight(int flightId) {
        Flight flight = dao.getFlightById(flightId); // Find the flight
        if (flight != null) {
            // Check the rule: Is the flight actually empty?
            if (flight.getStatus().equals("Available")) {
                flight.setStatus("Booked"); // Change the sign to Booked
                System.out.println("Success: Flight successfully booked!");
            } else {
                System.out.println("Sorry, that flight is already full/booked.");
            }
        } else {
            System.out.println("Error: Cannot find that flight ID.");
        }
    }

    // e. Cancel the booking
    public void cancelBooking(int flightId) {
        Flight flight = dao.getFlightById(flightId);
        if (flight != null) {
            // Check the rule: Is there actually a booking to cancel?
            if (flight.getStatus().equals("Booked")) {
                flight.setStatus("Available"); // Change the sign back to Available
                System.out.println("Success: Booking cancelled!");
            } else {
                System.out.println("That flight is already empty.");
            }
        } else {
            System.out.println("Error: Cannot find that flight ID.");
        }
    }

    // f. Show all flights on the screen
    public void displayAllFlights() {
        // Ask cabinet for all flights. If the bag is empty, tell the user.
        if (dao.getAllFlights().isEmpty()) {
            System.out.println("No flights in the system yet.");
            return; // Stop right here
        }
        
        // Loop through every flight in the bag and print its details
        for (Flight flight : dao.getAllFlights()) {
            System.out.println(flight.toString());
        }
    }

    // g. Show flights of a specific type
    public void displayByType(String type) {
        boolean found = false; // We use this to remember if we found anything
        
        for (Flight flight : dao.getAllFlights()) {
            // If the user typed "Domestic" AND the flight was built using the Domestic blueprint...
            if (type.equalsIgnoreCase("Domestic") && flight instanceof Domestic) {
                System.out.println(flight.toString());
                found = true; // We found one!
            } 
            // If the user typed "International" AND the flight was built using the International blueprint...
            else if (type.equalsIgnoreCase("International") && flight instanceof International) {
                System.out.println(flight.toString());
                found = true; // We found one!
            }
        }
        
        // If we looked at everything and found nothing, tell the user.
        if (!found) System.out.println("No flights found for type: " + type);
    }

    // h. Show flights that cost between a Minimum and Maximum price
    public void displayWithinFareRange(double min, double max) {
        boolean found = false;
        
        for (Flight flight : dao.getAllFlights()) {
            // Check the rule: Is the price greater than MIN, and also less than MAX?
            if (flight.getFare() >= min && flight.getFare() <= max) {
                System.out.println(flight.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No flights found in that budget.");
    }

    // i. Sort flights from cheapest to most expensive
    public void sortFlightsByFare() {
        // Grab all flights from the cabinet and put them in a temporary list to organize them
        ArrayList<Flight> listToSort = new ArrayList<>(dao.getAllFlights());
        
        if (listToSort.isEmpty()) {
            System.out.println("No flights to sort.");
            return;
        }

        // This is a built-in Java tool that organizes lists
        Collections.sort(listToSort, new Comparator<Flight>() {
            @Override
            public int compare(Flight f1, Flight f2) {
                // We tell Java: "Please organize these by comparing their Fares (prices)"
                return Double.compare(f1.getFare(), f2.getFare());
            }
        });

        // Print out the newly organized list
        System.out.println("--- Flights Sorted by Fare (Cheapest First) ---");
        for (Flight flight : listToSort) {
            System.out.println(flight.toString());
        }
    }

    // j. Search by Name
    public void searchByName(String searchName) {
        boolean found = false;
        for (Flight flight : dao.getAllFlights()) {
            // Convert both to lowercase so we don't worry about capital letters
            // .contains() checks if the letters the user typed match any part of the flight's name
            if (flight.getFlightName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Found: " + flight.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Sorry, couldn't find a flight with that name.");
    }
}