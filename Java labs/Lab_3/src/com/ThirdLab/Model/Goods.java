package com.ThirdLab.Model;

public abstract class Goods {

    protected int amount;
    protected String name;

    /**
     * Constructor
     * @param name
     */
    public Goods(String name) {
        //this.amount = amount;
        this.name = name;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(int amount){
        this.amount = amount;
    }

    /**
     *
     * @return
     */
    public int getAmount(){
        return  amount;
    }

    /**
     *
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName(){
        return  name;
    }
}

