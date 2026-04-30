package com.demo.model;

import java.util.Objects; // We need this tool to help the HashSet spot duplicates

//This is the basic blueprint for ANY vehicle in our showroom
public class Vehicle {
 
 // Locked boxes to hold the details safely
 private int vehicleId;
 private String vehicleName;
 private double price;
 private String status; // "Available" or "Sold"

 // The Setup Machine (Constructor)
 public Vehicle(int vehicleId, String vehicleName, double price) {
     this.vehicleId = vehicleId;
     this.vehicleName = vehicleName;
     this.price = price;
     this.status = "Available"; // A brand new vehicle is automatically Available
 }

 // "Getters": Safe peepholes to look at the details
 public int getVehicleId() { return vehicleId; }
 public String getVehicleName() { return vehicleName; }
 public double getPrice() { return price; }
 public String getStatus() { return status; }

 // "Setters": Safe doors to change the details later
 public void setPrice(double price) { this.price = price; }
 public void setStatus(String status) { this.status = status; }

 // -------------------------------------------------------------
 // THIS IS THE SECRET TO MAKING THE HASHSET WORK!
 // We are teaching Java that if two vehicles have the exact same 
 // ID number, they are duplicates and should be rejected.
 // -------------------------------------------------------------
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true; // If it's the exact same object, it's a duplicate
     if (obj == null || getClass() != obj.getClass()) return false;
     Vehicle vehicle = (Vehicle) obj;
     return vehicleId == vehicle.vehicleId; // Compare the ID numbers!
 }

 @Override
 public int hashCode() {
     return Objects.hash(vehicleId); // Create a unique digital fingerprint based on the ID
 }

 // Turns the boxes into one neat English sentence for printing
 @Override
 public String toString() {
     return "ID: " + vehicleId + " | Name: " + vehicleName + 
            " | Price: $" + price + " | Status: " + status;
 }
}
