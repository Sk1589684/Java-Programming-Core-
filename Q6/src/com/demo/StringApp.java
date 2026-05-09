package com.demo;

import java.util.*;
import java.io.*;

public class StringApp {

    // Method to check palindrome
    public static boolean isPalindrome(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(rev);
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Accept strings
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            String str = sc.nextLine();
            list1.add(str);
        }

        // Process strings
        for (String s : list1) {

            // Starts with consonant
            char ch = Character.toLowerCase(s.charAt(0));
            if (Character.isLetter(ch) &&
                ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                list2.add(s);
            }

            // Palindrome check
            if (isPalindrome(s)) {
                list3.add(s);
            }
        }

        // Display lists
        System.out.println("\nStrings starting with consonant:");
        System.out.println(list2);

        System.out.println("\nPalindrome strings:");
        System.out.println(list3);

        // Write list2 to consonant.txt
        FileWriter fw1 = new FileWriter("consonant.txt");
        for (String s : list2) {
            fw1.write(s + "\n");
        }
        fw1.close();

        // Write list3 to palindrome.txt
        FileWriter fw2 = new FileWriter("palindrome.txt");
        for (String s : list3) {
            fw2.write(s + "\n");
        }
        fw2.close();

        System.out.println("\nData written to files successfully!");

        sc.close();
    }
}