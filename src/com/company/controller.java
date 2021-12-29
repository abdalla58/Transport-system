package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class controller {
    private ArrayList<String> favAreas = new ArrayList<String>();
    private user user=new user();
    private driver driver=new driver();
    private admin admin=new admin();
    private database database=new database();
    private Event event=new Event();
    //private Discount discount=new Discount();
    private RideController myController=new RideController();
    Scanner input=new Scanner(System.in);
    public void mainMenu() {
        System.out.println("Welcome, Enter as:");
        System.out.println("1- User");
        System.out.println("2- Driver");
        System.out.println("3- Admin");
        System.out.println("Enter 0 to Exit");
    }
    public void Menu() {
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("Enter 0 to return");
    }
    public void userMenu() {
        System.out.println("Welcome ");
        System.out.println("1- Take a ride");
        System.out.println("2- Display my complete rides");
        System.out.println("3- Display my pending rides");
        System.out.println("4- Sign out");
    }
    public void driverMenu() {
        System.out.println("Welcome Driver " + driver.getUserName());
        System.out.println("1- Show available rides");
        System.out.println("2- Show Client Ratings");
        System.out.println("3- Show Favorite Areas");
        System.out.println("4- Add favourite Area");
        System.out.println("5- Sign out");
    }
    public void adminMainMenu() {
        System.out.println("Welcome Admin ");
        System.out.println("1-Accept pending drivers");
        System.out.println("2- Delete driver");
        System.out.println("3- Delete client");
        System.out.println("4- Add Specific Area");
        System.out.println("Enter 0 to return");
    }
    public void registerUser()
    {
        user user=new user();
        System.out.println("enter your name");
        String name=input.next();
        user.setName(name);
        System.out.println("enter your email");
        String email=input.next();
        user.setEmail(email);
        System.out.println("enter your phone");
        int phone=input.nextInt();
        user.setPhone(phone);
        System.out.println("enter your password");
        String pass=input.next();
        user.setPassword(pass);
        database.addUsers(new user(name,email,phone,pass));
    }
    public void registerDriver(){
        System.out.println("enter your name");
        String name=input.next();
        driver.setName(name);
        System.out.println("enter your email");
        String email=input.next();
        driver.setEmail(email);
        System.out.println("enter your phone");
        int phone=input.nextInt();
        driver.setPhone(phone);
        System.out.println("enter your password");
        String pass=input.next();
        driver.setPassword(pass);
        System.out.println("enter your Licence");
        String Licence=input.next();
        driver.setLicence(Licence);
        System.out.println("enter your NationalID");
        int NationalID=input.nextInt();
        driver.setNationalID(NationalID);
        admin.addToAppendingDrivers(new driver(name,email,phone,pass,Licence,NationalID));
    }
    public void loginDriver(){
        database database=new database();
        System.out.println("enter your name");
        String username=input.next();
        System.out.println("enter your password");
        String userpass=input.next();
        database.checkDriver(username,userpass);
        label:
        while (true){
            driverMenu();
            String Input = input.next();
            switch (Input) {
                case "1":
                    this.driver.setOffer();
                    event.priceAskEvent();
                    break;
                case "2":
                    this.driver.displayRatings();
                    break;
                case "3":
                    this.driver.displayFavAreas();
                    break;
                case "4":
                    this.driver.setFavAreas();
                    break;
                case "5":
                    this.driver = null;
                    break label;
                default:
                    System.out.println("Wrong Input");
                    break;
            }
        }

    }public void loginUSer(){
        user user=new user();
        database database=new database();
        System.out.println("enter your name");
        String username=input.next();
        System.out.println("enter your password");
        String userPass=input.next();
        database.checkUser(username,userPass);
        while(true) {
            userMenu();
            String Input2 = input.next();
            if(Input2.equals("1")) {
                String source, dest;int numOfPassengers;
                System.out.println("Enter your Source Area & Destination Area ");
                source = input.next();
                dest = input.next();
                System.out.println("enter the number of passengers");
                numOfPassengers=input.nextInt();
                Ride curr = new Ride(source,dest,numOfPassengers);
                //discount.passengersDiscount(numOfPassengers);
                this.user.addRideToPending(curr);
                myController.notifyDrivers(curr);
                System.out.println("Search for available Drivers");
            }
            else if(Input2.equals("2")) {
                user.displayCompleted();
                System.out.println("please Choose a trip to rate its driver: ");
                Input2 = input.next();
                int index = Integer.parseInt(Input2);
                if(index >= 1 && index <= user.getSizeOfCompleted()) {
                    Ride iRide = user.getCompleteRide(index-1);
                    driver iDriver = iRide.getDriver();
                    user.rateDriver(iDriver);
                }else {
                    System.out.println("Wrong Input");
                }

            }
            else if(Input2.equals("3")) {
                user.displayPending();
                System.out.println("Choose your trip");
                Input2 = input.next();
                int index = Integer.parseInt(Input2);
                if( index >= 1 && index <= user.getSizeOfPending()) {
                    Ride currentRide =user.getPendingRide(index-1);
                    currentRide.displayAvailable();
                    System.out.println("Choose your Offer");
                    double cost = input.nextDouble();
                    driver driver = currentRide.getOffer(cost);
                    if(driver != null) {
                        currentRide.completeTheRide(driver, cost);
                        user.addRideToComplete(currentRide);
                    }
                    else {
                        System.out.println("Wrong Input of cost.");
                    }
                }else {
                    System.out.println("Wrong input of rides number.");
                }
            }
            else if(Input2.equals("4")) {
                this.user = null;
                break;
            }
            else {
                System.out.println("Wrong Input");
            }
        }
    }
    public void adminControl(){
        label:
        while(true) {
            adminMainMenu();
            String userInput = input.next();
            switch (userInput) {
                case "1":
                    admin.verifyDrivers();
                    break;
                case "2":
                    System.out.println("Enter the driver Name: ");
                    userInput = input.next();
                    admin.suspend_user(userInput);
                    break;
                case "3":
                    System.out.println("Enter the user Name: ");
                    userInput = input.next();
                    admin.suspend_driver(userInput);
                    break;
                case "4" :
                    System.out.println("please enter the area");
                    userInput=input.nextLine();
                    admin.addSpecificAreas(userInput);
                    break;
                case "0":
                    admin = null;
                    break label;
            }
        }
    }

}
