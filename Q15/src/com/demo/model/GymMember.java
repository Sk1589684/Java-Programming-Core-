package com.demo.model;

//This is the basic blueprint. ANY member in our gym will have these details.
public class GymMember {
 
 // Locked boxes to hold the member's details safely
 private int memberId;
 private String memberName;
 private String planType;   // Example: "Monthly" or "Yearly"
 private double fees;       // How much they pay
 private String status;     // "Active" or "Inactive"

 // The Setup Machine. When a new person joins, we fill these boxes.
 public GymMember(int memberId, String memberName, String planType, double fees) {
     this.memberId = memberId;
     this.memberName = memberName;
     this.planType = planType;
     this.fees = fees;
     this.status = "Active"; // A brand new member is automatically Active
 }

 // "Getters": Safe peepholes to look at what is inside the boxes
 public int getMemberId() { return memberId; }
 public String getMemberName() { return memberName; }
 public String getPlanType() { return planType; }
 public double getFees() { return fees; }
 public String getStatus() { return status; }

 // "Setters": Safe doors to change what is inside the boxes later
 public void setFees(double fees) { this.fees = fees; }
 public void setStatus(String status) { this.status = status; }

 // Turns all the boxes into one neat English sentence for printing
 @Override
 public String toString() {
     return "ID: " + memberId + " | Name: " + memberName + 
            " | Plan: " + planType + " | Fees: $" + fees + " | Status: " + status;
 }
}