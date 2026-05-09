package com.demo.model;

//Borrows the basic boxes from the main Product class
public class GroceryProduct extends Product {
 
 // Extra boxes only for Groceries
 private String expiryDate; // e.g., "2024-12-31"
 private double weight;     // e.g., 1.5 (in kg)

 // Setup machine for a Grocery Product
 public GroceryProduct(int productId, String productName, double price, int quantity, String expiryDate, double weight) {
     // Give the basic details to the parent class
     super(productId, productName, price, quantity);
     
     // Save the extra Grocery details
     this.expiryDate = expiryDate;
     this.weight = weight;
 }

 // Add the extra details to the printed sentence
 @Override
 public String toString() {
     return "[Grocery] " + super.toString() + " | Expiry: " + expiryDate + " | Weight: " + weight + "kg";
 }
}