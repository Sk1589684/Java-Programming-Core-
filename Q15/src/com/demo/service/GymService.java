package com.demo.service;

import com.demo.dao.GymDao;
import com.demo.model.GymMember;
import com.demo.model.PremiumMember;
import com.demo.model.RegularMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GymService {
    
    // The Manager needs a connection to the Filing Cabinet (DAO)
    private GymDao dao = new GymDao();

    // a. Add a new member
    public void addMember(GymMember member) {
        dao.saveMember(member); // Tell cabinet to store it
        System.out.println("Success: Gym member added!");
    }

    // b. Remove a member
    public void removeMember(int memberId) {
        GymMember member = dao.getMemberById(memberId); // Look for them first
        if (member != null) {
            dao.deleteMember(memberId); // Tell cabinet to delete
            System.out.println("Success: Member removed!");
        } else {
            System.out.println("Error: Cannot find that member ID.");
        }
    }

    // c. Change the member's fees
    public void updateFees(int memberId, double newFees) {
        GymMember member = dao.getMemberById(memberId);
        if (member != null) {
            member.setFees(newFees); // Update the price box
            System.out.println("Success: Fees updated!");
        } else {
            System.out.println("Error: Cannot find that member ID.");
        }
    }

    // d. Flip the membership between Active and Inactive
    public void toggleStatus(int memberId) {
        GymMember member = dao.getMemberById(memberId);
        if (member != null) {
            // If they are active, make them inactive. If inactive, make them active.
            if (member.getStatus().equals("Active")) {
                member.setStatus("Inactive");
                System.out.println("Success: Membership is now Inactive.");
            } else {
                member.setStatus("Active");
                System.out.println("Success: Membership is now Active.");
            }
        } else {
            System.out.println("Error: Cannot find that member ID.");
        }
    }

    // e. Find memberships that match a plan type and fit a budget
    public void assignMembership(String planType, double maxFees) {
        boolean found = false;
        System.out.println("--- Looking for Plan: " + planType + " under $" + maxFees + " ---");
        
        for (GymMember member : dao.getAllMembers()) {
            // Check if both rules match
            if (member.getPlanType().equalsIgnoreCase(planType) && member.getFees() <= maxFees) {
                System.out.println(member.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No matching memberships found.");
    }

    // f. Show all members on the screen
    public void displayAllMembers() {
        if (dao.getAllMembers().isEmpty()) {
            System.out.println("No members in the gym yet.");
            return;
        }
        for (GymMember member : dao.getAllMembers()) {
            System.out.println(member.toString());
        }
    }

    // g. Show members of a specific type (Regular or Premium)
    public void displayByType(String type) {
        boolean found = false;
        for (GymMember member : dao.getAllMembers()) {
            if (type.equalsIgnoreCase("Regular") && member instanceof RegularMember) {
                System.out.println(member.toString());
                found = true;
            } else if (type.equalsIgnoreCase("Premium") && member instanceof PremiumMember) {
                System.out.println(member.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No members found for type: " + type);
    }

    // h. Show members paying MORE than a specific amount
    public void displayAboveFees(double minFees) {
        boolean found = false;
        for (GymMember member : dao.getAllMembers()) {
            if (member.getFees() > minFees) {
                System.out.println(member.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No members found paying more than $" + minFees);
    }

    // i. Sort members from cheapest fees to most expensive
    public void sortMembersByFees() {
        // Grab all members and put them in a temporary list to organize them
        ArrayList<GymMember> listToSort = new ArrayList<>(dao.getAllMembers());
        
        if (listToSort.isEmpty()) {
            System.out.println("No members to sort.");
            return;
        }

        // Built-in Java tool to sort the list
        Collections.sort(listToSort, new Comparator<GymMember>() {
            @Override
            public int compare(GymMember m1, GymMember m2) {
                return Double.compare(m1.getFees(), m2.getFees());
            }
        });

        System.out.println("--- Members Sorted by Fees (Cheapest First) ---");
        for (GymMember member : listToSort) {
            System.out.println(member.toString());
        }
    }

    // j. Search by Name
    public void searchByName(String searchName) {
        boolean found = false;
        for (GymMember member : dao.getAllMembers()) {
            // Check if the typed letters are part of the member's real name
            if (member.getMemberName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Found: " + member.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Sorry, couldn't find a member with that name.");
    }
}