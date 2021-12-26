package com.company;

import java.time.LocalTime;
import java.util.Collections;

public class Event {
    private String eventName;
    private driver driver=new driver();
    private user user=new user();
    private String eventTime;

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getEventName() {
        return eventName;
    }
    public String getCaptainName(){
        return driver.getUserName();
    }
    public String getUserName(){
        return user.getUserName();
    }
    public void priceAskEvent(){
        System.out.println(getEventName());
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        System.out.println(getCaptainName());
        System.out.println(driver.getPrice());
    }
    public void priceAcceptEvent(){
        System.out.println(getEventName());
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        System.out.println(getUserName());
    } public void arrivedLocationEvent(){
        System.out.println(getEventName());
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        System.out.println(getCaptainName());
        System.out.println(getUserName());
    }public void arrivedDestinationEvent(){
        System.out.println(getEventName());
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        System.out.println(getCaptainName());
        System.out.println(getUserName());
    }



}
