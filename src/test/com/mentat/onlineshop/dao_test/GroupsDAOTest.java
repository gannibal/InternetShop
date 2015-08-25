package test.com.mentat.onlineshop.dao_test;

import junit.framework.Assert;
import main.com.mentat.onlineshop.dao_impl.GroupsDAOImpl;
import main.com.mentat.onlineshop.domain.Groups;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Misha on 24.08.2015.
 */
public class GroupsDAOTest {

    GroupsDAOImpl group=new GroupsDAOImpl();

    /*@Test
    public void createGroupTest() throws SQLException, ClassNotFoundException {
        group.createGroup("testGroup",0);
        String expected="testGroup";
        String actual=group.getGroupByName("testGroup").getName();
        Assert.assertEquals(expected, actual);
    }*/

   /* @Test
    public void updateGroupNameTest() throws SQLException, ClassNotFoundException {
        group.updateGroupName("testGroup", "newGroupName");
        String expected="newGroupName";
        String actual=group.getGroupByName("newGroupName").getName();
        Assert.assertEquals(expected, actual);
        org.junit.Assert.assertNotEquals("testGroup", actual);
    }*/

   /* @Test
    public void updateGroupParentTest() throws SQLException, ClassNotFoundException {
        group.updateGroupParent("newGroupName",null);
        Object oldParentId=group.getGroupByName("newGroupName").getParentId();
        group.updateGroupParent("newGroupName","mainGroup");
        Object newParentId=group.getGroupByName("newGroupName").getParentId();

        Assert.assertNotSame(oldParentId, newParentId);
    }*/

    @Before
            public void set() {
        group.createGroup("mainGroup", 0);
    }
        @Test
    public void getAllTest(){
        int parentGroupId=group.getGroupByName("mainGroup").getId();
        group.createGroup("childGroup",20);
        group.createGroup("anotherOneGroup", 20);
        ArrayList<Groups> list=group.getAll();
        Assert.assertEquals(3, list.size());
    }

    /*@Test
    public void deleteAllTest() throws SQLException, ClassNotFoundException {
        group.deleteAll();
        ArrayList<Groups> groups = group.getAll();
        Assert.assertEquals(0, groups.size());

    }

    @Test
    public void deleteTest(){
        int [] childrens=new int[]

    }*/
}
