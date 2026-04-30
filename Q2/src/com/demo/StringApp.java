package com.demo;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;   // Tool to write data into a file
import java.io.IOException;  // Tool to handle file saving errors

public class StringApp {

    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        // Step 1: Create our three digital bags (ArrayLists)
        ArrayList<String> list1 = new ArrayList<>(); // Holds ALL strings from the user
        ArrayList<String> list2 = new ArrayList<>(); // Holds strings with length > 5
        ArrayList<String> list3 = new ArrayList<>(); // Holds strings starting with a vowel
        
        System.out.println("=== String & File Processing System ===");
        System.out.println("Type as many words/sentences as you want.");
        System.out.println("Type the word 'STOP' when you are finished.\n");
        
        // Step 2: Accept strings from the user
        while (true) {
            System.out.print("Enter a string: ");
            String userInput = keyboard.nextLine();
            
            // If the user types 'STOP', we break out of the loop and stop asking
            if (userInput.equalsIgnoreCase("STOP")) {
                break;
            }
            
            // Add the typed string to our main bag (list1)
            list1.add(userInput);
        }
        
        // Step 3: Sort the strings into list2 and list3
        // We look at every single string inside list1, one by one
        for (String word : list1) {
            
            // Check Rule A: Is the length greater than 5?
            if (word.length() > 5) {
                list2.add(word); // Put a copy in list2
            }
            
            // Check Rule B: Does it start with a vowel?
            // First, make sure the word isn't completely empty to avoid a crash
            if (!word.isEmpty()) {
                // Grab the very first letter and make it lowercase to make checking easier
                char firstLetter = word.toLowerCase().charAt(0);
                
                // If the first letter is a, e, i, o, or u...
                if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || 
                    firstLetter == 'o' || firstLetter == 'u') {
                    
                    list3.add(word); // Put a copy in list3
                }
            }
        }
        
        // Step 4: Display both lists on the screen
        System.out.println("\n--- Sorting Complete ---");
        System.out.println("List 2 (Length > 5): " + list2);
        System.out.println("List 3 (Starts with Vowel): " + list3);
        
        // Step 5 & 6: Write the lists into actual text files on your computer
        System.out.println("\nSaving data to files...");
        
        // Save list2 to "data1.txt"
        saveToFile(list2, "data1.txt");
        
        // Save list3 to "data2.txt"
        saveToFile(list3, "data2.txt");
        
        System.out.println("Done! Check your project folder for data1.txt and data2.txt.");
        keyboard.close();
    }
    
    // --------------------------------------------------------
    // HELPER METHOD to save any list into any file
    // --------------------------------------------------------
    public static void saveToFile(ArrayList<String> list, String filename) {
        // "try" means Java will ATTEMPT to open the file. 
        // If your computer blocks it (like a permissions issue), it won't crash the program.
        try {
            // Create a Writer tool and point it at the filename we want
            FileWriter writer = new FileWriter(filename);
            
            // Go through every word in the list
            for (String word : list) {
                writer.write(word + "\n"); // Write the word, then press "Enter" (\n) for a new line
            }
            
            // Always close the file when you are done, or it might not save properly!
            writer.close(); 
            
        } catch (IOException e) {
            // If something goes wrong with the computer's hard drive, print this error
            System.out.println("An error occurred while trying to save " + filename);
        }
    }
}
