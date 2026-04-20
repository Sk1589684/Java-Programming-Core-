package Collections;
import java.util.*;


public class MapDemo {
public static void main(String[] args) {
	TreeMap<Integer,String> tm = new TreeMap<>(Map.of(1,"A",2,"B",3,"C",4,"D"));

	tm.put(5, "E");
	tm.put(8, "F");

	Map.Entry<Integer,String> e = tm.firstEntry();

	System.out.println(e.getKey() + " " + e.getValue());
	System.out.println(tm);
	
	
//	System.out.println(tm.ceilingEntry(7).getValue());
//	System.out.println(tm.containsKey(5));
//	System.out.println(tm);
	
}
}