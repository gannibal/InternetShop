package main.com.mentat.onlineshop.dao;

import main.com.mentat.onlineshop.domain.Goods;
import main.com.mentat.onlineshop.domain.GoodsInShop;

import java.util.ArrayList;

/**
 * Created by Misha on 09.08.2015.
 */
public interface GoodsInShopDAO {
    public int insertGoodsInShop(Goods good, int amount, String groupName) throws DAOException;
    public GoodsInShop getGoodsInShopByGoodName(String goodName) throws DAOException;
    public void updateGoodsInShopAmount(String goodName, int newAmount) throws DAOException;
    public ArrayList<GoodsInShop> getAll() throws DAOException;
}
