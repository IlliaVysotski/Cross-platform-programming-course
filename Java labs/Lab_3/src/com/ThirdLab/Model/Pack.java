package com.ThirdLab.Model;

import java.util.ArrayList;
import java.util.List;

public class Pack {
    int amount;

    public Pack() {
        this.amount = 0;
    }

    public int getGoodsAmount() {
        return amount;
    }

    public void putGoodsInPack() {
        this.amount = this.amount + 1;
    }
}
