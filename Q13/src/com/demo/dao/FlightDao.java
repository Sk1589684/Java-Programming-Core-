package com.demo.dao;

import com.demo.model.Flight;
import java.util.ArrayList;

public class FlightDao {
    
    // An ArrayList is like a magic, stretchable digital bag. We will put all our flights in here.
    private ArrayList<Flight> flightDatabase = new ArrayList<>();

    // Take a new flight and toss it into the digital bag
    public void saveFlight(Flight flight) {
        flightDatabase.add(flight);
    }

    // Find a specific flight and throw it out of the bag
    public void deleteFlight(Flight flight) {
        flightDatabase.remove(flight);
    }

    // Unzip the bag and hand over ALL the flights inside it
    public ArrayList<Flight> getAllFlights() {
        return flightDatabase;
    }

    // Dig through the bag to find one specific flight using its ID number
    public Flight getFlightById(int flightId) {
        // Look at every single flight in the bag, one by one
        for (Flight flight : flightDatabase) {
            // Does this flight's ID match the one we are looking for?
            if (flight.getFlightId() == flightId) {
                return flight; // Yes! Hand it over and stop looking.
            }
        }
        return null; // We looked through the whole bag and found nothing.
    }
}
