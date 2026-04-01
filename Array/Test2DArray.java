package Array;

import java.util.Scanner;

public class Test2DArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][4];
		Array2DService.acceptData(arr);
		Array2DService.displayData(arr);
		int choice = 0;
		do {
			System.out.println(
					"1. find max \n 2. find min\n 3. find sum \n 4. find sum rowwise \n 5.find sum columnswise\n");
			System.out.println("6. display \n7. find rowwise maximum\n 8. find columnwise maximum\n9. exit \nchoice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> {
				int max = Array2DService.findMax(arr);
				System.out.println("Maximum : " + max);
			}
			case 2 -> {
				int min = Array2DService.findMin(arr);
				System.out.println("Minimum : " + min);
			}
			case 3 -> {
				int sum = Array2DService.findSum(arr);
				System.out.println("Addition  : " + sum);
			}
			case 4 -> {
				int[] sumarr = Array2DService.findSumRowWise(arr);
				for (int i = 0; i < sumarr.length; i++) {
					System.out.println("Sum of row " + i + "----->" + sumarr[i]);
				}
			}
			case 5 -> {
				int[] sumarr = Array2DService.findSumColumnWise(arr);
				for (int i = 0; i < sumarr.length; i++) {
					System.out.println("Sum of column " + i + "----->" + sumarr[i]);
				}
			}
			case 6 -> {
				Array2DService.displayData(arr);
			}
			case 7 -> {
				int[] maxRowwise = Array2DService.findRowwiseMaximum(arr);
				for (int i = 0; i < maxRowwise.length; i++) {
					System.out.println("max of  row " + i + "----->" + maxRowwise[i]);
				}
			}
			case 8 -> {
				int[] maxColumnwise = Array2DService.findColumnwiseMaximum(arr);
				for (int i = 0; i < maxColumnwise.length; i++) {
					System.out.println("max of  column " + i + "----->" + maxColumnwise[i]);
				}
			}
			case 9 -> {
				sc.close();
				System.out.println("Thank you for visiting........");
			}
			default -> {
				System.out.println("wrong choice");
			}
			}
		} while (choice != 9);

	}

}
