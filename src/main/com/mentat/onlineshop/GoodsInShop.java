package main.com.mentat.onlineshop;

/**
 * Created by Misha on 25.07.2015.
 */
public class GoodsInShop {
    private Goods good;
    private int amount;
    private Groups group;

    public GoodsInShop(Goods good, int amount) {
        if (good == null || amount <= 0)
            throw new IllegalArgumentException();
        this.good = good;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return good.toString() +
                ", amount=" + amount +
                '}';
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public Goods getGood() {
        return good;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Groups getGroup() {
        return this.group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public void refreshBalance(int amount) {
        this.amount -= amount;

    }


}


