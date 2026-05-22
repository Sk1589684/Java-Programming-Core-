package com.demo.model;


//Borrows the basic boxes from the main GymMember class
public class PremiumMember extends GymMember {
 
 // Extra boxes only for Premium VIP members
 private String dietPlan;
 private String personalTrainer;

 // Setup machine for a Premium Member
 public PremiumMember(int memberId, String memberName, String planType, double fees, String dietPlan, String personalTrainer) {
     // Give the basic details to the parent class
     super(memberId, memberName, planType, fees);
     
     // Save the extra Premium details
     this.dietPlan = dietPlan;
     this.personalTrainer = personalTrainer;
 }

 // Add the extra details to the printed sentence
 @Override
 public String toString() {
     return "[Premium] " + super.toString() + " | Diet: " + dietPlan + " | PT: " + personalTrainer;
 }
}