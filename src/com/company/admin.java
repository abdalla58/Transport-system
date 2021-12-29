package com.company;


import java.util.*;

public class admin {

    private Queue<driver> appendDrivers = new LinkedList<driver>();
    private ArrayList<driver> pendingDrivers=new ArrayList<driver>();
    private database database=new database();
    public void addToAppendingDrivers(driver driver) {
        pendingDrivers.add(driver);
    }
    Scanner scanner = new Scanner(System.in);
    public void verifyDrivers() {
        System.out.println("work");
        for (int i=0;i<pendingDrivers.size();i++){
            System.out.println(pendingDrivers.get(i).getUserName());
            System.out.println("1- Accept, 2- Deny");
            int userInput = scanner.nextInt();
            if(userInput == 1) {
                database.getData().addDrivers(pendingDrivers.get(i));
                pendingDrivers.remove(i);
            }
            else if(userInput == 2) {
                pendingDrivers.remove(i);
            }
        }
    }
    public void addSpecificAreas(String area){

        database.getData().addSpecificAreas(area);
    }
    public void suspend_driver(String name)
    {
        database x=new database();
        x.getData().suspendDriver(name);
    }
    public void suspend_user(String name)
    {
        database x=new database();
        x.getData().suspendUser(name);
    }
    public void DisplayAllUsers() {
        database x=new database();
        x.getData().displayUsers();
    }
    public void DisplayAllDrivers() {
        database x=new database();
        x.getData().displayDrivers();
    }
}
