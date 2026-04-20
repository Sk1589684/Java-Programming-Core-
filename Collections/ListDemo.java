package Collections;
import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		LinkedList <Integer> lst=new LinkedList<>();

		LinkedList <Integer> lst2=new LinkedList<>(List.of(50,60,70,80,90));
		
		lst.add(10);
		lst.add(0,10);
		lst.addAll(1,lst2);
		
		lst.set(3,70);
		
		lst.set(6,100);
		
		lst.addFirst(200);
		lst.addLast(5);
		lst.removeFirst();
		lst.forEach((x)->System.out.println(x));
		
		
		
//		Iterator<Integer> it=lst.descendingIterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
	}

}

	