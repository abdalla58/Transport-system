package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class controller {
    private ArrayList<String> favAreas = new ArrayList<String>();
    private user user=new user();
    private driver driver=new driver();
    private admin admin=new admin();
    private RideController myController=new RideController();
    Scanner input=new Scanner(System.in);
    public void mainMenu() {
        System.out.println("Welcome, Enter as:");
        System.out.println("1- Client");
        System.out.println("2- Driver");
        System.out.println("3- Admin");
        System.out.println("Enter 0 to Exit");
    }
    public void EnteringMenu() {
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("Enter 0 to return");
    }
    public void clientMainMenu() {
        System.out.println("Welcome Client " + user.getName());
        System.out.println("1- Take a ride");
        System.out.println("2- Display my complete rides");
        System.out.println("3- Display my pending rides");
        System.out.println("4- Sign out");
    }
    public void driverMainMenu() {
        System.out.println("Welcome Driver " + driver.getName());
        System.out.println("1- Show available rides");
        System.out.println("2- Show Client Ratings");
        System.out.println("3- Show Favorite Areas");
        System.out.println("4- Add favortite Area");
        System.out.println("5- Sign out");
    }
    public void adminMainMenu() {
        System.out.println("Welcome Admin ");
        System.out.println("1-Accept pending drivers");
        System.out.println("2- Delete driver");
        System.out.println("3- Delete client");
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
        database database=new database();
        database.addUsers(user);
    }
    public void registerDriver(){
        driver driver=new driver();
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
        admin admin=new admin();
        admin.addToAppendingDrivers(driver);
    }
    public void loginDriver(){
        database database=new database();
        System.out.println("enter your name");
        String username=input.next();
        System.out.println("enter your password");
        String userpass=input.next();
        database.checkDriver(username,userpass);
        while (true){
            driverMainMenu();
            String Input = input.next();
            if(Input.equals("1")) {
                this.driver.setOffer();
            }
            else if(Input.equals("2")) {
                this.driver.displayRatings();
            }
            else if(Input.equals("3")) {
                this.driver.displayFavAreas();
            }
            else if(Input.equals("4")) {
                this.driver.setFavAreas();
            }
            else if(Input.equals("5")) {
                this.driver = null;
                break;
            }
            else {
                System.out.println("Wrong Input");
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
            clientMainMenu();
            String Input2 = input.next();
            if(Input2.equals("1")) {
                String source, dest;
                System.out.println("Enter your source and destination space separated");
                source = input.next();
                dest = input.next();
                Ride curr = new Ride(source,dest);
                this.user.addRideToPending(curr);
                myController.notifyDrivers(curr);
                System.out.println("Searching for available Drivers...");
            }
            else if(Input2.equals("2")) {
                user.displayCompleted();
                System.out.println("Choose a ride to rate its driver: ");
                Input2 = input.next();
                int index = Integer.parseInt(Input2);
                if(index >= 1 && index <= user.getSizeOfCompleted()) {
                    Ride iRide = user.getCompleteRide(index-1);
                    driver iDriver = iRide.getDriver();
                    user.rateDriver(iDriver);
                }else {
                    System.out.println("Wrong input");
                }

            }
            else if(Input2.equals("3")) {
                user.displayPending();
                System.out.println("Choose your Ride");
                Input2 = input.next();
                int index = Integer.parseInt(Input2);
                if( index >= 1 && index <= user.getSizeOfPending()) {
                    Ride curr =user.getPendingRide(index-1);
                    curr.displayAvailable();
                    System.out.println("Choose your Offer");
                    double cost = input.nextDouble();
                    driver currDriver = curr.getOffer(cost);
                    if(currDriver != null) {
                        curr.completeTheRide(currDriver, cost);
                        user.addRideToComplete(curr);
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
        while(true) {
            adminMainMenu();
            String userInput = input.next();
            if(userInput.equals("1")) {
                admin.verifyDrivers();
            }
            else if(userInput.equals("2")) {
                System.out.println("Enter the driver Name: ");
                userInput = input.next();
                admin.suspend_user(userInput);
            }
            else if(userInput.equals("3")) {
                System.out.println("Enter the client Name: ");
                userInput = input.next();
                admin.suspend_driver(userInput);
            }
            else if(userInput.equals("0")) {
                admin=null;
                break;
            }
        }
    }

}
