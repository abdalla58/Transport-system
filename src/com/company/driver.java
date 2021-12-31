package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class driver extends personalInfo implements Drivers {

    private String license;
    private String nationalId;
    private HashMap<rate, Integer> myRatings = new HashMap<rate, Integer>();
    private int sumOfRate;
    private double averageRating;
    private ArrayList<Ride> completeRides= new ArrayList<Ride>();
    private Queue<Ride> pendingRides= new LinkedList<Ride>();
    private ArrayList<String> favAreas = new ArrayList<String>();
    Scanner input = new Scanner(System.in);
    double price;
    driver(String userName, String password, String mobile, String license, String nationalId){
        super(userName, password, mobile);
        this.license = license;
        this.nationalId = nationalId;
    }
    driver(String userName, String password, String mobile, String email, String license, String nationalId){
        super(userName, password, mobile, email);
        this.license = license;
        this.nationalId = nationalId;
    }

    // Setters
    public void setLicense(String license) {
        this.license = license;
    }

    public void setId(String id) {
        this.nationalId = id;
    }

    public void addCompleteRide(Ride myRide) {
        completeRides.add(myRide);
    }

    public void clacAvergae(int rate) {
        this.sumOfRate += rate;
        this.averageRating = (double) this.sumOfRate /  myRatings.size();
    }

    public String getNationalId() {
        return this.nationalId;
    }
    public String getLicense() {
        return this.license;
    }
    public double getAvgRate() {
        return this.averageRating;
    }
    public void addToMyRatings(rate user, int rate){
        myRatings.put(user, rate);
    }
    public boolean isInMyArea(String source) {
        return favAreas.contains(source);
    }
    public void setFavAreas() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while(true) {
            System.out.print("Enter your favorite area: ");
            userInput = scanner.next();
            if(userInput.equals("0"))
                break;
            favAreas.add(userInput);
        }
    }
    public void setOffer() {
        while(!pendingRides.isEmpty()) {
            System.out.println(pendingRides.peek().toString());
            System.out.println("Enter your offer for this Ride: ");
            price = input.nextDouble();
            pendingRides.peek().addToMap(this, price);
            pendingRides.poll();
        }
    }
    public void displayRatings() {
        System.out.println(this.myRatings.toString());
    }
    public void displayFavAreas() {
        System.out.println(this.favAreas.toString());
    }
    @Override
    public void newRide(Ride ride) {
        if(isInMyArea(ride.getSource())) {
            pendingRides.add(ride);
        };
    }

    @Override
    public String toString() {
        return "userName= " + this.getUserName() + ", AvgRate= " + this.getAvgRate();
    }
    public String displayData() {
        return "userName= " + this.getUserName() + "\nNationalId= " + this.getNationalId() + "\nLicense= " + this.getLicense() + "\nMobile= " + this.getMobile() +
                "\nAvgRate= " + this.getAvgRate();
    }
}
