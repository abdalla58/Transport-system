 package com.company;

 import java.util.ArrayList;

 public class database {

     private static database Data;
     private ArrayList<driver> drivers=new ArrayList<driver>();;
     private ArrayList<user> users=new ArrayList<user>();
     private ArrayList<driver> suspendDrivers=new ArrayList<driver>();
     private ArrayList<user> suspendUsers=new ArrayList<user>();
     private ArrayList<String> specificAreas=new ArrayList<String>();
     private ArrayList<Event>events=new ArrayList<Event>();
     private database() {
     }

     public static database getData() {
         if(Data == null)
             Data = new database();

         return Data;
     }

     public ArrayList<Event> getEvents() {
         return events;
     }
     public void addEvent(Event event){
         events.add(event);
     }

     public driver checkDriver(String userName, String password) {
         for(driver driver: drivers) {
             if(driver.getUserName().equals(userName) && driver.getPassword().equals(password))
                 return driver;
         }
         return null;
     }
     public user checkUser(String userName, String password) {
         for(user user : users) {
             if(user.getUserName().equals(userName) && user.getPassword().equals(password))
                 return user;
         }
         return null;
     }
     public driver driverExistence(String name) {
         for(driver driver: drivers) {
             if(driver.getUserName().equals(name))
                 return driver;
         }
         return null;
     }
     public user userExistence(String name) {
         for(user user : users) {
             if(user.getUserName().equals(name))
                 return user;
         }
         return null;
     }
     public void addDrivers(driver driver) {
         drivers.add(driver);
         RideController.addDriver(driver);
     }
     public void addUsers(user user) {
         users.add(user);
     }
     public void suspendDriver(String name) {
         driver driver = driverExistence(name);
         if(driver != null) {
             suspendDrivers.add(driver);
             drivers.remove(driver);
             RideController.removeDriver(driver);

         }else {
             System.out.println("There's no such a driver.");
         }
     }
     public void suspendUser(String name) {
         user user = userExistence(name);
         if(user != null) {
             suspendUsers.add(user);
             users.remove(user);
         }else {
             System.out.println("There's no such a user.");
         }
     }
     public void addSpecificAreas(String area){
         System.out.println("area is added");
         specificAreas.add(area);
     }

     public void setSpecificAreas(ArrayList<String> specificAreas) {
         this.specificAreas = specificAreas;
     }

     public ArrayList<String> getSpecificAreas() {
         return specificAreas;
     }

     public void displayAllDrivers() {
         System.out.println(drivers.toString());
     }
     public void displayAllClients() {
         System.out.println(users.toString());
     }


 }
