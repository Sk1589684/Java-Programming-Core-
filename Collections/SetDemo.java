package Collections;
import java.util.*;

public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Integer> ts=new TreeSet<>(List.of(10,30,50,70,10,40));
		
		ts.add(25);
		
//		System.out.println(ts.ceiling(35));
//		ts.iterator();
//		
		
		System.out.println(ts);// 10 is appearing only Once 
	}
  
}
