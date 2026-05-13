package com.demo.dao;

import com.demo.model.HotelRoom;
import java.util.ArrayList;

public class HotelDao {
    // This ArrayList acts as our database
    private ArrayList<HotelRoom> roomDatabase = new ArrayList<>();

    // Save a room to the database
    public void saveRoom(HotelRoom room) {
        roomDatabase.add(room);
    }

    // Delete a room from the database
    public void deleteRoom(HotelRoom room) {
        roomDatabase.remove(room);
    }

    // Hand over all rooms
    public ArrayList<HotelRoom> getAllRooms() {
        return roomDatabase;
    }

    // Find a specific room by its ID number
    public HotelRoom getRoomById(int roomId) {
        for (HotelRoom room : roomDatabase) {
            if (room.getRoomId() == roomId) {
                return room; // Found it
            }
        }
        return null; // Not found
    }
}