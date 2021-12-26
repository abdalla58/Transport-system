package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class user extends personalInfo implements rate{

    private String area_source;
    private String area_destination;
    private ArrayList<Ride> pendingRides = new ArrayList<Ride>();
    private ArrayList<Ride> completeRides = new ArrayList<Ride>();
    public user(String Name, String email, int phone,String password) {
        super(Name, email, phone,password);
    }
    public user(){}


    public void setArea_destination(String area_destination) {
        this.area_destination = area_destination;
    }
    public String getArea_destination() {
        return area_destination;
    }

    public void setArea_source(String area_source) {
        this.area_source = area_source;
    }

    public String getArea_source() {
        return area_source;
    }

    @Override
    public void newRide(Ride myRide) {

    }

    public Ride getPendingRide(int index) {
        return pendingRides.get(index);
    }
    public Ride getCompleteRide(int index) {
        return completeRides.get(index);
    }
    public void addRideToPending(Ride iRide) {
        pendingRides.add(iRide);
    }
    public void addRideToComplete(Ride iRide) {
        pendingRides.remove(iRide);
        completeRides.add(iRide);
    }
    public int getSizeOfPending() {
        return pendingRides.size();
    }
    public int getSizeOfCompleted() {
        return completeRides.size();
    }
    public void displayCompleted() {
        for(Ride iRide:this.completeRides) {
            System.out.println(iRide.displayRide());
        }
    }
    public void displayPending() {
        System.out.println(this.pendingRides.toString());
    }
    @Override
    public void rateDriver(driver iDriver) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your rate from 1-5: ");
        int rate = scanner.nextInt();
        iDriver.addToMyRatings(this, rate);
        iDriver.clacAverage(rate);
    }
}
