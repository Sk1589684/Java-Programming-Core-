package com.demo.test;

import com.demo.model.FilterHelper;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        
        // Tool to read what the user types
        Scanner keyboard = new Scanner(System.in);
        
        // Create our main ArrayList to hold all the initial strings
        ArrayList<String> mainList = new ArrayList<>();
        
        // Create our helper object to do the checking and saving
        FilterHelper helper = new FilterHelper();

        System.out.println("--- String Filter Application ---");
        System.out.print("How many strings do you want to enter? ");
        int count = keyboard.nextInt();
        keyboard.nextLine(); // Clear the hidden "Enter" key press

        // Collect strings from the user
        System.out.println("Please enter your strings:");
        for (int i = 0; i < count; i++) {
            String word = keyboard.nextLine();
            mainList.add(word); // Store it in the main list
        }

        // --- PERFORM THE OPERATIONS ---
        
        // Create list2 (Strings with repeated characters)
        ArrayList<String> list2 = helper.getRepeatedCharStrings(mainList);

        // Create list3 (Strings with no vowels)
        ArrayList<String> list3 = helper.getNoVowelStrings(mainList);

        // Display both lists on the screen
        System.out.println("\n--- Results ---");
        System.out.println("List 2 (Has repeated letters) : " + list2);
        System.out.println("List 3 (Has NO vowels)        : " + list3);

        // Write list2 into "repeat.txt"
        helper.saveToFile(list2, "repeat.txt");
        System.out.println("Saved list2 to repeat.txt");

        // Write list3 into "novowel.txt"
        helper.saveToFile(list3, "novowel.txt");
        System.out.println("Saved list3 to novowel.txt");

        // Turn off the keyboard reader
        keyboard.close();
    }
}

/*
Please enter your strings:
apple
gym

--- Results ---
List 2 (Has repeated letters) : [apple]
List 3 (Has NO vowels)        : [gym]
Saved list2 to repeat.txt
Saved list3 to novowel.txt

*/