package com.demo.test;

import com.demo.model.PremiumMember;
import com.demo.model.RegularMember;
import com.demo.service.GymService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        
        // Tool to read the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        // Create our Manager (Service)
        GymService manager = new GymService();

        // Infinite loop to keep the menu showing until the user quits
        while (true) {
            System.out.println("\n=== Full Gym Menu ===");
            System.out.println("a. Add new Member");
            System.out.println("b. Remove member using memberId");
            System.out.println("c. Update member fees");
            System.out.println("d. Activate/Deactivate membership");
            System.out.println("e. Assign/Find membership (by Plan & Budget)");
            System.out.println("f. Display all members");
            System.out.println("g. Display members by type");
            System.out.println("h. Display members with fees greater than...");
            System.out.println("i. Sort members by fees");
            System.out.println("j. Search member by name");
            System.out.println("k. Exit");
            System.out.print("What would you like to do? Enter a letter: ");
            
            // Read the letter typed
            char choice = keyboard.next().toLowerCase().charAt(0);
            
            // Clear the invisible "Enter" key press so the scanner doesn't glitch
            keyboard.nextLine(); 

            switch (choice) {
                case 'a': // Add Member
                    System.out.print("Enter Member ID: ");
                    int id = keyboard.nextInt();
                    keyboard.nextLine(); // Clear enter key
                    
                    System.out.print("Enter Member Name: ");
                    String name = keyboard.nextLine();
                    
                    System.out.print("Enter Plan Type (e.g., Monthly, Yearly): ");
                    String plan = keyboard.nextLine();
                    
                    System.out.print("Enter Fees: $");
                    double fees = keyboard.nextDouble();
                    
                    System.out.print("Type 1 for Regular, 2 for Premium: ");
                    int type = keyboard.nextInt();
                    keyboard.nextLine(); // Clear enter key
                    
                    if (type == 1) { // Regular Member
                        System.out.print("Enter Trainer Name: ");
                        String trainer = keyboard.nextLine();
                        System.out.print("Enter Workout Hours: ");
                        int hours = keyboard.nextInt();
                        
                        manager.addMember(new RegularMember(id, name, plan, fees, trainer, hours));
                    } 
                    else if (type == 2) { // Premium Member
                        System.out.print("Enter Diet Plan Name: ");
                        String diet = keyboard.nextLine();
                        System.out.print("Enter Personal Trainer Name: ");
                        String pt = keyboard.nextLine();
                        
                        manager.addMember(new PremiumMember(id, name, plan, fees, diet, pt));
                    }
                    break;

                case 'b': // Remove Member
                    System.out.print("Enter Member ID to remove: ");
                    manager.removeMember(keyboard.nextInt());
                    break;

                case 'c': // Update Fees
                    System.out.print("Enter Member ID to update: ");
                    int updateId = keyboard.nextInt();
                    System.out.print("Enter New Fees: $");
                    double newFees = keyboard.nextDouble();
                    manager.updateFees(updateId, newFees);
                    break;

                case 'd': // Toggle Status
                    System.out.print("Enter Member ID to flip Active/Inactive status: ");
                    manager.toggleStatus(keyboard.nextInt());
                    break;

                case 'e': // Find by Plan and Budget
                    System.out.print("Enter Plan Type to look for (e.g., Monthly): ");
                    String searchPlan = keyboard.nextLine();
                    System.out.print("Enter Maximum Budget: $");
                    double maxBudget = keyboard.nextDouble();
                    manager.assignMembership(searchPlan, maxBudget);
                    break;

                case 'f': // Display All
                    System.out.println("--- All Gym Members ---");
                    manager.displayAllMembers();
                    break;

                case 'g': // Display by Type
                    System.out.print("Enter Type (Regular / Premium): ");
                    manager.displayByType(keyboard.nextLine());
                    break;

                case 'h': // Display Above Fees
                    System.out.print("Display members paying MORE than: $");
                    manager.displayAboveFees(keyboard.nextDouble());
                    break;

                case 'i': // Sort by Fees
                    manager.sortMembersByFees();
                    break;

                case 'j': // Search Name
                    System.out.print("Enter part of the member's name to search for: ");
                    manager.searchByName(keyboard.nextLine());
                    break;

                case 'k': // Exit
                    System.out.println("Shutting down Gym System. Have a great workout!");
                    keyboard.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid letter! Please choose an option from a to k.");
            }
        }
    }
}