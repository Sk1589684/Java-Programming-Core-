package Inheritance;
import java.util.*;

public class Rectangle {
	Scanner sc=new Scanner (System.in);
private int length;
private int breadth;


public int getLength() {
	return length;
}


public void setLength(int length) {
	this.length = length;
}


public int getBreadth() {
	return breadth;
}


public void setBreadth(int breadth) {
	this.breadth = breadth;
}
void input() {
	length=sc.nextInt();
}


void display () {
	System.out.println("Length :"+length);
	System.out.println("Breadth :"+breadth);
}
}
