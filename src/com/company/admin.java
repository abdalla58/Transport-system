package com.company;


import java.util.*;

public class admin {

    private Queue<driver> appendDrivers = new LinkedList<driver>();
    public void addToAppendingDrivers(driver d) {
        appendDrivers.add(d);
    }
    public void verifyDrivers()
    {
        database database=new database();
        Scanner scanner = new Scanner(System.in);
        while (!appendDrivers.isEmpty()){
            appendDrivers.peek().toString();
            System.out.println("1- Accept, 2- Deny");
            int input = scanner.nextInt();
            if (input==1){
                database.addDrivers(appendDrivers.poll());
            }else if (input==2){
                appendDrivers.poll();
            }
        }
    }
    public void suspend_driver(String name)
    {
        database x=new database();
        x.removeDriverFromSystem(name);
    }
    public void suspend_user(String name)
    {
        database x=new database();
        x.removeUserFromSystem(name);
    }
    public void DisplayAllUsers() {
        database x=new database();
        x.displayUsers();
    }
    public void DisplayAllDrivers() {
        database x=new database();
        x.displayDrivers();
    }

}
