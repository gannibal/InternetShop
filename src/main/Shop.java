package main;

import java.util.ArrayList;

/**
 * Created by Misha on 24.07.2015.
 */
public class Shop {
    public static Groups groups = new Groups("mainGroup", null);
    public static ShoppingCart cart = new ShoppingCart();

    public static GoodsInShop findGood(Groups group, Goods goods) {
        GoodsInShop forCart = null;
        for (int i = 0; i < group.getGoods().size(); i++) {
            if (group.getGoods().get(i).getGood().getName().equals(goods.getName()))
                forCart = group.getGoods().get(i);

        }
        return forCart;
    }

    public GoodsInShop getGoodsByName(Goods goods) {
        GoodsInShop good = null;
        for (Groups current : groups.getChildren()) {
            if (current.getGoods() != null)
                good = findGood(current, goods);

            if (current.getChildren() != null && good == null) {
                if (current.getGoods() != null) {
                    good = findGood(current, goods);
                    if (good != null)
                        break;
                }
                for (int i = 0; i < current.getChildren().size(); i++) {
                    current = current.getChildren().get(i);
                    good = findGood(current, goods);
                    if (good != null)
                        break;
                }
            }
        }

        return good;
    }

    public ArrayList<GoodsInShop> getGoodsByGroup(Groups group) {
        ArrayList<GoodsInShop> goodsInShops = new ArrayList<GoodsInShop>();

        for (Groups current : group.getChildren()) {
            if (current.getGoods() != null)
                for (int i = 0; i < current.getGoods().size(); i++) {
                    goodsInShops.add(current.getGoods().get(i));
                }

            if (current.getChildren() != null) {
                for (int i = 0; i < current.getChildren().size(); i++) {
                    Groups temp = current.getChildren().get(i);
                    for (int j = 0; j < temp.getGoods().size(); j++) {
                        goodsInShops.add(temp.getGoods().get(j));
                    }

                }
            }
        }
        return goodsInShops;
    }

    public void buyGoods(Goods goods, int amount) {
        ArrayList<Groups> group = new ArrayList<Groups>();
        group.add(groups);
        GoodsInShop good = new GoodsInShop(this.getGoodsByName(goods).getGood(), amount);
        cart.setOrders(good);
    }

}
