package com.demo.test;

import com.demo.model.StringHelper;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        
        // Tool to read what the user types on the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        // Create our main ArrayList to hold all the initial strings
        ArrayList<String> mainList = new ArrayList<>();
        
        // Create our helper object to do the checking and saving work
        StringHelper helper = new StringHelper();

        System.out.println("--- ArrayList String Application ---");
        System.out.print("How many strings do you want to enter? ");
        int count = keyboard.nextInt();
        keyboard.nextLine(); // Clear the hidden "Enter" key press

        // Collect strings from the user
        System.out.println("Please enter your strings:");
        for (int i = 0; i < count; i++) {
            String word = keyboard.nextLine();
            mainList.add(word); // Store the word in the main list
        }

        // --- PERFORM THE OPERATIONS ---
        
        // Create list2 (Strings containing "java")
        ArrayList<String> list2 = helper.getJavaStrings(mainList);

        // Create list3 (Strings in all uppercase)
        ArrayList<String> list3 = helper.getUpperCaseStrings(mainList);

        // Display both lists on the screen
        System.out.println("\n--- Results ---");
        System.out.println("List 2 (Contains 'java') : " + list2);
        System.out.println("List 3 (All Uppercase)   : " + list3);

        // Write list2 into "java.txt"
        helper.saveToFile(list2, "java.txt");
        System.out.println("Saved list2 to java.txt");

        // Write list3 into "upper.txt"
        helper.saveToFile(list3, "upper.txt");
        System.out.println("Saved list3 to upper.txt");

        // Turn off the keyboard reader
        keyboard.close();
    }
}
