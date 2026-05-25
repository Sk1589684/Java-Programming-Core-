package com.demo;

import java.util.Scanner;

public class MatrixRotation {
	
	public static void main(String[] args) {
        // Tool to read user input
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the size of the grid: ");
        int n = keyboard.nextInt();
        
        // Create an empty 2D array (a grid) based on the user's size
        int[][] matrix = new int[n][n];
        
        System.out.println("Please enter the numbers row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	
                matrix[i][j] = keyboard.nextInt();
            }
        }
        
        System.out.println("\n--- Original Matrix ---");
        printMatrix(matrix);
        
        // Send the matrix to our helper method to do the rotation
        rotateMatrix(matrix);
        
        System.out.println("\n--- Matrix Rotated 90 Degrees Clockwise ---");
        printMatrix(matrix);
        
        keyboard.close();
    }

    // --------------------------------------------------------
    // HELPER METHODS
    // --------------------------------------------------------
    
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        
        // STEP 1: Transpose the matrix (Swap rows and columns)
        // We only loop through the top-right triangle of the grid so we don't double-swap
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Swap the number at [i][j] with the number at [j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // STEP 2: Reverse the numbers in each row (Flip left and right)
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            
            // Keep swapping the outer edges until they meet in the middle
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                
                left++;  // Move the left finger inward
                right--; // Move the right finger inward
            }
        }
    }
    
    // A simple tool to print the grid nicely on the screen
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to a new line after finishing a row
        }
    }

}
