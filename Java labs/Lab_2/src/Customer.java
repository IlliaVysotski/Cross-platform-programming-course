import java.util.ArrayList;
import java.util.List;

public class Customer {
    public int money;
    private ShoppingCart cart;
    private Shop shop;


    /**
     * Constructor
     * @param money
     */
    public Customer(int money){
        this.cart = new ShoppingCart();
        this.shop = new Shop("Wallmart",100);
        this.money = money;
    }

    /**
     * Define type of goods and put 'em in cart
     * @param name
     * @param goods
     */
    public void putGoodsInCart(String name, Goods goods) {
        if(goods instanceof Bread) {
            Bread bread = (Bread)goods;
            cart.addGoodsToCart(bread);
        }
        if(goods instanceof Matches) {
            Matches matches = (Matches) goods;
            cart.addGoodsToCart(matches);
        }
    }

    /**
     * Getting list of goods
     * @return
     */
    public List<String> getGoods(){
        List<Goods> gList = cart.getGoods();
        List<String> goodsList = new ArrayList<String>();
        for(Goods goods : gList){
            goodsList.add(goods.getName());
        }
        return goodsList;
    }

    /**
     * Remembers goods reference
     * @param goods
     * @return
     */
    public Goods takeGoods(Goods goods) {
        return goods;
    }

    /**
     * Interacts with shop
     * @param goodsName
     * @param customer
     * @return
     */
    public boolean buyGoods(String goodsName, Customer customer) {
        Shop shop = new Shop("5$",5);
        if (shop.askForMoney(shop, customer)) {
            cart.deleteGoods(goodsName);
            return true;
        }
        return false;
    }

    /**
     * Calculates current balance
     * @param shop
     * @return
     */
    public boolean payForGoods(Shop shop) {
        int number;
        int num;
        //List<Goods> gList = cart.getGoods();
        //number = gList.size();
        num = shop.getPrice();
        money = money - num;
        if (money > 0)
        return true;
        return false;
    }


    public void deleteGoods(String goodsName) {//throws Exception {
        if(!cart.deleteGoods(goodsName));
    }
}


