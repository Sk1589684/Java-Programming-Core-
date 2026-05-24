package com.demo.model;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstring {
	
	public static void main(String[] args) {
        // Create a Scanner tool to read what the user types on their keyboard
        Scanner keyboard = new Scanner(System.in);
        
        // 1. Ask the user for a string
        System.out.print("Please enter a string: ");
        
        // 2. Read the string typed by the user
        String input = keyboard.nextLine();
        
        // 3. Send the user's string to our helper method to do the math
        int result = findLongestSubstring(input);
        
        // 4. Print out the final answer
        System.out.println("Length of longest substring without repeating characters: " + result);
        
        // Turn off the keyboard reader
        keyboard.close();
    }

    // --------------------------------------------------------
    // HELPER METHOD (The "Sliding Window" logic)
    // --------------------------------------------------------
    public static int findLongestSubstring(String s) {
        // A HashSet is a special box that ONLY allows unique items. 
        HashSet<Character> seenLetters = new HashSet<>();
        
        int left = 0;      // The left side of our window
        int right = 0;     // The right side of our window
        int maxLength = 0; // To keep track of the longest window we find

        // Keep expanding the right side of the window until we hit the end of the string
        while (right < s.length()) {
            char currentLetter = s.charAt(right);

            // If our box DOES NOT have the current letter...
            if (!seenLetters.contains(currentLetter)) {
                seenLetters.add(currentLetter); // Add it to the box
                
                // Check if our current window size is the biggest one we've seen so far
                int currentWindowSize = right - left + 1;
                if (currentWindowSize > maxLength) {
                    maxLength = currentWindowSize;
                }
                
                right++; // Move the right edge of the window forward
            } 
            // If our box ALREADY HAS the current letter (we found a duplicate!)...
            else {
                // We must shrink the window from the left side until the duplicate is gone
                char leftLetter = s.charAt(left);
                seenLetters.remove(leftLetter); // Remove the leftmost letter from the box
                left++; // Move the left edge of the window forward
            }
        }

        return maxLength; // Return the biggest number we found
    }
}
