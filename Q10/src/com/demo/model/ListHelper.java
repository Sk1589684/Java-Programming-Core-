package com.demo.model;

import java.util.LinkedList;
import java.io.FileWriter;

public class ListHelper {
	
	// 1. Find all strings starting and ending with the same character
    public LinkedList<String> getSameCharList(LinkedList<String> mainList) {
        // Create an empty LinkedList for list2
        LinkedList<String> list2 = new LinkedList<>();
        
        for (String word : mainList) {
            // Check if the word is not empty
            if (word.length() > 0) {
                // Get the very first letter and the very last letter
                // We make them lowercase so "Apple" (A and e) or "Anna" (A and a) can be compared easily
                char firstLetter = Character.toLowerCase(word.charAt(0));
                char lastLetter = Character.toLowerCase(word.charAt(word.length() - 1));
                
                // If they match, add the word to list2
                if (firstLetter == lastLetter) {
                    list2.add(word);
                }
            }
        }
        return list2; 
    }

    // 2. Find all strings that have ONLY digits (numbers)
    public LinkedList<String> getDigitsList(LinkedList<String> mainList) {
        // Create an empty LinkedList for list3
        LinkedList<String> list3 = new LinkedList<>();
        
        for (String word : mainList) {
            // Check if the word is not empty
            if (word.length() > 0) {
                // The matches("[0-9]+") rule checks if every single character is a number from 0 to 9
                if (word.matches("[0-9]+")) {
                    list3.add(word);
                }
            }
        }
        return list3; 
    }

    // 3. Save a LinkedList into a text file
    public void saveToFile(LinkedList<String> list, String filename) {
        try {
            // Open the file (it will create it if it doesn't exist)
            FileWriter writer = new FileWriter(filename);
            
            // Write each word into the file, moving to a new line each time
            for (String word : list) {
                writer.write(word + "\n");
            }
            
            // Close the file to save it safely
            writer.close();
            
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

}
