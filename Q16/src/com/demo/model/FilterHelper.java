package com.demo.model;

import java.util.ArrayList;
import java.io.FileWriter;

public class FilterHelper {

    // 1. Find all strings that have at least one character repeated
    public ArrayList<String> getRepeatedCharStrings(ArrayList<String> mainList) {
        // Create an empty list for list2
        ArrayList<String> list2 = new ArrayList<>();
        
        for (String word : mainList) {
            boolean hasRepeat = false;
            
            // Look at each letter in the word one by one
            for (int i = 0; i < word.length(); i++) {
                char currentLetter = word.charAt(i);
                
                // Compare this letter to all the letters that come AFTER it
                for (int j = i + 1; j < word.length(); j++) {
                    if (currentLetter == word.charAt(j)) {
                        hasRepeat = true; // We found a match!
                        break; // Stop looking, we already know it repeats
                    }
                }
                
                // If we found a repeat, stop checking this word completely
                if (hasRepeat) {
                    break;
                }
            }
            
            // If the word had a repeated letter, put it in list2
            if (hasRepeat) {
                list2.add(word);
            }
        }
        return list2; // Hand over the finished list
    }

    // 2. Find all strings that have NO vowels
    public ArrayList<String> getNoVowelStrings(ArrayList<String> mainList) {
        // Create an empty list for list3
        ArrayList<String> list3 = new ArrayList<>();
        
        for (String word : mainList) {
            // Make the word lowercase so we don't have to check capital A, E, I, O, U separately
            String lowerWord = word.toLowerCase();
            boolean hasVowel = false;
            
            // Check every single letter in the word
            for (int i = 0; i < lowerWord.length(); i++) {
                char letter = lowerWord.charAt(i);
                
                // If the letter is a vowel, mark it and stop checking
                if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                    hasVowel = true;
                    break; 
                }
            }
            
            // If we finished checking the word and found zero vowels (and it's not empty), add it to list3!
            if (!hasVowel && !word.isEmpty()) {
                list3.add(word);
            }
        }
        return list3; // Hand over the finished list
    }

    // 3. Save a list into a text file
    public void saveToFile(ArrayList<String> list, String filename) {
        try {
            // Open the file (Java will create it if it doesn't exist)
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
