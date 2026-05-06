package Q7;

class PermanentEmployee extends Employee {
    String PFNumber;
    String insuranceDetails;

    public PermanentEmployee(int id, String name, double salary, String dept, String status,
                             String PFNumber, String insuranceDetails) {
        super(id, name, salary, dept, status);
        this.PFNumber = PFNumber;
        this.insuranceDetails = insuranceDetails;
    }

    public void display() {
        System.out.println("Permanent -> ID: " + empId +
                ", Name: " + empName +
                ", Salary: " + salary +
                ", Dept: " + department +
                ", Status: " + status +
                ", PF: " + PFNumber +
                ", Insurance: " + insuranceDetails);
    }
}