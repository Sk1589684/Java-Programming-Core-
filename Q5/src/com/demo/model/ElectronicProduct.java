package com.demo.model;

//Borrows the basic boxes from the main Product class
public class ElectronicProduct extends Product {
 
 // Extra boxes only for Electronics
 private String warrantyPeriod; // e.g., "2 Years"
 private String brand;          // e.g., "Samsung"

 // Setup machine for an Electronic Product
 public ElectronicProduct(int productId, String productName, double price, int quantity, String warrantyPeriod, String brand) {
     // Give the basic details to the parent class to handle
     super(productId, productName, price, quantity);
     
     // Save the extra Electronic details
     this.warrantyPeriod = warrantyPeriod;
     this.brand = brand;
 }

 // Add the extra details to the printed sentence
 @Override
 public String toString() {
     return "[Electronic] " + super.toString() + " | Brand: " + brand + " | Warranty: " + warrantyPeriod;
 }
}
