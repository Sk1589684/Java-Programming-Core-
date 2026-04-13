package AssignmentQ3;

class Vendor extends Employee {
    private int noOfEmployees;
    private double amount;

    public Vendor(String name, String mobile, String email,
                  String dept, String desig, String doj,
                  int noOfEmployees, double amount) {
        super(name, mobile, email, dept, desig, doj);
        this.noOfEmployees = noOfEmployees;
        this.amount = amount;
    }

    public void display() {
        super.display();
        System.out.println("No. of Employees: " + noOfEmployees +
                ", Amount: " + amount);
    }
}
