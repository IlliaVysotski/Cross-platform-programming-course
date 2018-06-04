package com.ThirdLab.Model;

public class Shop {
    private String name;
    private int price;
    private Customer customer;

    /**
     * Constructor
     * @param Name
     * @param price
     */
    public Shop(String Name, int price) {
       this.name = Name;
        this.price = price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return  price;
    }

    /**
     * Interacts with customer
     * @param shop
     * @param customer
     * @return
     */
    public boolean askForMoney(Shop shop, Customer customer) {
        if(customer.payForGoods(shop))
        return true;
        return false;
    }

}
