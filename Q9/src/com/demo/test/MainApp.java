package com.demo.test;

import com.demo.model.ACRoom;
import com.demo.model.NonACRoom;
import com.demo.service.HotelService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        // Connect to our Service layer
        HotelService service = new HotelService();

        while (true) {
            System.out.println("\n=== Hotel Menu (DAO Architecture) ===");
            System.out.println("a. Add new Room");
            System.out.println("b. Remove room using roomId");
            System.out.println("c. Update room price");
            System.out.println("d. Book room");
            System.out.println("e. Cancel booking");
            System.out.println("f. Display all rooms");
            System.out.println("g. Display rooms by type");
            System.out.println("h. Display rooms within price range");
            System.out.println("i. Sort rooms by price");
            System.out.println("j. Search room by roomType");
            System.out.println("k. Exit");
            System.out.print("Enter choice: ");
            
            char choice = keyboard.next().toLowerCase().charAt(0);
            keyboard.nextLine(); // clear leftover enter key

            switch (choice) {
                case 'a':
                    System.out.print("Enter Room ID: ");
                    int id = keyboard.nextInt();
                    System.out.print("Enter Price: ");
                    double price = keyboard.nextDouble();
                    System.out.print("Type 1 for AC, 2 for Non-AC: ");
                    int typeChoice = keyboard.nextInt();
                    keyboard.nextLine();
                    
                    if (typeChoice == 1) {
                        System.out.print("Enter AC Type (Split/Window): ");
                        String acType = keyboard.nextLine();
                        System.out.print("Enter Bed Count: ");
                        int beds = keyboard.nextInt();
                        service.addRoom(new ACRoom(id, price, acType, beds));
                    } else if (typeChoice == 2) {
                        System.out.print("Enter Fan Count: ");
                        int fans = keyboard.nextInt();
                        System.out.print("Enter Floor Number: ");
                        int floor = keyboard.nextInt();
                        service.addRoom(new NonACRoom(id, price, fans, floor));
                    }
                    break;

                case 'b':
                    System.out.print("Enter Room ID to remove: ");
                    service.removeRoom(keyboard.nextInt());
                    break;

                case 'c':
                    System.out.print("Enter Room ID to update: ");
                    int updateId = keyboard.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = keyboard.nextDouble();
                    service.updatePrice(updateId, newPrice);
                    break;

                case 'd':
                    System.out.print("Enter Room ID to book: ");
                    service.bookRoom(keyboard.nextInt());
                    break;

                case 'e':
                    System.out.print("Enter Room ID to cancel booking: ");
                    service.cancelBooking(keyboard.nextInt());
                    break;

                case 'f':
                    service.displayAllRooms();
                    break;

                case 'g':
                case 'j': // Both ask to search/display by type
                    System.out.print("Enter Room Type (AC / Non-AC): ");
                    service.searchByRoomType(keyboard.nextLine());
                    break;

                case 'h':
                    System.out.print("Enter Min Price: ");
                    double min = keyboard.nextDouble();
                    System.out.print("Enter Max Price: ");
                    double max = keyboard.nextDouble();
                    service.displayByPriceRange(min, max);
                    break;

                case 'i':
                    service.sortRoomsByPrice();
                    break;

                case 'k':
                    System.out.println("System shutting down. Goodbye!");
                    keyboard.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}