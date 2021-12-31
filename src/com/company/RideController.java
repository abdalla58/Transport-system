package com.company;

import java.util.ArrayList;

public class RideController {

    private static ArrayList<Drivers> drivers = new ArrayList<Drivers>();


    public void notifyDrivers(Ride myRide) {
        for(Drivers only : drivers) {
            only.newRide(myRide);
        }
    }
    public static void addDriver(Drivers myDriver) {
        drivers.add(myDriver);
    }
    public static void removeDriver(Drivers myDriver) {
        drivers.remove(myDriver);
    }
}
