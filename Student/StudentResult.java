package Student;

import java.util.Scanner;

public class StudentResult {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            int marks[] = new int[5];

            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();

            for(int i=0;i<5;i++) {

                System.out.print("Enter Subject "
                        +(i+1)+" Marks : ");

                marks[i] = sc.nextInt();
            }

            Student s =
                    new Student(name, marks);

            s.displayResult();

        }
        catch(InvalidMarksException e) {
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Invalid Input");
        }
        finally {
            sc.close();
        }
    }
}