package AssignmentQ3;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Employee> empList = new ArrayList<>();
        ArrayList<Member> memList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Add Member");
            System.out.println("4. Display Members");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("1. Salaried  2. Contract  3. Vendor");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Mobile: ");
                    String mob = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Dept: ");
                    String dept = sc.nextLine();
                    System.out.print("Designation: ");
                    String desig = sc.nextLine();
                    System.out.print("DOJ: ");
                    String doj = sc.nextLine();

                    if (type == 1) {
                        System.out.print("Basic Salary: ");
                        double basic = sc.nextDouble();
                        empList.add(new SalariedEmployee(name, mob, email, dept, desig, doj, basic));

                    } else if (type == 2) {
                        System.out.print("Hours: ");
                        int hrs = sc.nextInt();
                        System.out.print("Rate: ");
                        double rate = sc.nextDouble();
                        empList.add(new ContractEmployee(name, mob, email, dept, desig, doj, hrs, rate));

                    } else if (type == 3) {
                        System.out.print("No of Employees: ");
                        int n = sc.nextInt();
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        empList.add(new Vendor(name, mob, email, dept, desig, doj, n, amt));
                    }
                    break;

                case 2:
                    for (Employee e : empList) {
                        e.display();
                        System.out.println("----------------");
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String mname = sc.nextLine();
                    System.out.print("Mobile: ");
                    String mmob = sc.nextLine();
                    System.out.print("Email: ");
                    String memail = sc.nextLine();
                    System.out.print("Membership Type: ");
                    String typeMem = sc.nextLine();
                    System.out.print("Amount Paid: ");
                    double amt = sc.nextDouble();

                    memList.add(new Member(mname, mmob, memail, typeMem, amt));
                    break;

                case 4:
                    for (Member m : memList) {
                        m.display();
                        System.out.println("----------------");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
