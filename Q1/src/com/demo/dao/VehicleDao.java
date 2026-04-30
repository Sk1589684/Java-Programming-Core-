package com.demo.dao;

import com.demo.model.Vehicle;
import java.util.HashSet;

public class VehicleDao {
    
    // Our filing cabinet is a HashSet. It is like a bucket that automatically destroys duplicates!
    private HashSet<Vehicle> vehicleDatabase = new HashSet<>();

    // Try to put a new vehicle in the bucket
    public boolean saveVehicle(Vehicle vehicle) {
        // .add() will automatically return 'false' if it detects a duplicate ID!
        return vehicleDatabase.add(vehicle);
    }

    // Throw a vehicle out of the bucket
    public void deleteVehicle(Vehicle vehicle) {
        vehicleDatabase.remove(vehicle);
    }

    // Grab ALL the vehicles from the bucket
    public HashSet<Vehicle> getAllVehicles() {
        return vehicleDatabase;
    }

    // Dig through the bucket to find one specific vehicle using its ID
    public Vehicle getVehicleById(int vehicleId) {
        for (Vehicle vehicle : vehicleDatabase) {
            if (vehicle.getVehicleId() == vehicleId) {
                return vehicle; // Found it!
            }
        }
        return null; // Looked everywhere, found nothing.
    }
}