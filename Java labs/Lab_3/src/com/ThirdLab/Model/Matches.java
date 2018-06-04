package com.ThirdLab.Model;

public class Matches extends Goods {

    private int length;
    private boolean isLightning;

    /**
     * Constructor
     * @param name
     */
    public Matches(String name){
        super(name);
        //this.length = 0;
        isLightning = false;
    }

    public Matches lightMatches() {
        this.isLightning = true;
        return this;
    }
}
