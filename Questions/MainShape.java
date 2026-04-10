package Questions;

public class MainShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape c=new Circle();
		Rectangle r=new Rectangle();
		
		c.perimeter();
		c.area();
		System.out.println("Now Rectangle");
		
		r.input();
		r.perimeter();
		r.area();
		
	}

}
