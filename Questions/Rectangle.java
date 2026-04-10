package Questions;
import java.util.*;

public class Rectangle extends Shape{
Scanner sc=new Scanner (System.in);


int len;
int brd;
void input() {
	System.out.println("Enter Lenght");
	len=sc.nextInt();
	System.out.println("Enter Breadth");
	brd=sc.nextInt();
}

@Override
void perimeter() {
	int peri=(2*(len+brd));
	System.out.println("Perimeter of Rectnagle is"+peri);
}
@Override
void area() {
	int area=len*brd;
	System.out.println("Area of Rectangle is "+area);
	sc.close();
}
}
