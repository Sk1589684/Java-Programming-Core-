package com.demo.test;

import com.demo.model.ElectricVehicle;
import com.demo.model.PetrolVehicle;
import com.demo.service.VehicleService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        VehicleService manager = new VehicleService();

        while (true) {
            System.out.println("\n=== Full Vehicle Menu ===");
            System.out.println("a. Add new Vehicle");
            System.out.println("b. Remove vehicle using vehicleId");
            System.out.println("c. Update vehicle price");
            System.out.println("d. Sell vehicle (Change to Sold)");
            System.out.println("e. Purchase vehicle (Change to Available)");
            System.out.println("f. Display all vehicles");
            System.out.println("g. Display vehicles by type");
            System.out.println("h. Display vehicles within price range");
            System.out.println("i. Sort vehicles by price");
            System.out.println("j. Search vehicle by name");
            System.out.println("k. Exit");
            System.out.print("What would you like to do? Enter a letter: ");
            
            char choice = keyboard.next().toLowerCase().charAt(0);
            keyboard.nextLine(); // Clear the enter key

            switch (choice) {
                case 'a': // Add
                    System.out.print("Enter Vehicle ID: ");
                    int id = keyboard.nextInt();
                    keyboard.nextLine(); 
                    
                    System.out.print("Enter Vehicle Name (e.g., Tesla Model 3): ");
                    String name = keyboard.nextLine();
                    
                    System.out.print("Enter Price: $");
                    double price = keyboard.nextDouble();
                    
                    System.out.print("Type 1 for Electric, 2 for Petrol: ");
                    int type = keyboard.nextInt();
                    keyboard.nextLine(); 
                    
                    if (type == 1) {
                        System.out.print("Enter Battery Capacity (kWh): ");
                        int battery = keyboard.nextInt();
                        System.out.print("Enter Charging Time (hours): ");
                        int time = keyboard.nextInt();
                        
                        manager.addVehicle(new ElectricVehicle(id, name, price, battery, time));
                    } 
                    else if (type == 2) {
                        System.out.print("Enter Fuel Type (Petrol/Diesel): ");
                        String fuel = keyboard.nextLine();
                        System.out.print("Enter Mileage (km/l): ");
                        int mileage = keyboard.nextInt();
                        
                        manager.addVehicle(new PetrolVehicle(id, name, price, fuel, mileage));
                    }
                    break;

                case 'b': // Remove
                    System.out.print("Enter Vehicle ID to remove: ");
                    manager.removeVehicle(keyboard.nextInt());
                    break;

                case 'c': // Update Price
                    System.out.print("Enter Vehicle ID to update: ");
                    int updateId = keyboard.nextInt();
                    System.out.print("Enter New Price: $");
                    double newPrice = keyboard.nextDouble();
                    manager.updatePrice(updateId, newPrice);
                    break;

                case 'd': // Sell
                    System.out.print("Enter Vehicle ID to sell: ");
                    manager.sellVehicle(keyboard.nextInt());
                    break;

                case 'e': // Purchase back
                    System.out.print("Enter Vehicle ID to purchase back into inventory: ");
                    manager.purchaseVehicle(keyboard.nextInt());
                    break;

                case 'f': // Display All
                    System.out.println("--- Showroom Inventory ---");
                    manager.displayAllVehicles();
                    break;

                case 'g': // Display by Type
                    System.out.print("Enter Type (Electric / Petrol): ");
                    manager.displayByType(keyboard.nextLine());
                    break;

                case 'h': // Display in Price Range
                    System.out.print("Enter Minimum Price: $");
                    double min = keyboard.nextDouble();
                    System.out.print("Enter Maximum Price: $");
                    double max = keyboard.nextDouble();
                    manager.displayWithinPriceRange(min, max);
                    break;

                case 'i': // Sort
                    manager.sortVehiclesByPrice();
                    break;

                case 'j': // Search Name
                    System.out.print("Enter part of the vehicle's name to search for: ");
                    manager.searchByName(keyboard.nextLine());
                    break;

                case 'k': // Exit
                    System.out.println("Shutting down Vehicle System. Have a great drive!");
                    keyboard.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid letter! Please choose an option from a to k.");
            }
        }
    }
}
