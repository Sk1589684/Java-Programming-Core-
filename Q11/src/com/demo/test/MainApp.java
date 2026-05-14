package com.demo.test;

import com.demo.model.Bollywood;
import com.demo.model.Hollywood;
import com.demo.service.MovieService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        
        // Tool to read what the user types on the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        // Create our Manager (Service) so we can ask him to do things
        MovieService manager = new MovieService();

        // An infinite loop so the menu keeps showing up until the user quits
        while (true) {
            // Print the FULL menu text
            System.out.println("\n=== Full Movie Menu ===");
            System.out.println("a. Add new Movie");
            System.out.println("b. Remove movie using movieId");
            System.out.println("c. Update movie rating");
            System.out.println("d. Mark movie unavailable");
            System.out.println("e. Recommend movie (by rating & type)");
            System.out.println("f. Display all movies");
            System.out.println("g. Display movies by type");
            System.out.println("h. Display movies with rating above...");
            System.out.println("i. Sort movies by duration");
            System.out.println("j. Search movie by name");
            System.out.println("k. Exit");
            System.out.print("What would you like to do? Enter a letter: ");
            
            // Read the letter the user typed and force it to be lowercase
            char choice = keyboard.next().toLowerCase().charAt(0);
            
            // Clear out the hidden "Enter" key press so the scanner doesn't glitch
            keyboard.nextLine(); 
            
            // Do an action based on the letter chosen
            switch (choice) {
                
                case 'a': // ADD A NEW MOVIE
                    System.out.print("Enter Movie ID number: ");
                    int id = keyboard.nextInt();
                    keyboard.nextLine(); // Clear the enter key
                    
                    System.out.print("Enter Movie Name: ");
                    String name = keyboard.nextLine();
                    
                    System.out.print("Enter Duration (Example: 2.5 for two and a half hours): ");
                    double time = keyboard.nextDouble();
                    
                    System.out.print("Enter Rating (out of 10): ");
                    double rating = keyboard.nextDouble();
                    
                    System.out.print("Type 1 for Bollywood, or 2 for Hollywood: ");
                    int type = keyboard.nextInt();
                    keyboard.nextLine(); // Clear the enter key
                    
                    if (type == 1) { 
                        // Ask for the extra Bollywood details
                        System.out.print("Enter the Language: ");
                        String lang = keyboard.nextLine();
                        System.out.print("Enter the Lead Actor's name: ");
                        String actor = keyboard.nextLine();
                        
                        // Create the movie and give it to the manager to save
                        manager.addMovie(new Bollywood(id, name, time, rating, lang, actor));
                    } 
                    else if (type == 2) { 
                        // Ask for the extra Hollywood details
                        System.out.print("Enter the Studio Name (e.g., Marvel, Fox): ");
                        String studio = keyboard.nextLine();
                        System.out.print("Enter the Budget (in millions): ");
                        double budget = keyboard.nextDouble();
                        
                        // Create the movie and give it to the manager to save
                        manager.addMovie(new Hollywood(id, name, time, rating, studio, budget));
                    }
                    break; 

                case 'b': // REMOVE A MOVIE
                    System.out.print("Enter the Movie ID you want to remove: ");
                    int removeId = keyboard.nextInt();
                    manager.removeMovie(removeId); 
                    break; 

                case 'c': // UPDATE RATING
                    System.out.print("Enter the Movie ID to update: ");
                    int updateId = keyboard.nextInt();
                    System.out.print("Enter the NEW Rating (out of 10): ");
                    double newRating = keyboard.nextDouble();
                    manager.updateRating(updateId, newRating); 
                    break; 

                case 'd': // MARK UNAVAILABLE
                    System.out.print("Enter the Movie ID to mark as unavailable: ");
                    int unavailableId = keyboard.nextInt();
                    manager.markUnavailable(unavailableId); 
                    break;

                case 'e': // RECOMMEND MOVIE
                    System.out.print("Enter the Minimum Rating you want (e.g., 8.0): ");
                    double minRating = keyboard.nextDouble();
                    keyboard.nextLine(); // Clear the enter key
                    
                    System.out.print("What type? (Type 'Bollywood' or 'Hollywood'): ");
                    String recType = keyboard.nextLine();
                    
                    manager.recommendMovie(minRating, recType); 
                    break;

                case 'f': // DISPLAY ALL
                    System.out.println("--- List of ALL Movies ---");
                    manager.displayAllMovies(); 
                    break; 

                case 'g': // DISPLAY BY TYPE
                    System.out.print("Which type do you want to see? (Bollywood / Hollywood): ");
                    String displayType = keyboard.nextLine();
                    manager.displayByType(displayType); 
                    break;

                case 'h': // DISPLAY RATING ABOVE X
                    System.out.print("Show me movies with a rating strictly higher than: ");
                    double cutoffRating = keyboard.nextDouble();
                    manager.displayAboveRating(cutoffRating); 
                    break;

                case 'i': // SORT BY DURATION
                    manager.sortMoviesByDuration(); 
                    break;

                case 'j': // SEARCH BY NAME
                    System.out.print("Enter part of the movie's name to search for: ");
                    String searchName = keyboard.nextLine();
                    manager.searchByName(searchName); 
                    break;

                case 'k': // EXIT
                    System.out.println("Turning off the Movie System. Have a great day!");
                    keyboard.close(); // Turn off the keyboard reader
                    System.exit(0);   // Shut down the program completely

                default: // USER TYPED A BAD LETTER
                    System.out.println("Invalid letter! Please choose an option from a to k.");
            }
        }
    }
}