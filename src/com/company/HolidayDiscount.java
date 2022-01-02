package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HolidayDiscount implements IDiscount{
    private driver driver;
    final double dis2 =0.05;
    private double price;

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public double Discount(double cost) {
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
        return getPrice();
    }
}
