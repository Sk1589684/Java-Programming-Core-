package AccountHandling;

public class BankAccount {
	
public double accNo;
public String name;
public String address;
public String phoneNo;
public String dob;
protected double amount;
protected double balance;

public void setAddress(String address) 
{
	this.address=address;
}

public double getAccNo() {
	return accNo;
}
public void setAccNo(double accNo) {
	this.accNo = accNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
//public double getBalance() {
//	return balance;
//}
//public void setBalance(double balance) {
//	this.balance = balance;
//}
public String getAddress() {
	return address;
}

}
