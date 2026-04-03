package Friends;

import java.util.Scanner;

public class Friend {
    int id;
    String name;
    String lastname;
    String[] hobbies;
    String mobno;
    String email;
    String bdate;
    String address;

    public void acceptData(Scanner sc) {
        System.out.print("Enter ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Last Name: ");
        lastname = sc.nextLine();

        System.out.print("Enter number of hobbies: ");
        int n = sc.nextInt();
        sc.nextLine();

        hobbies = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter hobby " + (i+1) + ": ");
            hobbies[i] = sc.nextLine();
        }

        System.out.print("Enter Mobile No: ");
        mobno = sc.nextLine();

        System.out.print("Enter Email: ");
        email = sc.nextLine();

        System.out.print("Enter Birth Date: ");
        bdate = sc.nextLine();

        System.out.print("Enter Address: ");
        address = sc.nextLine();
    }

    public void displayData() {
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name + " " + lastname);

        System.out.print("Hobbies: ");
        for (String h : hobbies) {
            System.out.print(h + " ");
        }

        System.out.println("\nMobile: " + mobno);
        System.out.println("Email: " + email);
        System.out.println("Birth Date: " + bdate);
        System.out.println("Address: " + address);
    }

    public boolean hasHobby(String h) {
        for (String hobby : hobbies) {
            if (hobby.equalsIgnoreCase(h)) {
                return true;
            }
        }
        return false;
    }
}

