package main.com.mentat.onlineshop.dao;

import main.com.mentat.onlineshop.domain.Goods;

import java.util.ArrayList;

/**
 * Created by Misha on 09.08.2015.
 */
public interface GoodsDAO {
    public void createGood(String name, int price) throws DAOException;
    public Goods getGoodByName(String name) throws DAOException;
    public Goods getGoodById(int id) throws DAOException;
    public void updateName(String oldName, String newName) throws DAOException;
    public void updatePrice(String name, int newPrice) throws DAOException;
    public void deleteGoods(String name) throws DAOException;
    public ArrayList<Goods> getAll() throws DAOException;
}
