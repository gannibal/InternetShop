package main.com.mentat.onlineshop;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Misha on 24.07.2015.
 */
public class ShoppingCart {
    private ArrayList<GoodsInShop> orders = new ArrayList<GoodsInShop>();
    private Waybill waybill = new Waybill();
    private int id;
    private Shop shop = new Shop();

    public ArrayList<GoodsInShop> getOrders() {
        return orders;
    }

    public void setOrders(GoodsInShop orders) {
        this.orders.add(orders);
    }

    public Waybill getWaybills() {
        return waybill;
    }

    public void setWaybills(Waybill waybills) {
        this.waybill = waybills;
    }

    public void cancelPurchase(Goods good) {
        Iterator iterator = this.orders.iterator();
        while (iterator.hasNext()) {
            GoodsInShop current = (GoodsInShop) iterator.next();
            if (current.getGood().getName().equals(good.getName()))
                iterator.remove();
        }
    }

    public void cancelAllPurchase() {
        this.orders.clear();
    }

    public void confirmPurchaseAndRefreshBalance() {
        waybill.setOrders(orders);
        for (GoodsInShop order : orders) {
            shop.getGoodsByName(order.getGood()).refreshBalance(order.getAmount());

        }
        this.cancelAllPurchase();


    }
}
