package com.company;

public class AdminAreaDiscount implements IDiscount{
    private String destination;
    private driver driver;
    database d =database.getData();
    final double dis1 =0.1;
    private double price;

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public double Discount(double cost) {
        for (int i = 0; i< d.getSpecificAreas().size(); i++){
            if (getDestination().equals(d.getSpecificAreas().get(i))){
                setPrice( driver.getPrice() * dis1);
            }else
                setPrice(driver.getPrice() * dis1);
        }
        return getPrice();
    }
}
