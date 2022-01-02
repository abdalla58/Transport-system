package com.company;

import java.time.LocalTime;

public class Event {

    private  driver driver;
    private  user user;
    private String eventTime;
    public Event(){
    }
    public String getCaptainName(){
        return driver.getUserName();
    }
    public void priceAskEvent(){
        System.out.println("Captain put price");
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        System.out.println(getCaptainName());
        System.out.println(driver.getPrice());
    }
    
    public void priceAcceptEvent(){
        System.out.println("client accepted the price");
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        System.out.println(getUserName());
    } public void arrivedLocationEvent(){
        System.out.println("captain reached the location");
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        System.out.println(getCaptainName());
        System.out.println(getUserName());
    }public void arrivedDestinationEvent(){
        System.out.println("captain reached the destination");
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        System.out.println(getCaptainName());
        System.out.println(getUserName());
    }



}
