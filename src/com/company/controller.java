package com.company;

import java.util.Scanner;

public class controller {
    private user User;
    private driver Driver;
    private admin Admin;;
    private RideController rideController;
    private static database mydatabase;
    private Scanner input;
    private String string;

    controller(){
        Admin = new admin();
        rideController = new RideController();
        mydatabase = database.getData();
        input = new Scanner(System.in);
    }
    public void mainMenu() {
        System.out.println("Welcome, Enter as:");
        System.out.println("1- user");
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
        System.out.println("Welcome user " + User.getUserName());
        System.out.println("1- Take a ride");
        System.out.println("2- Display my complete rides");
        System.out.println("3- Display my pending rides");
        System.out.println("4- Sign out");
    }
    public void driverMenu() {
        System.out.println("Welcome Driver " + Driver.getUserName());
        System.out.println("1- Show available rides");
        System.out.println("2- Show user Ratings");
        System.out.println("3- Show Favorite Areas");
        System.out.println("4- Add favorite Area");
        System.out.println("5- Sign out");
    }
    public void adminMainMenu() {
        System.out.println("Welcome Admin");
        System.out.println("1- Accept pending drivers");
        System.out.println("2- Delete driver");
        System.out.println("3- Delete user");
        System.out.println("Enter 0 to return");
    }
    public void loginUSer() {
        String userName,password;int numOfPassengers;
        System.out.println("Enter your Name" );
        userName = input.next();
        System.out.println("Enter your password ");
        password = input.next();
        if(mydatabase.checkUser(userName, password) != null) {
            this.User = mydatabase.checkUser(userName, password);
            label:
            while(true) {
                userMenu();
                string = input.next();
                switch (string) {
                    case "1":
                        String source, dest;
                        System.out.println("Enter your source and destination space separated");
                        source = input.next();
                        dest = input.next();
                        System.out.println("enter the number of passengers");
                        numOfPassengers=input.nextInt();
                        Ride ride = new Ride(source, dest);
                        this.User.addRideToPending(ride);
                        rideController.notifyDrivers(ride);
                        System.out.println("Searching for available Drivers...");
                        break;
                    case "2": {
                        User.displayCompleted();
                        System.out.println("Choose a ride to rate its driver: ");
                        string = input.next();
                        int i = Integer.parseInt(string);
                        if (i >= 1 && i <= User.getSizeOfCompleted()) {
                            Ride iride = User.getCompleteRide(i - 1);
                            driver iDriver = iride.getDriver();
                            User.rateDriver(iDriver);
                        } else {
                            System.out.println("Wrong input");
                        }

                        break;
                    }
                    case "3": {
                        User.displayPending();
                        System.out.println("Choose your Ride");
                        string = input.next();
                        int i = Integer.parseInt(string);
                        if (i >= 1 && i <= User.getSizeOfPending()) {
                            Ride curr = User.getPendingRide(i - 1);
                            curr.displayAvailable();
                            System.out.println("Choose your Offer");
                            double cost = input.nextDouble();
                            driver currDriver = curr.getOffer(cost);
                            if (currDriver != null) {
                                curr.completeTheRide(currDriver, cost);
                                User.addRideToComplete(curr);
                            } else {
                                System.out.println("Wrong Input of cost.");
                            }
                        } else {
                            System.out.println("Wrong input of rides number.");
                        }
                        break;
                    }
                    case "4":
                        this.User = null;
                        break label;
                    default:
                        System.out.println("Wrong Input");
                        break;
                }
            }
        }
        else
            System.out.println("There's no such a user");
    }
    public void registerUser() {
        String userName; String pass; String mobile; String email;
        System.out.println("Enter your Name");
        userName = input.next();
        System.out.println("enter your password");
        pass = input.next();
        System.out.println("enter your phone");
        mobile = input.next();

        if(mydatabase.userExistence(userName) == null) {
            System.out.println("Want to add email? enter 0 to add");
            string = input.next();
            if(string.equals("0")) {
                System.out.print("Enter your email: ");
                email = input.next();
                mydatabase.addUsers(new user(userName, pass, mobile, email));
            }else
                mydatabase.addUsers(new user(userName, pass, mobile));
            System.out.println("You have created your account successfully;");
        }
        else
            System.out.println("this user already exists");
    }

    public void loginDriver() {
        String userName; String password;
        System.out.println("Enter your Name ");
        userName = input.next();
        System.out.println("enter your password ");
        password = input.next();
        if(mydatabase.checkDriver(userName, password) != null) {
            this.Driver = mydatabase.checkDriver(userName, password);
            label:
            while(true) {
                driverMenu();
                string = input.next();
                switch (string) {
                    case "1":
                        this.Driver.setOffer();
                        break;
                    case "2":
                        this.Driver.displayRatings();
                        break;
                    case "3":
                        this.Driver.displayFavAreas();
                        break;
                    case "4":
                        this.Driver.setFavAreas();
                        break;
                    case "5":
                        this.Driver = null;
                        break label;
                    default:
                        System.out.println("Wrong Input");
                        break;
                }
            }
        }
    }
    public void registerDriver() {
        String userName,  pass,  mobile,  email,  license,  id;
        System.out.println("Enter your Name");
        userName = input.next();
        System.out.println("enter your password");
        pass = input.next();
        System.out.println("enter your phone");
        mobile = input.next();
        System.out.println("enter your Licence");
        license = input.next();
        System.out.println("enter your NationalID");
        id = input.next();
        if(mydatabase.driverExistence(userName) == null) {
            System.out.println("Want to add email? enter 0 to add");
            string = input.next();
            if(string.equals("0")) {
                System.out.print("Enter your email: ");
                email = input.next();
                Admin.addToPendingDrivers(new driver(userName, pass, mobile, email, license, id));
            }else
                Admin.addToPendingDrivers(new driver(userName, pass, mobile, license, id));
            System.out.println("You have created your account successfully;");
        }
        else
            System.out.println("this driver already exists");
    }

    public void adminControl() {
        label:
        while(true) {
            adminMainMenu();
            this.string = input.next();
            switch (string) {
                case "1":
                    Admin.verifyDrivers();
                    break;
                case "2":
                    System.out.println("Enter the driver userName: ");
                    string = input.next();
                    Admin.suspendDriver(string);
                    break;
                case "3":
                    System.out.println("Enter the client userName: ");
                    string = input.next();
                    Admin.suspendClient(string);
                    break;
                case "4" :
                    System.out.println("please enter the area: ");
                    string=input.next();
                    Admin.addSpecificAreas(string);
                case "0":
                    Admin = null;
                    break label;
            }
        }
    }

}
