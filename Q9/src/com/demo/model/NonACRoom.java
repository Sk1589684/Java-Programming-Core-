package com.demo.model;

public class NonACRoom extends HotelRoom {
    private int fanCount;
    private int floorNumber;

    public NonACRoom(int roomId, double price, int fanCount, int floorNumber) {
        super(roomId, "Non-AC", price); // Send basic details to parent
        this.fanCount = fanCount;
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " | Fans: " + fanCount + " | Floor: " + floorNumber;
    }
}
