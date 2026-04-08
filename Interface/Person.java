package Interface;
import java.util.ArrayList;
import java.util.Collections;

public class Person implements Comparable <Person> {
private int id;
private String name;

public Person(int id,String name) {
	this.id=id;
	this.name=name;
}

public int getId()
{
	return id;
}

public String getName() {
	return name;
	
}

@Override
public int compareTo(Person p) {
	return this.id-p.id;
}

public void display() {
	System.out.println("----------");
	System.out.println("Id:"+id);
	System.out.println("Name :"+name);
	System.out.println("----------");
	
}

	public static void main(String[] args) {
		ArrayList <Person> list= new ArrayList<>();
		
		list.add(new Person(44,"Atharva"));
		
		list.add(new Person(37,"Sarvesh"));
		
		list.add(new Person(36,"Shreyash"));
		
		Collections.sort(list);
		
		for(Person p:list) {
			p.display();
		}
	}

}
