package com.company;

import java.util.*;

public class driver extends personalInfo implements Drivers{
    private String Licence;
    private int NationalID;
    private HashMap<rate, Integer> myRatings = new HashMap<rate, Integer>();
    private int sumOfRate;
    private double averageRating;
    private ArrayList<Ride> completeRides= new ArrayList<Ride>();
    private Queue<Ride> pendingRides= new LinkedList<Ride>();
    private ArrayList<String> favAreas = new ArrayList<String>();
    public driver(){}

    public driver(String Name, String email, int phone, String password,String Licence,int NationalID) {
        super(Name, email, phone,password);
        this.Licence=Licence;
        this.NationalID=NationalID;
    }
    public void setLicence(String licence) {
        Licence = licence;
    }
    public String getLicence() {
        return Licence;
    }
    public void setNationalID(int nationalID) {
        NationalID = nationalID;
    }
    public int getNationalID() {
        return NationalID;
    }

    public void clacAverage(int rate) {
        this.sumOfRate += rate;
        this.averageRating = (double) this.sumOfRate /  myRatings.size();
    }
    public void addToMyRatings(rate iClient, int rate){
        myRatings.put(iClient, rate);
    }
    public boolean isInMyArea(String source) {
        return favAreas.contains(source);
    }
    public void setFavAreas() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while(true) {
            System.out.print("Enter your favorite area: ");
            // add here function to check if the area is correct or not
            userInput = scanner.next();
            if(userInput.equals("0"))
                break;
            favAreas.add(userInput);
        }
    }
    public void setOffer() {
        Scanner scanner = new Scanner(System.in);
        double cost;
        while(!pendingRides.isEmpty()) {
            System.out.println(pendingRides.peek().toString());
            System.out.println("Enter your offer for this Ride: ");
            cost = scanner.nextDouble();
            pendingRides.peek().addToMap(this, cost);
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
    public void newRide(Ride myRide) {
        if(isInMyArea(myRide.getSource())) {
            pendingRides.add(myRide);
        };
    }

    @Override
    public String toString() {
        return "userName= " + this.getName() ;
    }
    public String displayData() {
        return "userName= " + this.getName() + "\nNationalId= " + this.getNationalID() + "\nLicense= " + this.getLicence() + "\nMobile= " + this.getPhone() ;
    }
}
