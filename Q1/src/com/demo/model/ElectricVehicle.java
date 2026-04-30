package com.demo.model;

//Borrows the basic boxes from the main Vehicle class
public class ElectricVehicle extends Vehicle {
 
 private int batteryCapacity; // e.g., 75 kWh
 private int chargingTime;    // e.g., 8 hours

 // Setup machine for Electric Vehicle
 public ElectricVehicle(int vehicleId, String vehicleName, double price, int batteryCapacity, int chargingTime) {
     // Send the basic details to the parent class
     super(vehicleId, vehicleName, price);
     this.batteryCapacity = batteryCapacity;
     this.chargingTime = chargingTime;
 }

 @Override
 public String toString() {
     return "[Electric] " + super.toString() + " | Battery: " + batteryCapacity + "kWh | Charge Time: " + chargingTime + "h";
 }
}