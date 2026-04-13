package Assignment1Q3;

class Student {
    private int id;
    private String name;
    private double m1, m2, m3;
    private double gpa;

    // Parameterized Constructor
    public Student(int id, String name, double m1, double m2, double m3) {
        this.id = id;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    // Method to calculate GPA
    public double calculateGPA() {
        gpa = (1.0/3)*m1 + (1.0/2)*m2 + (1.0/4)*m3;
        return gpa;
    }

    // Display student details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Marks: " + m1 + ", " + m2 + ", " + m3);
    }

    // Getter methods for search
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
