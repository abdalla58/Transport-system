package com.company;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class admin {

    private Queue<driver> appendDrivers = new LinkedList<driver>();
    Scanner input = new Scanner(System.in);
    private database myData=database.getData();
    public void addToPendingDrivers(driver iDriver) {
        appendDrivers.add(iDriver);
    }
    public void verifyDrivers() {

        while(!appendDrivers.isEmpty()) {
            appendDrivers.peek().toString();
            System.out.println("1- Accept, 2- Deny");
            int userInput = input.nextInt();
            if(userInput == 1) {
                myData.addDrivers(appendDrivers.poll());
            }
            else if(userInput == 2) {
                appendDrivers.poll();
            }
        }
    }
    public void suspendDriver(String name) {
        myData.suspendDriver(name);
    }
    public void suspendClient(String name) {
        myData.suspendUser(name);
    }
    public void DisplayAllClients() {
        myData.displayAllDrivers();
    }
    public void DisplayAllDrivers() {
        myData.displayAllClients();
    }
    public void addSpecificAreas(String area){
        myData.addSpecificAreas(area);
    }
    public void showEvent(){myData.getEvents();}
}
