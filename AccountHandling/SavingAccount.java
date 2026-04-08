package AccountHandling;
import java.util.*;

public class SavingAccount extends BankAccount {
protected int interest;

SavingAccount(int interest,int accNo,String name,String dob)
{
	
	this.dob=dob;
	this.accNo=accNo;
	this.name=name;
	this.interest=interest;
	
}

public  void deposit(Scanner sc) {
//	int temp=0;
	
	System.out.println("Please Enter the amount ");
	amount=sc.nextInt();
	
//	
//	amount+=temp;
	
	balance=balance+amount;

	System.out.println("Balance After Deposit is:"+balance);
	
}
public void withdraw(Scanner sc)
{
	int temp;
	System.out.println("Please Enter the Value to be withdrawn");
	temp=sc.nextInt();
	
	balance = balance - temp;
	
	System.out.println("Balance after withdrawal is :"+balance );
}
}
