package main.com.mentat.onlineshop.dao_impl;

import main.com.mentat.onlineshop.dao.DAOException;
import main.com.mentat.onlineshop.dao.DAOFactory;
import main.com.mentat.onlineshop.dao.GroupsDAO;
import main.com.mentat.onlineshop.domain.Groups;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Misha on 19.08.2015.
 */
public class GroupsDAOImpl implements GroupsDAO {
    private static Logger logger=Logger.getLogger(GroupsDAOImpl.class);
    @Override
    public int createGroup(String name, int parentId) throws DAOException {

        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        String query = "insert into groups (name, parent_id) values(?, ?)";

        try {
            connection = daoFactory.getConnection();
            logger.info("connection established");
            statement = connection.prepareStatement(query);

            statement.setString(1, name);
            if(parentId!=0) {
                statement.setInt(2, parentId);
            }
            else {
                statement.setNull(2, Types.NULL);
            }
            statement.executeQuery();
            logger.info("group created");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                statement.close();
                connection.close();
                logger.info("connections closed");
            } catch (SQLException e) {
                logger.error("can`t execute query", e);
            }
        }
        return 0;
    }

    @Override
    public Groups getGroupByName(String name) throws DAOException {
        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Groups group = new Groups();
        try {
            connection = daoFactory.getConnection();
            logger.info("connection is established");
            String query = "select * from groups where name = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            logger.info("group is found");

            while (resultSet.next()) {
                group.setId(resultSet.getInt(1));
                group.setName(resultSet.getString(2));
                group.setId(resultSet.getInt(3));
                logger.info("object is initialized");
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
                logger.info("connections are closed");
            } catch (SQLException e) {
                logger.error("can`t execute query", e);
            }
        }
        return group;
    }

    @Override
    public void updateGroupName(String oldName, String newName) throws DAOException{
        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        String query = "update groups " +
                "set name=? " +
                "where name=?";

        try {
            connection = daoFactory.getConnection();
            logger.info("connection is established");
            statement = connection.prepareStatement(query);
            statement.setString(1, newName);
            statement.setString(2, oldName);

            statement.executeUpdate();
            logger.info("name is updated");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                logger.error("can`t execute query", e);
            }
        }
    }

    @Override
    public void updateGroupParent(String groupName, String parentName) throws DAOException {
        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String findParentId = "select id from groups where name=?";
        String query = "update groups " +
                "set parent_id=? " +
                "where name=?";

        try {
            connection = daoFactory.getConnection();
            logger.info("connection is established");
            statement = connection.prepareStatement(findParentId);
            statement.setString(1, parentName);

            resultSet = statement.executeQuery();
            logger.info("parent id is found");
            int parentId = 0;
            while (resultSet.next()) {
                parentId = resultSet.getInt(1);
            }

            statement = connection.prepareStatement(query);
            statement.setInt(1, parentId);
            statement.setString(2, groupName);
            statement.executeUpdate();
            logger.info("parent id is updated");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                statement.close();
                connection.close();
                logger.info("connections are closed");

            } catch (SQLException e) {
                logger.error("can`t execute query", e);
            }
        }
    }


    @Override
    public void delete(String name) throws DAOException{

        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;

        String setNullParent = "update groups set parent_id=null in(" +
                "select id from groups where name=?";

        String setNullInGoods = "update goods_in_shop set group_id=null " +
                "where group_id in(" +
                "select id from groups where name=?";

        String deleteQuery = "delete from groups where name=?";

        try {
            connection = daoFactory.getConnection();
            logger.info("connection is established");
            statement = connection.prepareStatement(setNullParent);
            statement.setString(1, name);
            statement.executeQuery();
            statement = connection.prepareStatement(setNullInGoods);
            statement.setString(1, name);
            statement = connection.prepareStatement(deleteQuery);
            statement.setString(1, name);
            statement.executeQuery();
            logger.info("group is deleted");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            try {
                statement.close();
                connection.close();
                logger.info("connections are closed");
            } catch (SQLException e) {
                logger.error("can`t execute query", e);
            }
        }
    }

    @Override
    public void deleteAll() throws DAOException{
        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        String query="delete from groups";
        try{
            connection=daoFactory.getConnection();
            logger.info("connection is established");
            statement = connection.prepareStatement(query);
            statement.executeQuery();
            logger.info("all groups are deleted");
        } catch (ClassNotFoundException|SQLException e) {
            logger.error("can`t find class or execute query", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error("can`t execute query", e);
                }
            }
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("can`t  execute query", e);
        }

        }

    }

    @Override
    public ArrayList<Groups> getAll() throws DAOException{
        DAOFactory daoFactory = new DAOFactory();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Groups> listOfGroups = new ArrayList<Groups>();
        String query = "select * from groups";

        try {
            connection = daoFactory.getConnection();
            logger.info("connection is established");
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            logger.info("groups are received");
            Groups tempGroup = new Groups();
            while (resultSet.next()) {
                tempGroup.setId(resultSet.getInt(1));
                tempGroup.setName(resultSet.getString(2));
                tempGroup.setParentId(resultSet.getInt(3));
                listOfGroups.add(tempGroup);
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
                logger.info("connections are closed");
            } catch (SQLException e) {
                logger.error("can`t execute query", e);
            }
        }

        return listOfGroups;
    }
}
