package com.ThirdLab.Model;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int capacity;
    private List<Goods> goodsList;

    public ShoppingCart(int capacity) {
        this.capacity = capacity;
        this.goodsList = new ArrayList<Goods>();
    }

    /**
     * Constructor
     */
    public ShoppingCart() {
        this.goodsList = new ArrayList<Goods>();
    }

    public Goods getOneGoods(String goodsName){
        for(Goods goods : goodsList){
            if(goods.getName().equals(goodsName))
                return goods;
        }
        return null;
    }

    /**
     *
     * @return goodsList
     */
    public List<Goods> getGoods() {
        return goodsList;
    }

    /**
     * Adding goods to cart
     * @param goods
     */
    public void addGoodsToCart(Goods goods){
        goodsList.add(goods);
    }

    /**
     *
     * @param goodsName
     * @return
     */
    public boolean deleteGoods(String goodsName){
        for(Goods goods : goodsList){
            if(goods.getName().equals(goodsName))
                return goodsList.remove(goods);
        }
        return false;
    }

    public void giveGoodsBack() {

    }
}
