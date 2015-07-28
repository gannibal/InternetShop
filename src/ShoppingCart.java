import java.util.ArrayList;

/**
 * Created by Misha on 24.07.2015.
 */
public class ShoppingCart {
    private ArrayList<GoodsInShop> orders=new ArrayList<GoodsInShop>();
    private ArrayList<Waybill> waybills;
    private int id;

    public void confirmPurchase(){

    }

    public ArrayList<GoodsInShop> getOrders() {
        return orders;
    }

    public void setOrders(GoodsInShop orders) {
        this.orders.add(orders);
    }

    public ArrayList<Waybill> getWaybills() {
        return waybills;
    }

    public void setWaybills(ArrayList<Waybill> waybills) {
        this.waybills = waybills;
    }

    public void cancelPurchase(GoodsInShop good){

    }

    public void cancelAllPurchase(){

    }
}
