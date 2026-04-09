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
public void fixedDeposit(Scanner sc) {
	System.out.println("Please Enter the amount to be deposited in Fixed:");
int initial=sc.nextInt();
System.out.println("Please Enter Tenure that how long should amount be Fixed");
int time=sc.nextInt();

int ReturnFixed=(initial+(interest*initial*time)/100);

System.out.println("Expected Amount after Tenure is :"+ReturnFixed);
}

public int getAccountNumber() {
	// TODO Auto-generated method stub
	return (int) accNo;
}



}
