package com.demo.test;

import com.demo.model.StackHelper;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        
        // Tool to read what the user types on the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        // Create our main Stack to hold all the initial strings
        Stack<String> mainStack = new Stack<>();
        
        // Create our helper object to do the checking and saving work
        StackHelper helper = new StackHelper();

        System.out.println("--- Stack String Application ---");
        System.out.print("How many strings do you want to enter? ");
        int count = keyboard.nextInt();
        keyboard.nextLine(); // Clear the hidden "Enter" key press

        // Collect strings from the user
        System.out.println("Please enter your strings:");
        for (int i = 0; i < count; i++) {
            String word = keyboard.nextLine();
            // .push() is the exact command used to put something inside a Stack
            mainStack.push(word); 
        }

        // --- PERFORM THE OPERATIONS ---
        
        // Create list2 (Palindromes)
        ArrayList<String> list2 = helper.getPalindromes(mainStack);

        // Create list3 (Strings with spaces)
        ArrayList<String> list3 = helper.getStringsWithSpaces(mainStack);

        // Display both lists on the screen
        System.out.println("\n--- Results ---");
        System.out.println("List 2 (Palindromes) : " + list2);
        System.out.println("List 3 (Has Spaces)  : " + list3);

        // Write list2 into "palin.txt"
        helper.saveToFile(list2, "palin.txt");
        System.out.println("Saved list2 to palin.txt");

        // Write list3 into "space.txt"
        helper.saveToFile(list3, "space.txt");
        System.out.println("Saved list3 to space.txt");

        // Turn off the keyboard reader
        keyboard.close();
    }
}


//input - madam
//        hello world
