package AccountHandling;
import java.util.Scanner;

public class BankingSys {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		SavingAccount sa=new SavingAccount(8,101,"Shreyash","20-10-2003");
		
		sa.deposit(sc);
		sa.withdraw(sc);
		
		sc.close();
	}
}
