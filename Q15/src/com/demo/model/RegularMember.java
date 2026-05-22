package com.demo.model;

//Borrows the basic boxes from the main GymMember class
public class RegularMember extends GymMember {
 
 // Extra boxes only for Regular members
 private String trainerName;
 private int workoutHours;

 // Setup machine for a Regular Member
 public RegularMember(int memberId, String memberName, String planType, double fees, String trainerName, int workoutHours) {
     // Give the basic details to the parent class to handle
     super(memberId, memberName, planType, fees);
     
     // Save the extra Regular details
     this.trainerName = trainerName;
     this.workoutHours = workoutHours;
 }

 // Add the extra details to the printed sentence
 @Override
 public String toString() {
     return "[Regular] " + super.toString() + " | Trainer: " + trainerName + " | Hours: " + workoutHours;
 }
}