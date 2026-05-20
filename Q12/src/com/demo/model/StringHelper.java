package com.demo.model;

import java.util.ArrayList;
import java.io.FileWriter;

public class StringHelper {

    // 1. Find all strings that contain the word "java"
    public ArrayList<String> getJavaStrings(ArrayList<String> mainList) {
        // Create an empty ArrayList for list2
        ArrayList<String> list2 = new ArrayList<>();
        
        for (String word : mainList) {
            // Check if the string contains the exact letters "java"
            // (We make it lowercase first so it can catch "Java", "JAVA", or "java")
            if (word.toLowerCase().contains("java")) {
                list2.add(word); // Put it in list2
            }
        }
        return list2; // Return the finished list
    }

    // 2. Find all strings that are ONLY in uppercase letters
    public ArrayList<String> getUpperCaseStrings(ArrayList<String> mainList) {
        // Create an empty ArrayList for list3
        ArrayList<String> list3 = new ArrayList<>();
        
        for (String word : mainList) {
            // Check if the word is exactly the same as its uppercase version
            // We also make sure the word isn't empty
            if (!word.isEmpty() && word.equals(word.toUpperCase())) {
                // To be extra safe, make sure it actually has alphabet letters in it 
                // (so a number like "123" doesn't accidentally count as an uppercase word)
                if (word.matches(".*[A-Z].*")) {
                    list3.add(word); // Put it in list3
                }
            }
        }
        return list3; // Return the finished list
    }

    // 3. Save an ArrayList into a text file
    public void saveToFile(ArrayList<String> list, String filename) {
        try {
            // Open the file (Java will create it if it doesn't exist yet)
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
