package StudentService;
//
//public class StudentServiceStd {
//
//}

import java.util.Scanner;

// Student class (object structure)
class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

// Service class
class StudentService {

    static Student[] arr = new Student[100]; // array of objects
    static int count = 0;

    // Add new student
    static void addNew(Student s) {
        arr[count++] = s;
        System.out.println("Student added successfully!");
    }

    // Display all students
    static void displayAll() {
        if (count == 0) {
            System.out.println("No records found.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(arr[i].id + " " + arr[i].name + " " + arr[i].marks);
        }
    }

    // Display by ID
    static void displayById(int id) {
        for (int i = 0; i < count; i++) {
            if (arr[i].id == id) {
                System.out.println(arr[i].id + " " + arr[i].name + " " + arr[i].marks);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Display by Name
    static void displayByName(String name) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (arr[i].name.equalsIgnoreCase(name)) {
                System.out.println(arr[i].id + " " + arr[i].name + " " + arr[i].marks);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // Update student
    static void update(int id, Scanner sc) {
        for (int i = 0; i < count; i++) {
            if (arr[i].id == id) {
                System.out.print("Enter new name: ");
                arr[i].name = sc.next();

                System.out.print("Enter new marks: ");
                arr[i].marks = sc.nextDouble();

                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Delete student
    static void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (arr[i].id == id) {

                // shift elements
                for (int j = i; j < count - 1; j++) {
                    arr[j] = arr[j + 1];
                }

                count--;
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}

// Main class
public class StudentServiceStd{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Add\n2.Display All\n3.Display By ID\n4.Display By Name\n5.Update\n6.Delete\n7.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    Student s = new Student(id, name, marks);
                    StudentService.addNew(s);
                    break;

                case 2:
                    StudentService.displayAll();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    StudentService.displayById(searchId);
                    break;

                case 4:
                    System.out.print("Enter Name: ");
                    String searchName = sc.next();
                    StudentService.displayByName(searchName);
                    break;

                case 5:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    StudentService.update(updateId, sc);
                    break;

                case 6:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    StudentService.delete(deleteId);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}