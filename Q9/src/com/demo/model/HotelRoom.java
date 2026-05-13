package com.demo.model;

//Basic blueprint for all rooms
public class HotelRoom {
 private int roomId;
 private String roomType; // AC or Non-AC
 private double price;
 private String status;   // Available or Booked

 public HotelRoom(int roomId, String roomType, double price) {
     this.roomId = roomId;
     this.roomType = roomType;
     this.price = price;
     this.status = "Available"; // New rooms are always available
 }

 // Getters
 public int getRoomId() { return roomId; }
 public String getRoomType() { return roomType; }
 public double getPrice() { return price; }
 public String getStatus() { return status; }

 // Setters
 public void setPrice(double price) { this.price = price; }
 public void setStatus(String status) { this.status = status; }

 @Override
 public String toString() {
     return "ID: " + roomId + " | Type: " + roomType + " | Price: $" + price + " | Status: " + status;
 }
}