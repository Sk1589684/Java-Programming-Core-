package Inheritance;

public class BasicLevelInheritance {
 private int a=10;
	BasicLevelInheritance(){
		System.out.println("Constr of Parent");
	}
	BasicLevelInheritance(int  a){
		this.a=a;
	}
}

class Child extends BasicLevelInheritance{
	int b=20;
	Child(){
		System.out.println("Constr of Child is Called");
	}
	Child(int b,int a){
		super(a);
		this.b=b;
		System.out.println("Para constr of Child is Called "+b+" "+a);
	}
}

class Grand extends Child{
	int c=30;
	Grand(){
		System.out.println("Constr of Grand is called");
	}
	Grand(int c){
		
		this.c=c;
		System.out.println("Para constr is called of grand"+c);
	}
}



