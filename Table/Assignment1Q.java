package Table;
import java.util.Scanner;

public class Assignment1Q {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("ENter number for n ");
		int n=sc.nextInt();
		
		for(int i=2;i<n;i++)
		{
			
			if (n%i==0)
			{
				System.out.println("Number is not Prime ");
				n=n/10;
				System.out.println("Number is :"+n);
				break;
			}
			else {
				System.out.println("Number is prime");
				for(int t=1;t<=10;t++)
				{
					System.out.println(n+"x"+t+"="+n*t);
				}
				break;
			}
			
		}
		
		
}
	

}
