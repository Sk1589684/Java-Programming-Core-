package Q2;

import java.util.*;
import java.io.*;

public class StringApp {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(); // length > 5
        ArrayList<String> list3 = new ArrayList<>(); // starts with vowel

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            list1.add(sc.next());
        }

        // Processing
        for (String s : list1) {

            // Condition 1: length > 5
            if (s.length() > 5) {
                list2.add(s);
            }

            // Condition 2: starts with vowel
            char ch = Character.toLowerCase(s.charAt(0));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                list3.add(s);
            }
        }

        // Display lists
        System.out.println("\nStrings with length > 5:");
        for (String s : list2) {
            System.out.println(s);
        }

        System.out.println("\nStrings starting with vowel:");
        for (String s : list3) {
            System.out.println(s);
        }

        // Write list2 to file data1.txt
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("data1.txt"));
        for (String s : list2) {
            bw1.write(s);
            bw1.newLine();
        }
        bw1.close();

        // Write list3 to file data2.txt
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("data2.txt"));
        for (String s : list3) {
            bw2.write(s);
            bw2.newLine();
        }
        bw2.close();

        System.out.println("\nData written to files successfully!");
    }
}