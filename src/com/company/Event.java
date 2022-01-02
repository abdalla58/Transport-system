package com.company;

import java.time.LocalTime;

public class Event {
    private String eventName;
    private LocalTime eventTime;
    private String eventCaptain;
    private String eventUser;
    private double eventPrice;
    private database myData=database.getData();
    public Event(){}

    public Event(String eventName,LocalTime eventTime ,String eventCaptain,String eventUser,double eventPrice){
        this.eventName=eventName;
        this.eventTime=eventTime;
        this.eventCaptain=eventCaptain;
        this.eventUser=eventUser;
        this.eventPrice=eventPrice;
    }
    public void priceAskEvent(String eventCaptain,double eventPrice){
        LocalTime myObj = LocalTime.now();
        myData.addEvent(new Event("Captain put price",myObj,eventCaptain,"",eventPrice));
    }
    public void priceAcceptEvent(String eventUser){
        LocalTime myObj = LocalTime.now();
        myData.addEvent(new Event("client accepted the price",myObj,"",eventUser,0));
    } public void arrivedLocationEvent(String eventCaptain,String eventUser){
        LocalTime myObj = LocalTime.now();
        myData.addEvent(new Event("captain reached the location",myObj,eventCaptain,eventUser,0));
    }public void arrivedDestinationEvent(String eventCaptain,String eventUser){
        LocalTime myObj = LocalTime.now();
        myData.addEvent(new Event("captain reached the destination",myObj,eventCaptain,eventUser,0));
    }

}
