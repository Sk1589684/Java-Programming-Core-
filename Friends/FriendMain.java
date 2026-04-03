package Friends;

import java.util.Scanner;

public class FriendMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of friends: ");
        int n = sc.nextInt();

        Friend[] friends = new Friend[n];

        // Accept data
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Friend " + (i + 1));
            friends[i] = new Friend();
            friends[i].acceptData(sc);
        }

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Display All Friends");
            System.out.println("2. Search by ID");
            System.out.println("3. Search by Name");
            System.out.println("4. Display Friends with Particular Hobby");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Friend f : friends) {
                        f.displayData();
                    }
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    boolean found = false;

                    for (Friend f : friends) {
                        if (f.id == id) {
                            f.displayData();
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Friend not found!");
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    found = false;

                    for (Friend f : friends) {
                        if (f.name.equalsIgnoreCase(name)) {
                            f.displayData();
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Friend not found!");
                    break;

                case 4:
                    System.out.print("Enter Hobby: ");
                    String hobby = sc.nextLine();
                    found = false;

                    for (Friend f : friends) {
                        if (f.hasHobby(hobby)) {
                            f.displayData();
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("No friend has this hobby!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}