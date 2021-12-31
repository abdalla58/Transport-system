package com.company;


import java.util.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class admin {

    private Queue<driver> appendDrivers = new LinkedList<driver>();
    Scanner input = new Scanner(System.in);
    public void addToPendingDrivers(driver iDriver) {
        appendDrivers.add(iDriver);
    }
    public void takeAction() {

        while(!appendDrivers.isEmpty()) {
            appendDrivers.peek().toString();
            System.out.println("1- Accept, 2- Deny");
            int userInput = input.nextInt();
            if(userInput == 1) {
                database.getData().addDrivers(appendDrivers.poll());
            }
            else if(userInput == 2) {
                appendDrivers.poll();
            }
        }
    }
    public void suspendDriver(String name) {
        database.getData().suspendDriver(name);
    }
    public void suspendClient(String name) {
        database.getData().suspendUser(name);
    }
    public void DisplayAllClients() {
        database.getData().displayAllDrivers();
    }
    public void DisplayAllDrivers() {
        database.getData().displayAllClients();
    }
    public void addSpecificAreas(String area){
        database.getData().addSpecificAreas(area);
    }
}
