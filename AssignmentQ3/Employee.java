package AssignmentQ3;

class Employee extends Person {
    protected String department, designation, doj;

    public Employee(String name, String mobile, String email,
                    String dept, String desig, String doj) {
        super(name, mobile, email);
        this.department = dept;
        this.designation = desig;
        this.doj = doj;
    }

    public void display() {
        super.display();
        System.out.println("Dept: " + department +
                ", Designation: " + designation +
                ", DOJ: " + doj);
    }
}

