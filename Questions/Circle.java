package Questions;
import java.util.*;

public class Circle extends Shape {
    Scanner sc = new Scanner(System.in);
    int radius;

    // Constructor to take input
    Circle() {
        System.out.print("Enter radius: ");
        radius = sc.nextInt();
    }

    @Override
    void perimeter() {
        double peri = 2 * Math.PI * radius;
        System.out.println("Perimeter Of Circle is: " + peri);
    }

    @Override
    void area() {
        double area = Math.PI * radius * radius;
        System.out.println("Area Of Circle is: " + area);
    }
}