 package com.company;

import java.util.*;

public class database {
    public static database data;
    private ArrayList<user> users=new ArrayList<user>();
    private ArrayList<user> suspendUsers=new ArrayList<user>();
    private ArrayList<driver> drivers=new ArrayList<driver>();
    private ArrayList<driver> suspendDrivers=new ArrayList<driver>();
    private ArrayList<String> specificAreas=new ArrayList<String>();

//    public static database getInstance() {
//        return data;
//    }
    public static database getData() {
        if (data==null){
            data=new database();
        }

        return data;
    }
    public void addUsers(user u) {
        users.add(u);
    }
    public void addDrivers(driver driver){
        drivers.add(driver);
        RideController.addDriver(driver);
    }
    public driver checkDriver(String name) {
        for(driver driver: drivers) {
            if(driver.getUserName().equals(name))
                return driver;
        }
        return null;
    }
    public user checkUser(String name) {
        for(user user: users) {
            if(user.getUserName().equals(name))
                return user;
        }
        return null;
    }
    
    public void suspendDriver(String name) {
        driver Driver = checkDriver(name);
        if(Driver != null) {
            suspendDrivers.add(Driver);
            drivers.remove(Driver);
            RideController.removeDriver(Driver);
        }else {
            System.out.println("There's no such a driver.");
        }
    }
    public void suspendUser(String name) {
        user user = checkUser(name);
        if(user != null) {
            suspendUsers.add(user);
            users.remove(user);
        }else {
            System.out.println("There's no such a user.");
        }
    }
    public void displayDrivers(){
        for (int i=0;i<drivers.size();i++) {
            System.out.println("driver name:"+drivers.get(i).getUserName());
            System.out.println("driver Phone:"+drivers.get(i).getPhone());
            System.out.println("driver Email:"+drivers.get(i).getEmail());
            System.out.println("driver Licence:"+drivers.get(i).getLicence());
            System.out.println("driver NationalID:"+drivers.get(i).getNationalID());
        }
    }public void displayUsers(){
        for (int i=0;i<users.size();i++) {
            System.out.println("user name:"+users.get(i).getUserName());
            System.out.println("user Phone:"+users.get(i).getPhone());
            System.out.println("user Email:"+users.get(i).getEmail());
        }
    }
    public boolean checkUser(String name ,String pass){
        boolean f=true;
        for (com.company.user user : users) {
            if (name.equals(user.email)&&pass.equals(user.password)) {
                    f = true;
                    break;
            } else{
                System.out.println("user not found");
                f=false;
            }
        }
        return f;
    }
    public boolean checkDriver(String name,String pass){
        boolean f=true;
        for (com.company.driver driver : drivers) {
            if (name.equals(driver.email)&&pass.equals(driver.password)) {
                f=true;
                break;
           }else{
                System.out.println("driver not found");
                f=false;
            }
        }
        return f;
    }

    public ArrayList<String> getSpecificAreas() {
        return specificAreas;
    }
    public void addSpecificAreas(String area){
        specificAreas.add(area);
    }

}


