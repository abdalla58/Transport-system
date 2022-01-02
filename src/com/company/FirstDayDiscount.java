package com.company;
//for frist user use the app
public class FirstDayDiscount implements IDiscount{
    private driver driver;
    final double dis1 =0.1;
    private double price;

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public double Discount(double cost) {
        if (this.driver.completeRides.isEmpty()){
            setPrice( this.driver.getPrice() * dis1);
        }else{
            setPrice(this.driver.getPrice());
        }
        return getPrice();
    }
}
