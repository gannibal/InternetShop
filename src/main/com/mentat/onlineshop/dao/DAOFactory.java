package main.com.mentat.onlineshop.dao;

import main.com.mentat.onlineshop.dao_impl.GoodsDAOImpl;
import main.com.mentat.onlineshop.dao_impl.GoodsInShopDAOImpl;
import main.com.mentat.onlineshop.dao_impl.GroupsDAOImpl;

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

    public GoodsDAOImpl getGoodsDAO() {
        return new GoodsDAOImpl();
    }
    public GoodsInShopDAOImpl getGoodsInShopDAO(){
        return  new GoodsInShopDAOImpl();
    }
    public GroupsDAOImpl getGroupsDAO(){
        return new GroupsDAOImpl();
    }
}
