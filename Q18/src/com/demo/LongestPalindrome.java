package com.demo;

import java.util.Scanner;

public class LongestPalindrome {
	
	public static void main(String[] args) {
        // Create a Scanner tool to read what the user types
        Scanner keyboard = new Scanner(System.in);
        
        // 1. Ask the user for a string
        System.out.print("Please enter a string: ");
        String input = keyboard.nextLine();
        
        // 2. Send the user's string to our helper method
        String result = findLongestPalindrome(input);
        
        // 3. Print out the final answer
        System.out.println("Longest palindromic substring is: " + result);
        
        // Turn off the keyboard reader
        keyboard.close();
    }

    // --------------------------------------------------------
    // HELPER METHODS
    // --------------------------------------------------------
    
    // Main method to find the longest palindrome
    public static String findLongestPalindrome(String s) {
        // If the string is empty or just nothing, return empty
        if (s == null || s.length() < 1) {
            return "";
        }

        // Keep track of where our longest palindrome starts and ends
        int start = 0;
        int end = 0;

        // Go through every single letter in the word, treating each one as a "center"
        for (int i = 0; i < s.length(); i++) {
            
            // Case 1: The palindrome has an odd number of letters (like "bab")
            // Center is exactly ON one letter (left = i, right = i)
            int length1 = expandFromMiddle(s, i, i);
            
            // Case 2: The palindrome has an even number of letters (like "abba")
            // Center is IN BETWEEN two letters (left = i, right = i + 1)
            int length2 = expandFromMiddle(s, i, i + 1);
            
            // Find out which case gave us a longer palindrome
            int maxLength = Math.max(length1, length2);
            
            // If the new palindrome we just found is longer than our previous best...
            if (maxLength > end - start) {
                // Update our start and end positions!
                // (Math is just used here to calculate the exact left/right cuts)
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        // Cut out the winning substring and return it
        return s.substring(start, end + 1);
    }

    // A helper tool that expands outwards from the middle and counts the length
    private static int expandFromMiddle(String s, int left, int right) {
        // While we haven't fallen off the edges of the word...
        // AND the letter on the left perfectly matches the letter on the right...
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // Expand the wings! Move left further left, and right further right.
            left--;
            right++;
        }
        // Return the total length of the matching letters we found
        return right - left - 1;
    }

}
