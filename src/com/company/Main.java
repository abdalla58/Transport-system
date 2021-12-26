package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        controller controller=new controller();
        database database=new database();
        user user=new user("ahmed","a@a.com",010,"a");
        driver driver=new driver("ahmed","a@a.com",010,"a","cu",300);
        database.addDrivers(driver);
        database.addUsers(user);
        ///database.displayUsers();
        //database.displayDrivers();
        while(true) {
            controller.mainMenu();
            String userInput = input.next();
            if(userInput.equals("1")) {
                while(true) {
                    controller.Menu();
                    userInput = input.next();
                    if(userInput.equals("1")) {
                        controller.loginUSer();
                    }
                    else if(userInput.equals("2")) {
                        controller.registerUser();
                    }
                    else if(userInput.equals("0")) {
                        break;
                    }
                    else {
                        System.out.println("Wrong Input");
                    }
                }
            }
            else if(userInput.equals("2")) {
                while(true) {
                    controller.Menu();
                    userInput = input.next();
                    if(userInput.equals("1")) {
                        controller.loginDriver();
                    }
                    else if(userInput.equals("2")) {
                        controller.registerDriver();
                    }
                    else if(userInput.equals("0")) {
                        break;
                    }
                    else {
                        System.out.println("Wrong Input");
                    }
                }
            }
            else if(userInput.equals("3")) {
                controller.adminControl();
            }
            else if(userInput.equals("0"))
                break;
        }
    }
}
