package test.com.mentat.onlineshop.dao_test;

import main.com.mentat.onlineshop.dao_impl.GoodsDAOImpl;
import main.com.mentat.onlineshop.domain.Goods;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Misha on 23.08.2015.
 */
public class GoodsDAOTest {
    GoodsDAOImpl goodsDAO=new GoodsDAOImpl();
    @Test
    public void insertGoodTest(){
        goodsDAO.createGood("testGood", 100);
        String actual=goodsDAO.getGoodByName("testGood").getName();
        String expected="testGood";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getByNameTest(){
        Goods expected=new Goods("testGood",100);
        Goods actual=goodsDAO.getGoodByName("testGood");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void updatePriceTest() throws SQLException, ClassNotFoundException {
        goodsDAO.updatePrice("testGood", 200);
        int expected=200;
        int actual=goodsDAO.getGoodByName("testGood").getPrice();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteTest() throws SQLException, ClassNotFoundException {
        goodsDAO.deleteGoods("testGood");
        Assert.assertNull(goodsDAO.getGoodByName("testGood"));

    }
    /*@After public void deleteAfterTest() throws SQLException, ClassNotFoundException {
        goodsDAO.deleteGoods("testGood");
    }*/

}
