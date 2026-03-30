package FirstPackage;

public class Student {
private int sid=0;
private String sname=null;
private float m1=0f;
private float m2=0f;
private float m3=0f;

public Student(int id ,String sname , float m1,float m2,float m3) {
	sid=id;
	this.sname=sname;
	this.m1=m1;
	this.m2=m2;
	this.m3=m3;
	
}
public void display() {
	System.out.println("Id"+sid);
	System.out.println("Name is :"+sname);
	System.out.println("Marks 1: "+m1);
	System.out.println("Marks of 2: "+m2);
	System.out.println("Marks of 3: "+m3);
	
}

public static void main(String[] args) {
	Student s= new Student (1,"Rajdeep ",20.20f,79.20f,71.80f);
	
	s.display();
}
}
