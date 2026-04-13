package AssignmentQ3;

class ContractEmployee extends Employee {
    private int hours;
    private double rate;

    public ContractEmployee(String name, String mobile, String email,
                            String dept, String desig, String doj,
                            int hours, double rate) {
        super(name, mobile, email, dept, desig, doj);
        this.hours = hours;
        this.rate = rate;
    }

    public double calculateSalary() {
        return hours * rate;
    }

    public void display() {
        super.display();
        System.out.println("Hours: " + hours +
                ", Rate: " + rate +
                ", Salary: " + calculateSalary());
    }
}
