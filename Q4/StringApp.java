package Q4;

import java.util.*;
import java.io.*;

public class StringApp {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(); // length < 4
        ArrayList<String> list3 = new ArrayList<>(); // contains digits

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            list1.add(sc.next());
        }

        // Processing
        for (String s : list1) {

            // Condition 1: length < 4
            if (s.length() < 4) {
                list2.add(s);
            }

            // Condition 2: contains digits
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    list3.add(s);
                    break; // avoid duplicate adding
                }
            }
        }

        // Display list2
        System.out.println("\nStrings with length < 4:");
        for (String s : list2) {
            System.out.println(s);
        }

        // Display list3
        System.out.println("\nStrings containing digits:");
        for (String s : list3) {
            System.out.println(s);
        }

        // Write list2 → small.txt
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("small.txt"));
        for (String s : list2) {
            bw1.write(s);
            bw1.newLine();
        }
        bw1.close();

        // Write list3 → digits.txt
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("digits.txt"));
        for (String s : list3) {
            bw2.write(s);
            bw2.newLine();
        }
        bw2.close();

        System.out.println("\nData written to files successfully!");
    }
}
