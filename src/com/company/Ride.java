 package com.company;

 import java.util.HashMap;

 public class Ride {
     private boolean taken = false;
     private String source;
     private String destination;
     private driver mainDriver;
     private double cost;
     private IDiscount discount;
     private HashMap<Double, driver> availableDrivers;

     Ride(String s, String d){
         this.source = s;
         this.destination = d;
         availableDrivers = new HashMap<Double, driver>();
     }

     public void completeTheRide(driver iDriver, double cost) {
         this.taken = true;
         this.availableDrivers= null;
         iDriver.addCompleteRide(this);
         this.mainDriver = iDriver;
         this.setCost(cost);

     }
     public void addToMap(driver iDriver, double cost) {
         availableDrivers.put(cost, iDriver);
     }
     public void setCost(double cost) {//set cost
         discount.Discount(cost);
     }
     public void setDriver(driver iDriver) {
         this.mainDriver = iDriver;
     }
     public driver getOffer(double cost) {
         return availableDrivers.get(cost);
     }
     public String getSource() {
         return this.source;
     }
     public String getDestination() {
         return this.destination;
     }
     public driver getDriver() {
         return this.mainDriver;
     }
     public boolean getState() {
         return this.taken;
     }
     public double getCost() {
         return this.cost;
     }
     public int getSizeOfAvailable() {// function to set size of Available
         return availableDrivers.size();
     }
     public void displayAvailable() {

         System.out.println(availableDrivers.toString());
     }
     public String toString() {
         return "Source= " + this.getSource() + ", Destination= " + this.getDestination();
     }
     public String displayRide() {
         return "Source= " + this.getSource() + "\nDestination= " + this.getDestination() + "\nCost= " + this.getCost() + "\nDriver= " + this.getDriver().getUserName();
     }
 }
