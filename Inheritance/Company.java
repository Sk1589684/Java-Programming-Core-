package Inheritance;

public class Company extends Car {
int seats;
String fuelType;
Company(){
	System.out.println("No arg Constr of Company is called s");
}
void displayCompany()
{
	System.out.println("No of seats are :"+seats);
	System.out.println("Fuel Type oF vehicle is :"+fuelType);
}
}
