package com.company;

import java.util.ArrayList;

public class RideController {

    private static ArrayList<Drivers> driversArrayList = new ArrayList<Drivers>();


    public void notifyDrivers(Ride myRide) {
        for(Drivers only : driversArrayList) {
            only.newRide(myRide);
        }
    }
    public static void addDriver(Drivers myDriver) {
        driversArrayList.add(myDriver);
    }
    public static void removeDriver(Drivers myDriver) {
        driversArrayList.remove(myDriver);
    }
}
