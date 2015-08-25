package main.com.mentat.onlineshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Misha on 11.08.2015.
 */
public class DAOFactory {

        public static final String DRIVER="org.postgresql.Driver";
        public static final String URL="jdbc:postgresql://localhost:5437/shop";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(URL, "postgres", "misha");

        return connection;
    }

    public GoodsDAO getGoodsDAO() {
        return new GoodsDAO();
    }
    public GoodsInShopDAO getGoodsInShopDAO(){
        return  new GoodsInShopDAO();
    }
    public GroupsDAO getGroupsDAO(){
        return new GroupsDAO();
    }
}
