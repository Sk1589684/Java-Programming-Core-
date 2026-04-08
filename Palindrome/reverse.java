package Palindrome;

import java.util.Scanner;
public class reverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter The number");
		int n=sc.nextInt();
		
		int m=n;
		int r;
		int rev=0;
		while(n!=0) {
			 r=n%10;
			 rev=rev*10+r;
			 n=n/10;
		
		}
		 if(rev==m) {
			 System.out.println("Number is palindrome");
		 }
		 else {
			 System.out.println("Number is not a palindrome");
		 }
		 sc.close();

	}
	

}
