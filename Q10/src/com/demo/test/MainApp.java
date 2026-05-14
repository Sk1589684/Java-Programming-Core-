package com.demo.test;

import com.demo.model.ListHelper;
import java.util.LinkedList;
import java.util.Scanner;

public class MainApp {

public static void main(String[] args) {
        
        // Tool to read what the user types
        Scanner keyboard = new Scanner(System.in);
        
        // Create our main LinkedList to hold all the initial strings
        LinkedList<String> mainList = new LinkedList<>();
        
        // Create our helper object to do the checking and saving
        ListHelper helper = new ListHelper();

        System.out.println("--- LinkedList String Application ---");
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
        
        // Create list2 (Starting and ending with same char)
        LinkedList<String> list2 = helper.getSameCharList(mainList);

        // Create list3 (Only digits)
        LinkedList<String> list3 = helper.getDigitsList(mainList);

        // Display both lists on the screen
        System.out.println("\n--- Results ---");
        System.out.println("List 2 (Starts & Ends with same letter) : " + list2);
        System.out.println("List 3 (Only digits)                    : " + list3);

        // Write list2 into "samechar.txt"
        helper.saveToFile(list2, "samechar.txt");
        System.out.println("Saved list2 to samechar.txt");

        // Write list3 into "digits.txt"
        helper.saveToFile(list3, "digits.txt");
        System.out.println("Saved list3 to digits.txt");

        // Turn off the keyboard reader
        keyboard.close();
    }
}
