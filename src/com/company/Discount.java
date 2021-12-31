package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Discount {
    private driver driver;
    database d =database.getData();
    final double dis1 =0.1;
    final double dis2 =0.05;
    private double price;

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public void firstTripDiscount(){
        if (driver.completeRides.isEmpty()){
            setPrice( driver.getPrice() * dis1);
        }else
            setPrice(driver.getPrice());
    }
    public void adminAreaDiscount(String destination){
     for (int i = 0; i< d.getSpecificAreas().size(); i++){
         if (destination.equals(d.getSpecificAreas().get(i))){
             setPrice( driver.getPrice() * dis1);
         }else
             setPrice(driver.getPrice() * dis1);
     }

    }
    public void passengersDiscount(int numOfPassengers){
        if (numOfPassengers==2){
            setPrice(driver.getPrice()*dis2);
        }else
            setPrice(driver.getPrice());
    }
    public void holidayDiscount(){
        Date date=new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        String dayWeekText = new SimpleDateFormat("EEEE").format(date);
        if (dayWeekText.equals("Friday")){
            setPrice(driver.getPrice()*dis2);
        }else{
            setPrice(driver.getPrice());
        }
    }
}
