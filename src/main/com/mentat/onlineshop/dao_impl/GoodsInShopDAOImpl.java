package main.com.mentat.onlineshop.dao_impl;

import main.com.mentat.onlineshop.dao.DAOException;
import main.com.mentat.onlineshop.dao.DAOFactory;
import main.com.mentat.onlineshop.dao.GoodsInShopDAO;
import main.com.mentat.onlineshop.domain.Goods;
import main.com.mentat.onlineshop.domain.GoodsInShop;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Misha on 19.08.2015.
 */
public class GoodsInShopDAOImpl implements GoodsInShopDAO {
    private static final Logger logger = Logger.getLogger(GoodsInShopDAOImpl.class);

    @Override
    public int insertGoodsInShop(Goods good, int amount, String groupName) throws DAOException {

        String query="insert into goods_in_shop (good_id, amount, group_id ) values(?, ?, ?)";

        DAOFactory daoFactory=new DAOFactory();
        PreparedStatement statement=null;
        Connection connection = null;

        try{
        connection=daoFactory.getConnection();
            logger.info("connection established");
        statement=connection.prepareStatement(query);
        Goods temp=new Goods();

        GoodsDAOImpl goods=new GoodsDAOImpl();
        temp.setId(goods.getGoodByName(good.getName()).getId());
        statement.setInt(1, temp.getId());
        statement.setInt(2,amount);

        int groupId=0;

        if(groupName != null) {
            GroupsDAOImpl tempGroup=new GroupsDAOImpl();
            groupId= tempGroup.getGroupByName(groupName).getId();
            statement.setInt(3,groupId);
        }
       else{
            statement.setNull(3, Types.NULL);
        }
            logger.info("object initialized");
        statement.executeQuery();
            logger.info("query executed");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                statement.close();
                connection.close();
                logger.info("connection closed");

            } catch (SQLException e) {
                logger.error("can`t execute query", e);
            }
        }
        return 0;
    }

    @Override
    public GoodsInShop getGoodsInShopByGoodName(String goodName) throws DAOException {

        GoodsInShop good=new GoodsInShop();
        DAOFactory daoFactory=new DAOFactory();
        String query="select amount, good_id, group_id from goods_in_shop" +
                " inner join goods on goods_in_shop.good_id=goods.id  " +
                "where goods.name=?";

        PreparedStatement statement=null;
        Connection connection = null;
        ResultSet resultSet=null;

        try{
        connection=daoFactory.getConnection();
            logger.info("connection established");
        statement=connection.prepareStatement(query);
        statement.setString(1, goodName);
         resultSet=statement.executeQuery();
        logger.info("query executed");
        while(resultSet.next()) {
            good.setAmount(resultSet.getInt(1));
            good.setGoodId(resultSet.getInt(2));
            good.setGroupId(resultSet.getInt(3));
            logger.info("object initialized");
        }
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                statement.close();
                connection.close();
                logger.info("connection closed");

            } catch (SQLException e) {
                logger.error("can`t execute query", e);
            }
        }
        return good;
    }

    @Override
    public void updateGoodsInShopAmount(String goodName, int newAmount)throws DAOException {
        DAOFactory daoFactory=new DAOFactory();
        PreparedStatement statement=null;
        Connection connection = null;
        String query = "update goods_in_shop " +
                "set amount=? " +
                "where good_id in(select id from goods " +
                " where name=?)";

        try{
        connection=daoFactory.getConnection();
        logger.info("connection established");
        if(newAmount>0){

            statement=connection.prepareStatement(query);
            statement.setInt(1, newAmount);
            statement.setString(2, goodName);
            statement.executeUpdate();
            logger.info("query executed");
        }
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                statement.close();
                connection.close();
                logger.info("connection closed");

            } catch (SQLException e) {
              logger.error("can`t execute query", e);
            }
        }
    }

    @Override
    public ArrayList<GoodsInShop> getAll() throws DAOException {

        DAOFactory daoFactory=new DAOFactory();
        ArrayList<GoodsInShop> listOfGoods = new ArrayList<GoodsInShop>();
        PreparedStatement statement=null;
        Connection connection = null;
        ResultSet resultSet=null;
        try{
        connection=daoFactory.getConnection();
            logger.info("conneciton established");
        String query="select * from goods_in_shop";
        statement=connection.prepareStatement(query);
        resultSet=statement.executeQuery();
            logger.info("query executed");

        GoodsInShop tempGood=new GoodsInShop();
        while(resultSet.next()) {
            tempGood.setAmount(resultSet.getInt(2));
            tempGood.setGoodId(resultSet.getInt(3));
            tempGood.setGroupId(resultSet.getInt(4));
            logger.info("object initialized");
            listOfGoods.add(tempGood);

        }
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                statement.close();
                connection.close();
                logger.info("connection closed");

            } catch (SQLException e) {
                logger.error("can`t execute query", e);
            }
        }

        return listOfGoods;

        }
    }

