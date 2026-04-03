package InheritanceStud;

public class StudentData {
private int id,marks;


public StudentData(int id, int marks) {
	
	this.id = id;
	this.marks = marks;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getMarks() {
	return marks;
}


public void setMarks(int marks) {
	this.marks = marks;
}
public void displayData()
{
	System.out.println("id is :"+id);
	System.out.println("marks are:"+marks);
}

}





