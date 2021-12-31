package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        controller controller =new controller();
        database d=database.getData();
        d.addUsers(new user("ali","1","0100"));
        d.addUsers(new user("ahmed","123456","0122","ahmed@gmail"));
        d.addDrivers(new driver("alaa","123456","01235478","cu","3010"));
        d.addDrivers(new driver("omar","123456","01235478","giza","giza","4070"));

        label:
        while(true) {
            controller.mainMenu();
            String userInput = input.next();
            switch (userInput) {
                case "1":
                    while (true) {
                        controller.Menu();
                        userInput = input.next();
                        if (userInput.equals("1")) {
                            controller.loginUSer();
                        } else if (userInput.equals("2")) {
                            controller.registerUser();
                        } else if (userInput.equals("0")) {
                            break;
                        } else {
                            System.out.println("Wrong Input");
                        }
                    }
                    break;
                case "2":
                    while (true) {
                        controller.Menu();
                        userInput = input.next();
                        if (userInput.equals("1")) {
                            controller.loginDriver();
                        } else if (userInput.equals("2")) {
                            controller.registerDriver();
                        } else if (userInput.equals("0")) {
                            break;
                        } else {
                            System.out.println("Wrong Input");
                        }
                    }
                    break;
                case "3":
                    controller.adminControl();
                    break;
                case "0":
                    break label;
            }
        }
    }
}
