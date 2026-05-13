package com.demo.service;

import com.demo.dao.HotelDao;
import com.demo.model.HotelRoom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HotelService {
    
    // Create a connection to our database layer
    private HotelDao dao = new HotelDao();

    // a. Add new Room
    public void addRoom(HotelRoom room) {
        dao.saveRoom(room);
        System.out.println("Success: Room added to database!");
    }

    // b. Remove room
    public void removeRoom(int roomId) {
        HotelRoom room = dao.getRoomById(roomId);
        if (room != null) {
            dao.deleteRoom(room);
            System.out.println("Success: Room deleted!");
        } else {
            System.out.println("Error: Room ID not found.");
        }
    }

    // c. Update price
    public void updatePrice(int roomId, double newPrice) {
        HotelRoom room = dao.getRoomById(roomId);
        if (room != null) {
            room.setPrice(newPrice);
            System.out.println("Success: Price updated!");
        } else {
            System.out.println("Error: Room ID not found.");
        }
    }

    // d. Book room
    public void bookRoom(int roomId) {
        HotelRoom room = dao.getRoomById(roomId);
        if (room != null) {
            if (room.getStatus().equals("Available")) {
                room.setStatus("Booked");
                System.out.println("Success: Room is now booked!");
            } else {
                System.out.println("Sorry, room is already booked.");
            }
        } else {
            System.out.println("Error: Room ID not found.");
        }
    }

    // e. Cancel booking
    public void cancelBooking(int roomId) {
        HotelRoom room = dao.getRoomById(roomId);
        if (room != null) {
            if (room.getStatus().equals("Booked")) {
                room.setStatus("Available");
                System.out.println("Success: Booking cancelled!");
            } else {
                System.out.println("Room is already available.");
            }
        } else {
            System.out.println("Error: Room ID not found.");
        }
    }

    // f. Display all
    public void displayAllRooms() {
        ArrayList<HotelRoom> allRooms = dao.getAllRooms();
        if (allRooms.isEmpty()) {
            System.out.println("No rooms in the hotel.");
            return;
        }
        for (HotelRoom room : allRooms) {
            System.out.println(room.toString());
        }
    }

    // g & j. Display / Search by Type
    public void searchByRoomType(String type) {
        boolean found = false;
        for (HotelRoom room : dao.getAllRooms()) {
            if (room.getRoomType().equalsIgnoreCase(type)) {
                System.out.println(room.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No rooms found for type: " + type);
    }

    // h. Display in price range
    public void displayByPriceRange(double min, double max) {
        boolean found = false;
        for (HotelRoom room : dao.getAllRooms()) {
            if (room.getPrice() >= min && room.getPrice() <= max) {
                System.out.println(room.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No rooms in this budget.");
    }

    // i. Sort by price
    public void sortRoomsByPrice() {
        // Get a copy of the list from the database
        ArrayList<HotelRoom> listToSort = new ArrayList<>(dao.getAllRooms());
        
        if (listToSort.isEmpty()) {
            System.out.println("No rooms to sort.");
            return;
        }

        // Sort from lowest to highest price
        Collections.sort(listToSort, new Comparator<HotelRoom>() {
            @Override
            public int compare(HotelRoom r1, HotelRoom r2) {
                return Double.compare(r1.getPrice(), r2.getPrice());
            }
        });

        System.out.println("--- Rooms Sorted by Price ---");
        for (HotelRoom room : listToSort) {
            System.out.println(room.toString());
        }
    }
}