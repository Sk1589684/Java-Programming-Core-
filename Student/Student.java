package Student;

import java.util.Scanner;

class InvalidMarksException extends Exception {

    public InvalidMarksException(String msg) {
        super(msg);
    }
}

class Student {

    private String name;
    private int marks[];

    public Student(String name, int marks[]) {
        this.name = name;
        this.marks = marks;
    }

    public double calculatePercentage()
            throws InvalidMarksException {

        int total = 0;

        for(int mark : marks) {

            if(mark < 0 || mark > 100) {
                throw new InvalidMarksException(
                        "Marks must be between 0 and 100");
            }

            total += mark;
        }

        return total / 5.0;
    }

    public void displayResult()
            throws InvalidMarksException {

        double percentage = calculatePercentage();

        System.out.println("Student Name : " + name);
        System.out.println("Percentage : " + percentage);

        if(percentage >= 40)
            System.out.println("PASS");
        else
            System.out.println("FAIL");
    }
}

