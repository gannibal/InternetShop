package main.com.mentat.onlineshop.dao;

import main.com.mentat.onlineshop.domain.Groups;

import java.util.ArrayList;

/**
 * Created by Misha on 09.08.2015.
 */
public interface GroupsDAO {
    public int createGroup(String name, int parentId)throws DAOException ;
    public Groups getGroupByName(String name) throws DAOException ;
    public void updateGroupName(String oldName, String newName) throws DAOException ;
    public void updateGroupParent(String groupName, String parentName) throws DAOException ;
    public void delete(String name) throws DAOException ;
    public void deleteAll() throws DAOException ;
    public ArrayList<Groups> getAll() throws DAOException ;
}
