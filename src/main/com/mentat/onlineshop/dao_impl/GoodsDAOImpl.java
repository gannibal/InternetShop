package main.com.mentat.onlineshop.dao_impl;

import main.com.mentat.onlineshop.dao.DAOException;
import main.com.mentat.onlineshop.dao.DAOFactory;
import main.com.mentat.onlineshop.dao.GoodsDAO;
import main.com.mentat.onlineshop.domain.Goods;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by Misha on 11.08.2015.
 */
public class GoodsDAOImpl implements GoodsDAO {

    private static final Logger logger = Logger.getLogger(GoodsDAOImpl.class);

    @Override
    public void createGood(String name, int price) throws DAOException {

        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        String query = "insert into goods (name, price) values(?, ?)";
        ResultSet rs = null;
        try {
            connection = daoFactory.getConnection();
            logger.info("connection established");
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, price);
            rs = statement.executeQuery();
            logger.info("query executed");

        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                statement.close();
                connection.close();
                logger.info("connections closed");

            } catch (SQLException e) {
               logger.error("can`t close connection", e);
            }
        }
    }

    @Override
    public Goods getGoodByName(String name) throws DAOException {
        Goods good = new Goods();
        String query = "select * from goods where name=?";
        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            logger.info("connection established");
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            logger.info("query executed");

            while (resultSet.next()) {
                good.setId(resultSet.getInt(1));
                good.setName(resultSet.getString(2));
                good.setPrice(resultSet.getInt(3));
                logger.info("good initialized");
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
                logger.info("connections closed");
            } catch (SQLException e) {
                logger.error("can`t close connection", e);
            }
        }

        return good;
    }

    @Override
    public Goods getGoodById(int id)throws DAOException {
        Goods good = new Goods();
        String query = "select * from goods where id=?";
        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            logger.info("connection established");
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                good.setId(resultSet.getInt(1));
                good.setName(resultSet.getString(2));
                good.setPrice(resultSet.getInt(3));
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
                logger.info("connections closed");
            } catch (SQLException e) {
                logger.error("can`t close connection", e);
            }
        }
        return good;
    }

    @Override
    public void updatePrice(String name, int newPrice) throws DAOException {

        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;

        try {
            connection = daoFactory.getConnection();
            logger.info("connection established");
            if (newPrice > 0) {
                String query = "update goods set price=? where name=?";

                statement = connection.prepareStatement(query);
                statement.setInt(1, newPrice);
                statement.setString(2, name);

                statement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                statement.close();
                connection.close();
                logger.info("connections closed");
            } catch (SQLException e) {
                logger.error("can`t close connection", e);
            }
        }
    }

    @Override
    public void updateName(String oldName, String newName) throws DAOException {

        DAOFactory daoFactory = new DAOFactory();
        String query = "update goods set name=? where name=?";
        PreparedStatement statement = null;
        Connection connection = null;

        if (newName != null && !newName.equals("")) {
            try {
                connection = daoFactory.getConnection();
                logger.info("connection established");
                statement = connection.prepareStatement(query);
                statement.setString(1, newName);
                statement.setString(2, oldName);

                statement.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                logger.error("can`t find class or execute query", e);
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    logger.info("connections closed", e);
                }
            }
        }
    }

    @Override
    public void deleteGoods(String name) throws DAOException {
        String query = "delete from goods where name=?";
        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            logger.info("connection established");
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                statement.close();
                connection.close();
                logger.info("connections closed");
            } catch (SQLException e) {
                logger.error("can`t close connection", e);
            }
        }
    }

    @Override
    public ArrayList<Goods> getAll()throws DAOException{
        String query = "select * from goods";
        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Goods> listOfGoods = new ArrayList<Goods>();

        try {
            connection = daoFactory.getConnection();
            logger.info("connection established");
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Goods tempGood = new Goods();
                tempGood.setName(resultSet.getString(2));
                tempGood.setPrice(resultSet.getInt(3));
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
                logger.info("connections closed");
            } catch (SQLException e) {
                logger.error("can`t close connection", e);
            }
        }
        return listOfGoods;
    }
}
