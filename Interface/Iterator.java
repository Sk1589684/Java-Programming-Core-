package Interface;

import java.util.ArrayList;
import java.util.ListIterator;

public class Iterator {

    private int id;
    private String name;
    private double salary;

    // Constructor
    public Iterator(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getter
    public int getId() {
        return id;
    }

    // Setter
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display Method
    public void display() {
    	System.out.println("---------------------------");
        System.out.println("Employee id is : " + id);
        System.out.println("Employee Name is : " + name);
        System.out.println("Employee Salary is : " + salary);
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {

        ArrayList<Iterator> list = new ArrayList<>();

        list.add(new Iterator(1, "Sarvesh", 50000));
        list.add(new Iterator(2, "Shreyash", 60000));
        list.add(new Iterator(3, "Atharva", 100000));

        int searchId = 2;
        double newSalary = 150000;

        boolean found = false;

        ListIterator<Iterator> itr = list.listIterator();

        while (itr.hasNext()) {
            Iterator emp = itr.next();

            if (emp.getId() == searchId) {
                emp.setSalary(newSalary);
                found = true;
                System.out.println("Id Found And Salary Updated Successfully!");
                break;
            }
        }

        // AFTER LOOP
        if (!found) {
            System.out.println("Id not found");
        }

        System.out.println("\nUpdated Employee List is:");

        for (Iterator e : list) {
            e.display();
        }
    }
}








































































