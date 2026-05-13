package com.demo.model;

//"extends" means ACRoom borrows all the basic boxes from HotelRoom
public class ACRoom extends HotelRoom {

// Extra boxes only for AC rooms
private String acType;      // Example: Window or Split AC
private int numberOfBeds;   // Example: 1 or 2 beds

// Setup step for a new AC Room
public ACRoom(int roomId, double price, String acType, int numberOfBeds) {
   // 'super' means give the basic details to the parent (HotelRoom) to handle
   super(roomId, "AC", price);
   
   // Save the extra AC details
   this.acType = acType;
   this.numberOfBeds = numberOfBeds;
}

// Add the extra AC details to the printed sentence
@Override
public String toString() {
   return super.toString() + " | AC Type: " + acType + " | Beds: " + numberOfBeds;
}


}
