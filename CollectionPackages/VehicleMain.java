package CollectionPackages;
import java.util.*;

public class VehicleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Vehicle> set= new HashSet<>();
		
		Vehicle v1=new Vehicle(101,"Mahindra");
		
		Vehicle v2=new Vehicle(101,"Mahindra");
		
		Vehicle v3=new Vehicle(1101,"Scorpio-N");
		
		Vehicle v4=new Vehicle(1101,"Scorpio-N");
		
		set.add(v1);
		set.add(v2);
		set.add(v3);
		set.add(v4);
		
		
		System.out.println("Objects Stored in List are:"+set.size());
		
		for(Vehicle v:set) {
			v.display();
		}
		
	}

}

////This Code is About HashSet and Equals.
//
//WOrkFlow:
//	1)hashCode:decides Bucket
//
//2)Same Bucket calls equal
//
//3) .equals() true -> reject
//
//4) equals() false-> add;