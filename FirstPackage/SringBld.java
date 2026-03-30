package FirstPackage;

public class SringBld {
public static void main(String[] args) {
	StringBuilder sbld =new StringBuilder("Sarvesh");
	sbld.append("  Kulkarni");
	System.out.println("Name is :"+sbld);
	
	
//	StringBuilder sbla =new StringBuilder ("K");
//	System.out.println("Before Changing Short into Full :"+sbla);
//	sbla.append("Kulkarni");
//	
//	System.out.println("Last Name is :"+sbla);
	
	StringBuffer s = new StringBuffer("Hrutik");
	System.out.println("Harami Employee is: "+s);
	s.append("Sanket");
	System.out.println("After Adding one more Harami:"+s);
	
}
}


