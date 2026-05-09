package com.demo.model;

//This is the basic blueprint. ANY product in our store will have these details.
public class Product {
 
 // Locked boxes to hold the product details safely
 private int productId;
 private String productName;
 private double price;
 private int quantity;   // How many we have in stock
 private String status;  // "Available" or "Unavailable"

 // The Setup Machine. When a new product arrives, we fill these boxes.
 public Product(int productId, String productName, double price, int quantity) {
     this.productId = productId;
     this.productName = productName;
     this.price = price;
     this.quantity = quantity;
     this.status = "Available"; // A brand new product is automatically Available
 }

 // "Getters": Safe peepholes to look at what is inside the boxes
 public int getProductId() { return productId; }
 public String getProductName() { return productName; }
 public double getPrice() { return price; }
 public int getQuantity() { return quantity; }
 public String getStatus() { return status; }

 // "Setters": Safe doors to change what is inside the boxes later
 public void setPrice(double price) { this.price = price; }
 public void setQuantity(int quantity) { this.quantity = quantity; }
 public void setStatus(String status) { this.status = status; }

 // Turns all the boxes into one neat English sentence for printing
 @Override
 public String toString() {
     return "ID: " + productId + " | Name: " + productName + 
            " | Price: $" + price + " | Stock: " + quantity + " | Status: " + status;
 }
}
