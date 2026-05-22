package com.demo.model;

import java.util.Stack;
import java.util.ArrayList;
import java.io.FileWriter;

public class StackHelper {

    // 1. Find all palindrome strings
    public ArrayList<String> getPalindromes(Stack<String> mainStack) {
        // Create an empty list for list2
        ArrayList<String> list2 = new ArrayList<>();
        
        for (String word : mainStack) {
            // A quick trick to spell a word backwards in Java
            String backwardsWord = new StringBuilder(word).reverse().toString();
            
            // Check if the original word matches the backwards word
            // We use "equalsIgnoreCase" so "Radar" and "radar" are treated as the same
            if (!word.isEmpty() && word.equalsIgnoreCase(backwardsWord)) {
                list2.add(word); // Put it in list2
            }
        }
        return list2; // Hand over the finished list
    }

    // 2. Find all strings that have at least one blank space inside them
    public ArrayList<String> getStringsWithSpaces(Stack<String> mainStack) {
        // Create an empty list for list3
        ArrayList<String> list3 = new ArrayList<>();
        
        for (String word : mainStack) {
            // The contains() tool easily checks if there is a space anywhere inside
            if (word.contains(" ")) {
                list3.add(word); // Put it in list3
            }
        }
        return list3; // Hand over the finished list
    }

    // 3. Save a list into a text file
    public void saveToFile(ArrayList<String> list, String filename) {
        try {
            // Open the file (Java will automatically create it if it doesn't exist)
            FileWriter writer = new FileWriter(filename);
            
            // Write each word from the list into the file, moving to a new line each time
            for (String word : list) {
                writer.write(word + "\n");
            }
            
            // Close the file so it saves properly
            writer.close();
            
        } catch (Exception e) {
            // If something goes wrong, print the error
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}