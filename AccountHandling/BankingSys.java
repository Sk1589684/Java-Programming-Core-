//package AccountHandling;
//import java.util.Scanner;
//
//public class BankingSys {
//
//	public static void main(String[] args) {
//		Scanner sc =new Scanner(System.in);
//		
//		SavingAccount sa=new SavingAccount(8,101,"Shreyash","20-10-2003");
////		System.out.println("Enter the number Of Users:");
////		int n=sc.nextInt();
//		
////		SavingAccount[] user=new SavingAccount[n];
//		
//		int choice;
//		
//		do { System.out.println("\n--- MENU ---");
//        System.out.println("1. DEPOSIT");
//        System.out.println("2. WITHDRAW");
//        System.out.println("3. FIXED DEPOSIT");
//        System.out.println("4. EXIT");
//       
//        System.out.print("Enter your choice: ");
//        choice = sc.nextInt();
//        sc.nextLine();
//        
//        
//        switch(choice) {
//        case 1:
//        	sa.deposit(sc);
//        	break;
//        case 2:
//        	sa.withdraw(sc);
//        	break;
//        case 3:
//        	sa.fixedDeposit(sc);
//        	break;
//        case 4:
//        	System.out.println("Exiting.....");
//        	break;	
//        }
//			 
//		}
//		while(choice<5); {
//			System.out.println("OOPS Please Try Again Later");
//			sc.close();
//		}
//		
//		
//	}
//}
package AccountHandling;
import java.util.Scanner;

public class BankingSys {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Array of objects
        SavingAccount[] users = new SavingAccount[n];

        // Taking input for each user
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for User " + (i + 1));

            System.out.print("Enter balance: ");
            double balance = sc.nextDouble();

            System.out.print("Enter account number: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter DOB: ");
            String dob = sc.nextLine();

            // create object
            users[i] = new SavingAccount((int) balance, accNo, name, dob);
        }

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. DEPOSIT");
            System.out.println("2. WITHDRAW");
            System.out.println("3. FIXED DEPOSIT");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Ask which user
            if (choice >= 1 && choice <= 3) {
                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                SavingAccount selectedUser = null;

                // search user
                for (SavingAccount u : users) {
                    if (u.getAccountNumber() == accNo) {
                        selectedUser = u;
                        break;
                    }
                }

                if (selectedUser == null) {
                    System.out.println("User not found!");
                    continue;
                }

                switch (choice) {
                    case 1:
                        selectedUser.deposit(sc);
                        break;

                    case 2:
                        selectedUser.withdraw(sc);
                        break;

                    case 3:
                        selectedUser.fixedDeposit(sc);
                        break;
                }
            }

        } while (choice != 4);

        sc.close();
    }
}