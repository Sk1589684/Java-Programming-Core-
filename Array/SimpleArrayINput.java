package Array;

import java.util.Scanner;

class SimpleArrayINput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Take size from user
		System.out.print("Enter size of array: ");
		int n = sc.nextInt();

		int[] arr = new int[n];

		// Taking input
		System.out.println("Enter elements:");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// Display array
		System.out.println("Array elements are:");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

		sc.close();
	}
}
