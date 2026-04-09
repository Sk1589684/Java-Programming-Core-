package CollectionPackages;
import java.util.*;


public class Vehicle {
int id;
String name;

Vehicle(int id,String name){
	this.id=id;
	this.name=name;
}

@Override
public int hashCode() {
	return id;
}
@Override
public boolean equals(Object obj) {
	if(this==obj) {
		return true;
	}
	if(obj==null||getClass()!=obj.getClass()) {
		return false;
	}
	
	Vehicle v=(Vehicle) obj;
	return id==v.id && Objects.equals(name,v.name);
}
int getId() {
	return id;
}
String getName() {
	return name;
}
void setId(int id) {
	this.id=id;
}

void setName(String name) {
	this.name=name;
}

void display() {
	System.out.println("-----------------");
	System.out.println("Vehicle Id id:"+id);
	System.out.println("Vehicle Name is :"+name);
	System.out.println("-----------------");
}
}
