package Interface;

public class Testin {
	public static void main(String[] args) {
Test t=new interfacepractice();
t.meth1();
t.meth2();

System.out.println("As meth 3 is method of class itself Reference Of Test Cannot call it");
System.out.println("So we've created object of class :");
interfacepractice p=new interfacepractice();
p.meth3();
}}
