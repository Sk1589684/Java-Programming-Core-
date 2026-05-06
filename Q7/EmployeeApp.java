package Q7;

import java.util.*;

public class EmployeeApp {
    static TreeSet<Employee> set = new TreeSet<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Update Salary 4.Change Status");
            System.out.println("5.Assign Dept 6.Display All 7.By Type");
            System.out.println("8.Salary Filter 9.Sort 10.Search 11.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: addEmployee(); break;
                case 2: removeEmployee(); break;
                case 3: updateSalary(); break;
                case 4: changeStatus(); break;
                case 5: assignDepartment(); break;
                case 6: displayAll(); break;
                case 7: displayByType(); break;
                case 8: salaryFilter(); break;
                case 9: displayAll(); break; // already sorted
                case 10: searchByName(); break;
                case 11: System.exit(0);
            }
        }
    }

    static void addEmployee() {
        System.out.println("1.Permanent 2.Contract");
        int type = sc.nextInt();

        System.out.print("Enter ID, Name, Salary, Department: ");
        int id = sc.nextInt();
        String name = sc.next();
        double salary = sc.nextDouble();
        String dept = sc.next();

        if (type == 1) {
            System.out.print("PF & Insurance: ");
            String pf = sc.next();
            String ins = sc.next();
            set.add(new PermanentEmployee(id, name, salary, dept, "working", pf, ins));
        } else {
            System.out.print("Duration & Agency: ");
            int dur = sc.nextInt();
            String ag = sc.next();
            set.add(new ContractEmployee(id, name, salary, dept, "working", dur, ag));
        }
    }

    static void removeEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        set.removeIf(e -> e.getEmpId() == id);
    }

    static void updateSalary() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : set) {
            if (e.getEmpId() == id) {
                set.remove(e); // remove first
                System.out.print("New Salary: ");
                e.setSalary(sc.nextDouble());
                set.add(e); // re-add to maintain sorting
                break;
            }
        }
    }

    static void changeStatus() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : set) {
            if (e.getEmpId() == id) {
                e.setStatus(e.status.equals("working") ? "resigned" : "working");
            }
        }
    }

    static void assignDepartment() {
        System.out.print("Enter department: ");
        String dept = sc.next();

        for (Employee e : set) {
            if (e.department.equalsIgnoreCase(dept))
                e.display();
        }
    }

    static void displayAll() {
        for (Employee e : set)
            e.display();
    }

    static void displayByType() {
        System.out.println("1.Permanent 2.Contract");
        int type = sc.nextInt();

        for (Employee e : set) {
            if (type == 1 && e instanceof PermanentEmployee)
                e.display();
            else if (type == 2 && e instanceof ContractEmployee)
                e.display();
        }
    }

    static void salaryFilter() {
        System.out.print("Enter minimum salary: ");
        double min = sc.nextDouble();

        for (Employee e : set) {
            if (e.getSalary() > min)
                e.display();
        }
    }

    static void searchByName() {
        System.out.print("Enter name: ");
        String name = sc.next();

        for (Employee e : set) {
            if (e.getEmpName().equalsIgnoreCase(name))
                e.display();
        }
    }
}
