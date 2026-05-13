package com.demo.model;
import java.util.Vector;
import java.util.Scanner;
import java.io.FileWriter;

public class StringProcessor {
public static void main(String[] args) {
		
		// Create scanner to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Create the main Vector to hold user inputs
        Vector<String> mainList = new Vector<>();

        // Ask user how many words they want to enter
        System.out.print("How many strings do you want to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Clear the hidden enter key press

        // Collect strings from the user
        System.out.println("Please enter your strings:");
        for (int i = 0; i < count; i++) {
            String word = scanner.nextLine();
            mainList.add(word); // Store in main vector
        }

        // --- PERFORM OPERATIONS ---
        
        // 1. Get uppercase strings -> list2
        Vector<String> list2 = getUpperCaseList(mainList);

        // 2. Get strings ending with vowel -> list3
        Vector<String> list3 = getVowelEndingList(mainList);

        // 3. Display both lists on the screen
        System.out.println("\n--- Results ---");
        System.out.println("List 2 (Uppercase strings) : " + list2);
        System.out.println("List 3 (Ends with vowel)   : " + list3);

        // 4. Write list2 into "upper.txt"
        saveToFile(list2, "upper.txt");
        System.out.println("Saved list2 to upper.txt");

        // 5. Write list3 into "vowel.txt"
        saveToFile(list3, "vowel.txt");
        System.out.println("Saved list3 to vowel.txt");

        // Close the scanner
        scanner.close();
    }

    // --------------------------------------------------------
    // HELPER METHODS (Placed in the same file for simplicity)
    // --------------------------------------------------------

    // Method to find all uppercase strings
    public static Vector<String> getUpperCaseList(Vector<String> mainList) {
        // Create an empty Vector for list2
        Vector<String> list2 = new Vector<>();
        
        // Loop through each string in the main list
        for (String word : mainList) {
            // If the word is exactly the same as its uppercase version, add it
            if (word.equals(word.toUpperCase())) {
                list2.add(word);
            }
        }
        return list2; 
    }

    // Method to find strings ending with a vowel
    public static Vector<String> getVowelEndingList(Vector<String> mainList) {
        // Create an empty Vector for list3
        Vector<String> list3 = new Vector<>();
        
        // Loop through each string in the main list
        for (String word : mainList) {
            // Convert word to lowercase so we don't have to check capital vowels too
            String lowerWord = word.toLowerCase();
            
            // Check if the word ends with a, e, i, o, or u
            if (lowerWord.endsWith("a") || lowerWord.endsWith("e") || 
                lowerWord.endsWith("i") || lowerWord.endsWith("o") || 
                lowerWord.endsWith("u")) {
                
                list3.add(word); 
            }
        }
        return list3; 
    }

    // Method to save a Vector into a text file
    public static void saveToFile(Vector<String> list, String filename) {
        try {
            // Open the file
            FileWriter writer = new FileWriter(filename);
            
            // Write each word from the list into the file
            for (String word : list) {
                writer.write(word + "\n"); // "\n" moves to the next line
            }
            
            // Close the file to save it safely
            writer.close();
            
        } catch (Exception e) {
            // If something goes wrong, print the error
            System.out.println("Error saving file: " + e);
        }
		
	}

}
