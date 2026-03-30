package Array;


import java.util.Scanner;

public class TestArray {
	
	
	public static void main(String[] args) {
		int[] a=new int[10];
		int[] b= {34,55,67,89};
		int[] summarr=ArrayService.findDigitSums(b);
		for(int i=0;i<summarr.length;i++) {
			System.out.println("sum of digts of number  : "+b[i]+"---->"+summarr[i]+"\n");
		}
		
		Scanner sc=new Scanner(System.in);
		ArrayService.acceptData(a);
		ArrayService.displayData(a);
		System.out.println("enter number to search");
		int num=sc.nextInt();
		int pos =ArrayService.searchData(a,num);
		if(pos!=-1) {
			System.out.println("number found at : "+pos+"\n");
		}else {
			System.out.println("number not found");
			
		}
		int s=ArrayService.findSum(a);
		System.out.println("sum: "+s);
		int max=ArrayService.findMax(a);
		int min=ArrayService.findMin(a);
		System.out.println("Max: "+max+" Min : "+min);
       sc.close();
	}

}
