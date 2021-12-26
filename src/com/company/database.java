package com.company;

import java.util.*;

public class database {
    private ArrayList<user> users=new ArrayList<user>();
    private ArrayList<driver> drivers=new ArrayList<driver>();
    private Map<String,String> areas=new HashMap<String,String>();

    private Map<driver,Integer> rt=new HashMap<driver,Integer>();
    private int count=1,sum=1;
    public int avg=0;
    public void addUsers(user u) {
        users.add(u);
    }
    public void addDrivers(driver driver){
        drivers.add(driver);
    }
    public driver driverNameExists(String name) {
        for(driver driver: drivers) {
            if(driver.getName().equals(name))
                return driver;
        }
        return null;
    }
    public user clientNameExists(String name) {
        for(user user: users) {
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }
//    public void userareas(String name,String area ){
//        for (int i = 0; i < users.size(); i++) {
//            areasofuser.put(users.get(i).Name,area);
//        }
//    }


    public void removeDriverFromSystem(String name) {
        driver Driver = driverNameExists(name);
        if(Driver != null) {
            drivers.remove(Driver);
        }else {
            System.out.println("There's no such a driver.");
        }
    }
    public void removeUserFromSystem(String name) {
        user user = clientNameExists(name);
        if(user != null) {
            users.remove(user);
        }else {
            System.out.println("There's no such a client.");
        }
    }
    public void displayDrivers(){
        for (int i=0;i<drivers.size();i++) {
            System.out.println("driver name:"+drivers.get(i).getName());
            System.out.println("driver Phone:"+drivers.get(i).getPhone());
            System.out.println("driver Email:"+drivers.get(i).getEmail());
            System.out.println("driver Licence:"+drivers.get(i).getLicence());
            System.out.println("driver NationalID:"+drivers.get(i).getNationalID());
        }
    }public void displayUsers(){
        for (int i=0;i<users.size();i++) {
            System.out.println("user name:"+users.get(i).getName());
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
    public boolean matchArea(String source){
        boolean f=true;
        Set entrySet = areas.entrySet();
        for (String sources : areas.values()){
            if (source.equals(sources)){
                String S= String.valueOf(areas.keySet());
                System.out.println(S);
                f=true;
                break;
            }else{
                f= false;
                 break;
            }
        }
//        for (int i = 0; i < drivers.size(); i++) {
//             if (a.getValue().equalsIgnoreCase(source)){
//                 dr= a.getKey();
//                 System.out.println( "your driver is" + dr);
//                 f= true;
//                 break;
//             }else{
//                 f= false;
//                 break;
//             }
//        }
        return f;
    }
//    public boolean matchAreaofuser(String area){
//        boolean f=true;
//        Set entrySet = areasofuser.entrySet();
//        for (String sources : areasofuser.values()){
//            if (area.equals(sources)){
//                String S= String.valueOf(areasofuser.values());
//                System.out.println( "there is a ride in " +S );
//                f=true;
//                break;
//            }else{
//                f= false;
//                break;
//            }
//        }
//        Map.Entry<String, String> a = (Map.Entry<String, String>) areasofuser;
//        for (int i = 0; i < users.size(); i++) {
//            if (a.getValue().equalsIgnoreCase(area)){
//                System.out.println( "there is a ride in " +a.getValue() );
//                f= true;
//                break;
//            }else{
//                f= false;
//                break;
//            }
//        }
//        return f;
//    }

}


