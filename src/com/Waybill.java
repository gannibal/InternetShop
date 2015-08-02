package com;

import java.util.ArrayList;

/**
 * Created by Misha on 24.07.2015.
 */
public class Waybill {
    private ArrayList<GoodsInShop> orders;

    public ArrayList<GoodsInShop> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<GoodsInShop> orders) {
        this.orders = orders;
    }

    public int getPurchasePrice(ArrayList<GoodsInShop> orders) {

        int price = 0;
        for (GoodsInShop order : orders) {
            price += order.getGood().getPrice() * order.getAmount();
        }
        return price;
    }

}
