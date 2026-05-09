package com.demo.test;

import com.demo.model.ElectronicProduct;
import com.demo.model.GroceryProduct;
import com.demo.service.ProductService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        ProductService manager = new ProductService();

        while (true) {
            System.out.println("\n=== Store Management Menu ===");
            System.out.println("a. Add new Product");
            System.out.println("b. Remove product using productId");
            System.out.println("c. Update product price and quantity");
            System.out.println("d. Mark product unavailable");
            System.out.println("e. Purchase product (by Type & Price Range)");
            System.out.println("f. Display all products");
            System.out.println("g. Display products by type");
            System.out.println("h. Display products with low stock (quantity < given value)");
            System.out.println("i. Sort products by price");
            System.out.println("j. Search product by name");
            System.out.println("k. Exit");
            System.out.print("What would you like to do? Enter a letter: ");
            
            char choice = keyboard.next().toLowerCase().charAt(0);
            keyboard.nextLine(); // Clear the invisible enter key

            switch (choice) {
                case 'a': // Add
                    System.out.print("Enter Product ID: ");
                    int id = keyboard.nextInt();
                    keyboard.nextLine(); 
                    
                    System.out.print("Enter Product Name: ");
                    String name = keyboard.nextLine();
                    
                    System.out.print("Enter Price: $");
                    double price = keyboard.nextDouble();
                    
                    System.out.print("Enter Stock Quantity: ");
                    int quantity = keyboard.nextInt();
                    
                    System.out.print("Type 1 for Electronic, 2 for Grocery: ");
                    int type = keyboard.nextInt();
                    keyboard.nextLine(); 
                    
                    if (type == 1) { // Electronic
                        System.out.print("Enter Warranty Period (e.g., 2 Years): ");
                        String warranty = keyboard.nextLine();
                        System.out.print("Enter Brand (e.g., Sony): ");
                        String brand = keyboard.nextLine();
                        
                        manager.addProduct(new ElectronicProduct(id, name, price, quantity, warranty, brand));
                    } 
                    else if (type == 2) { // Grocery
                        System.out.print("Enter Expiry Date (e.g., 2024-12-31): ");
                        String expiry = keyboard.nextLine();
                        System.out.print("Enter Weight in kg (e.g., 1.5): ");
                        double weight = keyboard.nextDouble();
                        
                        manager.addProduct(new GroceryProduct(id, name, price, quantity, expiry, weight));
                    }
                    break;

                case 'b': // Remove
                    System.out.print("Enter Product ID to remove: ");
                    manager.removeProduct(keyboard.nextInt());
                    break;

                case 'c': // Update Price & Quantity
                    System.out.print("Enter Product ID to update: ");
                    int updateId = keyboard.nextInt();
                    System.out.print("Enter New Price: $");
                    double newPrice = keyboard.nextDouble();
                    System.out.print("Enter New Quantity: ");
                    int newQty = keyboard.nextInt();
                    manager.updatePriceAndQuantity(updateId, newPrice, newQty);
                    break;

                case 'd': // Mark Unavailable
                    System.out.print("Enter Product ID to mark as Unavailable: ");
                    manager.markUnavailable(keyboard.nextInt());
                    break;

                case 'e': // Purchase
                    System.out.print("Enter Product Type (Electronic / Grocery): ");
                    String searchType = keyboard.nextLine();
                    System.out.print("Enter Minimum Price: $");
                    double min = keyboard.nextDouble();
                    System.out.print("Enter Maximum Price: $");
                    double max = keyboard.nextDouble();
                    manager.purchaseProduct(searchType, min, max);
                    break;

                case 'f': // Display All
                    System.out.println("--- All Products in Store ---");
                    manager.displayAllProducts();
                    break;

                case 'g': // Display by Type
                    System.out.print("Enter Type (Electronic / Grocery): ");
                    manager.displayByType(keyboard.nextLine());
                    break;

                case 'h': // Display Low Stock
                    System.out.print("Show me products with quantity less than: ");
                    manager.displayLowStock(keyboard.nextInt());
                    break;

                case 'i': // Sort by Price
                    manager.sortProductsByPrice();
                    break;

                case 'j': // Search Name
                    System.out.print("Enter part of the product name to search for: ");
                    manager.searchByName(keyboard.nextLine());
                    break;

                case 'k': // Exit
                    System.out.println("Shutting down Store System. Goodbye!");
                    keyboard.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid letter! Please choose an option from a to k.");
            }
        }
    }
}