package AbstractClass;

public class MyKFC extends KFC {
MyKFC(){
	System.out.println("Constr is called :");
}

@Override
void billing() {
	
}
@Override
void offer() {
	System.out.println("No Current Offers ");
	
}
void festiveOffer() {
	System.out.println("Festive Offer Applied:");
}

}

