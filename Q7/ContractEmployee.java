package Q7;
class ContractEmployee extends Employee {
    int contractDuration;
    String agencyName;

    public ContractEmployee(int id, String name, double salary, String dept, String status,
                            int contractDuration, String agencyName) {
        super(id, name, salary, dept, status);
        this.contractDuration = contractDuration;
        this.agencyName = agencyName;
    }

    public void display() {
        System.out.println("Contract -> ID: " + empId +
                ", Name: " + empName +
                ", Salary: " + salary +
                ", Dept: " + department +
                ", Status: " + status +
                ", Duration: " + contractDuration +
                ", Agency: " + agencyName);
    }
}