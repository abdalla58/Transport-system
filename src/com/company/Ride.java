 package com.company;
import java.util.HashMap;

public class Ride {
    private boolean taken = false;
    private String source;
    private String destination;
    private int passengers;
    private driver mainDriver;
    private double cost;
    private HashMap<Double, driver> availableDrivers;

    Ride(String s, String d,int p){
        this.source = s;
        this.destination = d;
        this.passengers=p;
        availableDrivers = new HashMap<Double, driver>();
    }

    public void completeTheRide(driver driver, double cost) {
        this.taken = true;
        this.availableDrivers= null;
        driver.addCompleteRide(this);
        this.mainDriver = driver;
        this.setCost(cost);

    }
    public void addToMap(driver iDriver, double cost) {
        availableDrivers.put(cost, iDriver);
    }

    // Setter Methods
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setDriver(driver iDriver) {
        this.mainDriver = iDriver;
    }
    // Getters Methods
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
    public int getSizeOfAvailable() {
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
