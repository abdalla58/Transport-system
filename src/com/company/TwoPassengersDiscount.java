package com.company;

public class TwoPassengersDiscount implements IDiscount{
    private driver driver;
    final double dis2 =0.05;
    private double price;
    private int numOfPassengers;

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public double Discount(double cost) {
        if (getNumOfPassengers()==2){
            setPrice(driver.getPrice()*dis2);
        }else
            setPrice(driver.getPrice());
        return getPrice();
    }
}
