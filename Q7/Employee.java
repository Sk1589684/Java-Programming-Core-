package Q7;

abstract class Employee implements Comparable<Employee> {
    int empId;
    String empName;
    double salary;
    String department;
    String status;

    public Employee(int id, String name, double salary, String dept, String status) {
        this.empId = id;
        this.empName = name;
        this.salary = salary;
        this.department = dept;
        this.status = status;
    }

    public int getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public double getSalary() { return salary; }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ✅ Add compareTo here
    @Override
    public int compareTo(Employee e) {
        int result = Double.compare(this.salary, e.salary);

        // Avoid duplicate salary issue
        if (result == 0) {
            return this.empId - e.empId;
        }

        return result;
    }

    public abstract void display();
}