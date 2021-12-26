package com.company;

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
}
