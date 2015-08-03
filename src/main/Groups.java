package main;

import java.util.ArrayList;

/**
 * Created by Misha on 23.07.2015.
 */
public class Groups {
    private String name;
    private ArrayList<Groups> children;
    private Groups parent;
    private ArrayList<GoodsInShop> goods;

    public Groups(String name, Groups parent, ArrayList<Groups> children, ArrayList<GoodsInShop> goods) {
        if (name == null || name == "" || parent == null || children == null || goods == null)
            throw new IllegalArgumentException();

        this.name = name;
        this.children = children;
        this.parent = parent;
        this.goods = goods;
        if (goods != null) {
            for (GoodsInShop good : goods) {
                good.setGroup(this);
            }
        }

    }

    public Groups(String name, ArrayList<Groups> children, ArrayList<GoodsInShop> goods) {
        this.name = name;
        this.children = children;
        this.goods = goods;
        if (goods != null) {
            for (GoodsInShop good : goods) {
                good.setGroup(this);
            }
        }
    }


    public Groups(String name, Groups parent, ArrayList<GoodsInShop> goods) {
        this.name = name;
        this.parent = parent;
        this.goods = goods;
        if (goods != null) {
            for (GoodsInShop good : goods) {
                good.setGroup(this);
            }
        }
    }

    public Groups(String name, ArrayList<GoodsInShop> goods) {
        this.name = name;
        this.goods = goods;
        if (goods != null) {
            for (GoodsInShop good : goods) {
                good.setGroup(this);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<GoodsInShop> getGoods() {
        return this.goods;
    }

    public void setGoods(ArrayList<GoodsInShop> goods) {

        this.goods = goods;
        for (GoodsInShop good : goods) {
            good.setGroup(this);
        }
    }

    public ArrayList<Groups> getChildren() {
        return this.children;
    }

    public void setChildren(ArrayList<Groups> children) {
        this.children = children;
    }
}

