package Inheritance;

public class Car {
	int speed;
	String brand;
	Car(){
		System.out.println("No arg constr of Car is called");
	}
	void displayCar()
	{
		System.out.println("Brand:"+brand);
		System.out.println("Speed:"+speed);
	}

}
