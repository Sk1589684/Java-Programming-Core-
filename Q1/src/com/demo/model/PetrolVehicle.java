package com.demo.model;

//Borrows the basic boxes from the main Vehicle class
public class PetrolVehicle extends Vehicle {
 
 private String fuelType; // e.g., Petrol, Diesel
 private int mileage;     // e.g., 15 km/l

 // Setup machine for Petrol Vehicle
 public PetrolVehicle(int vehicleId, String vehicleName, double price, String fuelType, int mileage) {
     // Send the basic details to the parent class
     super(vehicleId, vehicleName, price);
     this.fuelType = fuelType;
     this.mileage = mileage;
 }

 @Override
 public String toString() {
     return "[Petrol] " + super.toString() + " | Fuel: " + fuelType + " | Mileage: " + mileage + "km/l";
 }
}
