package com.demo.service;

import com.demo.dao.VehicleDao;
import com.demo.model.ElectricVehicle;
import com.demo.model.PetrolVehicle;
import com.demo.model.Vehicle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VehicleService {
    
    // The Manager connects to the Filing Cabinet
    private VehicleDao dao = new VehicleDao();

    // a. Add new vehicle
    public void addVehicle(Vehicle vehicle) {
        // We check the result. If it's false, the HashSet rejected it!
        boolean success = dao.saveVehicle(vehicle);
        if (success) {
            System.out.println("Success: Vehicle added to showroom!");
        } else {
            System.out.println("Error: A vehicle with this ID already exists!");
        }
    }

    // b. Remove a vehicle
    public void removeVehicle(int vehicleId) {
        Vehicle vehicle = dao.getVehicleById(vehicleId);
        if (vehicle != null) {
            dao.deleteVehicle(vehicle);
            System.out.println("Success: Vehicle removed!");
        } else {
            System.out.println("Error: Cannot find that vehicle ID.");
        }
    }

    // c. Update the price
    public void updatePrice(int vehicleId, double newPrice) {
        Vehicle vehicle = dao.getVehicleById(vehicleId);
        if (vehicle != null) {
            vehicle.setPrice(newPrice);
            System.out.println("Success: Price updated!");
        } else {
            System.out.println("Error: Cannot find that vehicle ID.");
        }
    }

    // d. Sell the vehicle
    public void sellVehicle(int vehicleId) {
        Vehicle vehicle = dao.getVehicleById(vehicleId);
        if (vehicle != null) {
            if (vehicle.getStatus().equals("Available")) {
                vehicle.setStatus("Sold");
                System.out.println("Success: Vehicle sold!");
            } else {
                System.out.println("Sorry, this vehicle is already sold.");
            }
        } else {
            System.out.println("Error: Cannot find that vehicle ID.");
        }
    }

    // e. Purchase vehicle (Dealership buys it back / makes it Available)
    public void purchaseVehicle(int vehicleId) {
        Vehicle vehicle = dao.getVehicleById(vehicleId);
        if (vehicle != null) {
            if (vehicle.getStatus().equals("Sold")) {
                vehicle.setStatus("Available");
                System.out.println("Success: Vehicle purchased back into inventory!");
            } else {
                System.out.println("Vehicle is already in the inventory (Available).");
            }
        } else {
            System.out.println("Error: Cannot find that vehicle ID.");
        }
    }

    // f. Display all vehicles
    public void displayAllVehicles() {
        if (dao.getAllVehicles().isEmpty()) {
            System.out.println("No vehicles in the showroom.");
            return;
        }
        for (Vehicle vehicle : dao.getAllVehicles()) {
            System.out.println(vehicle.toString());
        }
    }

    // g. Display by type
    public void displayByType(String type) {
        boolean found = false;
        for (Vehicle vehicle : dao.getAllVehicles()) {
            if (type.equalsIgnoreCase("Electric") && vehicle instanceof ElectricVehicle) {
                System.out.println(vehicle.toString());
                found = true;
            } else if (type.equalsIgnoreCase("Petrol") && vehicle instanceof PetrolVehicle) {
                System.out.println(vehicle.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No vehicles found for type: " + type);
    }

    // h. Display vehicles within price range
    public void displayWithinPriceRange(double min, double max) {
        boolean found = false;
        for (Vehicle vehicle : dao.getAllVehicles()) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                System.out.println(vehicle.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No vehicles found in that budget.");
    }

    // i. Sort vehicles by price
    public void sortVehiclesByPrice() {
        // HashSets do not have an order, so we dump them into an ArrayList to organize them!
        ArrayList<Vehicle> listToSort = new ArrayList<>(dao.getAllVehicles());
        
        if (listToSort.isEmpty()) {
            System.out.println("No vehicles to sort.");
            return;
        }

        // Built-in tool to organize the list
        Collections.sort(listToSort, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Double.compare(v1.getPrice(), v2.getPrice());
            }
        });

        System.out.println("--- Vehicles Sorted by Price (Cheapest First) ---");
        for (Vehicle vehicle : listToSort) {
            System.out.println(vehicle.toString());
        }
    }

    // j. Search by Name
    public void searchByName(String searchName) {
        boolean found = false;
        for (Vehicle vehicle : dao.getAllVehicles()) {
            // Check if the typed letters match part of the vehicle's name
            if (vehicle.getVehicleName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Found: " + vehicle.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Sorry, couldn't find a vehicle with that name.");
    }
}
