package com.demo.test;

import com.demo.model.Domestic;
import com.demo.model.International;
import com.demo.service.FlightService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        
        // Tool to read what the user types on their physical keyboard
        Scanner keyboard = new Scanner(System.in);
        
        // Create our Manager (Service) so we can ask him to do the heavy lifting
        FlightService manager = new FlightService();

        // 'while (true)' creates an infinite loop. The menu will keep showing up forever
        // until the user specifically chooses the Exit option ('k') to break the loop.
        while (true) {
            // Print the menu to the screen
            System.out.println("\n=== Full Flight Menu ===");
            System.out.println("a. Add new Flight");
            System.out.println("b. Remove flight using flightId");
            System.out.println("c. Update flight fare");
            System.out.println("d. Book flight");
            System.out.println("e. Cancel booking");
            System.out.println("f. Display all flights");
            System.out.println("g. Display flights by type");
            System.out.println("h. Display flights within fare range");
            System.out.println("i. Sort flights by fare");
            System.out.println("j. Search flight by name");
            System.out.println("k. Exit");
            System.out.print("What would you like to do? Enter a letter: ");
            
            // Grab the very first letter the user typed, and force it to be lowercase
            char choice = keyboard.next().toLowerCase().charAt(0);
            
            // This clears out the invisible "Enter" key press so the scanner doesn't glitch on the next loop
            keyboard.nextLine(); 

            // 'switch' acts like a train track switch. It sends the code down a different path
            // depending on which letter the user typed.
            switch (choice) {
                case 'a': // User wants to add a flight
                    System.out.print("Enter Flight ID: ");
                    int id = keyboard.nextInt();
                    keyboard.nextLine(); // Clear the invisible enter key
                    
                    System.out.print("Enter Flight Name: ");
                    String name = keyboard.nextLine(); // Reads the whole sentence/name typed
                    
                    System.out.print("Enter Capacity (number of seats): ");
                    int capacity = keyboard.nextInt();
                    
                    System.out.print("Enter Fare: $");
                    double fare = keyboard.nextDouble();
                    
                    System.out.print("Type 1 for Domestic, 2 for International: ");
                    int type = keyboard.nextInt();
                    keyboard.nextLine(); // Clear the invisible enter key
                    
                    if (type == 1) { // They picked Domestic
                        System.out.print("Enter State Name: ");
                        String state = keyboard.nextLine();
                        System.out.print("Enter Terminal Number: ");
                        int terminal = keyboard.nextInt();
                        
                        // Create the Domestic flight and tell the manager to save it
                        manager.addFlight(new Domestic(id, name, capacity, fare, state, terminal));
                    } 
                    else if (type == 2) { // They picked International
                        System.out.print("Enter Country Name: ");
                        String country = keyboard.nextLine();
                        System.out.print("Is Passport Required? (type 'true' or 'false'): ");
                        boolean passport = keyboard.nextBoolean();
                        
                        // Create the International flight and tell the manager to save it
                        manager.addFlight(new International(id, name, capacity, fare, country, passport));
                    }
                    break; // 'break' means stop running code for case 'a' and go back to the menu

                case 'b': // User wants to remove a flight
                    System.out.print("Enter Flight ID to remove: ");
                    int removeId = keyboard.nextInt();
                    manager.removeFlight(removeId); // Tell manager to remove it
                    break;

                case 'c': // User wants to update the price
                    System.out.print("Enter Flight ID to update: ");
                    int updateId = keyboard.nextInt();
                    System.out.print("Enter New Fare: $");
                    double newFare = keyboard.nextDouble();
                    manager.updateFare(updateId, newFare); // Tell manager to change it
                    break;

                case 'd': // User wants to book a flight
                    System.out.print("Enter Flight ID to book: ");
                    manager.bookFlight(keyboard.nextInt());
                    break;

                case 'e': // User wants to cancel a booking
                    System.out.print("Enter Flight ID to cancel booking: ");
                    manager.cancelBooking(keyboard.nextInt());
                    break;

                case 'f': // User wants to see all flights
                    System.out.println("--- All Flights ---");
                    manager.displayAllFlights(); // Ask manager to print them
                    break;

                case 'g': // User wants to see flights by type
                    System.out.print("Enter Type (Domestic / International): ");
                    manager.displayByType(keyboard.nextLine());
                    break;

                case 'h': // User wants to see flights in a budget
                    System.out.print("Enter Minimum Fare: $");
                    double min = keyboard.nextDouble();
                    System.out.print("Enter Maximum Fare: $");
                    double max = keyboard.nextDouble();
                    manager.displayWithinFareRange(min, max);
                    break;

                case 'i': // User wants to sort the flights
                    manager.sortFlightsByFare();
                    break;

                case 'j': // User wants to search for a name
                    System.out.print("Enter part of the flight name to search for: ");
                    manager.searchByName(keyboard.nextLine());
                    break;

                case 'k': // User wants to Exit the program
                    System.out.println("Shutting down Flight System. Have a safe trip!");
                    keyboard.close(); // Turn off the keyboard reader
                    System.exit(0);   // Shut down the Java program completely

                default: // User typed a letter that doesn't exist in our menu
                    System.out.println("Invalid letter! Please choose an option from a to k.");
            }
        }
    }
}