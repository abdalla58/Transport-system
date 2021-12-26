package com.company;

import java.util.ArrayList;

public class RideController {

    private static ArrayList<Drivers> myDrivers = new ArrayList<Drivers>();


    public void notifyDrivers(Ride myRide) {
        for(Drivers only : myDrivers) {
            only.newRide(myRide);
        }
    }
    public static void addDriver(Drivers myDriver) {
        myDrivers.add(myDriver);
    }
    public static void removeDriver(Drivers myDriver) {
        myDrivers.remove(myDriver);
    }
}
