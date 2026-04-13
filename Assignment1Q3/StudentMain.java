package Assignment1Q3;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Student[] students = new Student[n];

        // Taking input
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i + 1));

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks m1 m2 m3: ");
            double m1 = sc.nextDouble();
            double m2 = sc.nextDouble();
            double m3 = sc.nextDouble();

            students[i] = new Student(id, name, m1, m2, m3);
        }

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Display All Students");
            System.out.println("2. Search by ID");
            System.out.println("3. Search by Name");
            System.out.println("4. Calculate GPA of a Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Student s : students) {
                        s.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean foundId = false;

                    for (Student s : students) {
                        if (s.getId() == searchId) {
                            s.display();
                            foundId = true;
                        }
                    }

                    if (!foundId) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Name to search: ");
                    String searchName = sc.nextLine();
                    boolean foundName = false;

                    for (Student s : students) {
                        if (s.getName().equalsIgnoreCase(searchName)) {
                            s.display();
                            foundName = true;
                        }
                    }

                    if (!foundName) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to calculate GPA: ");
                    int id = sc.nextInt();
                    boolean foundGPA = false;

                    for (Student s : students) {
                        if (s.getId() == id) {
                            double gpa = s.calculateGPA();
                            System.out.println("GPA = " + gpa);
                            foundGPA = true;
                        }
                    }

                    if (!foundGPA) {
                        System.out.println("Student not found!");
                    }
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