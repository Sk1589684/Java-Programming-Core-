package Collections;
import java.util.*;

public class ArrBasic {
public static void main(String[] args) {
	
	ArrayList<Integer> all=new ArrayList<>();
	
	ArrayList <Integer> all1=new ArrayList<>(List.of(20,30,20,40,50,60));	
	all.add(10);
	all.clear();
	all.add(20);
	
	all.add(30);
	
	all.add(10);
	all.add(1, 100);
	
	all.remove(2);//We have to write index in Bracket.
	
	System.out.println("List is :"+all);
	
	System.out.println("Second lis is :"+all1);
	
	all.addAll(all1);
	System.out.println("After addition list is :"+all);
	
	System.out.println(all1.get(3) );
	
	all1.set(0, 11);
	System.out.println("after setting "+all1);
//	all.forEach((x)->System.out.println(x)); Method 1
	
//	Iterator<Integer> it=all.listIterator(); Method 2
//	
//	while(it.hasNext()) {
//		System.out.println(it.next());
//	} Method 4
//	for(ListIterator <Integer> it=all.listIterator();it.hasNext();) {
//		System.out.println(it.next());
//	} Method 4
	
//	all.forEach(n->System.out.println(n)); Method 5
	
//	all.forEach(System.out::println); Method 6
	all.forEach(n->show(n));
}
static void show(int n) {
	if(n>30) {
		System.out.println(n);
	}
}
}

