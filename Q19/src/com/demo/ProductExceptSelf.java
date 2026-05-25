package com.demo;

import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {
	
	public static void main(String[] args) {
        // Tool to read what the user types
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("How many numbers do you want in your array? ");
        int size = keyboard.nextInt();
        
        // Create an empty array based on the user's size
        int[] nums = new int[size];
        
        System.out.println("Please enter the " + size + " numbers one by one:");
        for (int i = 0; i < size; i++) {
            nums[i] = keyboard.nextInt();
        }
        
        // Send the array to our helper method
        int[] result = calculateProduct(nums);
        
        // Print the final output. Arrays.toString() makes it print neatly like [24, 12, 8, 6]
        System.out.println("Input Array:  " + Arrays.toString(nums));
        System.out.println("Output Array: " + Arrays.toString(result));
        
        keyboard.close();
    }

    // --------------------------------------------------------
    // HELPER METHOD (The Left/Right Sweep Logic)
    // --------------------------------------------------------
    
    public static int[] calculateProduct(int[] nums) {
        int length = nums.length;
        
        // Create the output array to hold our final answers
        int[] output = new int[length];
        
        // STEP 1: Calculate the product of all numbers to the LEFT of each spot
        int leftRunningProduct = 1; // Start with 1 because there's nothing to the left of the first item
        for (int i = 0; i < length; i++) {
            // Store the running product in the output array BEFORE multiplying the current number
            output[i] = leftRunningProduct;
            
            // Now, multiply the current number into our running total for the next spot
            leftRunningProduct = leftRunningProduct * nums[i];
        }
        
        // STEP 2: Calculate the product of all numbers to the RIGHT of each spot
        int rightRunningProduct = 1; // Start with 1 because there's nothing to the right of the last item
        
        // Notice we loop backwards this time! (from the end to the beginning)
        for (int i = length - 1; i >= 0; i--) {
            // Take whatever is already in the output box (the left product) 
            // and multiply it by the running right product!
            output[i] = output[i] * rightRunningProduct;
            
            // Now, multiply the current number into our running right total for the next spot
            rightRunningProduct = rightRunningProduct * nums[i];
        }
        
        // Return the completely finished array
        return output;
    }

}
