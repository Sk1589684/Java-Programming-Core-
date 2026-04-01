//package Normal;
//
//import java.util.Scanner;
//
//public class IfElse {
//
//	public static char Hrugo(char[] Employee) {
//		char Emp;
//		System.out.println("Enter the name of Employee");
//		Scanner sc = new Scanner(System.in);
//
//		;
//	}
//
//};
//
//public static void main(String[] args)
//{
//	
//}
package Normal;

import java.util.Scanner;

public class IfElse {

    // Function to take input and display employees
    public static void Hrugo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        String[] employees = new String[n];

        // Input names
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of employee " + (i ) + ": ");
            employees[i] = sc.nextLine();
        }

        // Display names
        System.out.println("\nEmployee Names:");
        for (int i = 0; i < n; i++) {
            System.out.println(employees[i]);
        }

        sc.close();
    }

    public static void main(String[] args) {
        Hrugo(); // call function
    }
}