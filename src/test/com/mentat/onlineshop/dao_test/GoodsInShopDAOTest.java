package test.com.mentat.onlineshop.dao_test;

import main.com.mentat.onlineshop.dao.GoodsDAO;
import main.com.mentat.onlineshop.dao.GoodsInShopDAO;
import main.com.mentat.onlineshop.domain.Goods;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Misha on 23.08.2015.
 */
public class GoodsInShopDAOTest {
          GoodsInShopDAO goodsDAO=new GoodsInShopDAO();
            GoodsDAO good=new GoodsDAO();
        @Test
        public void insertGoodTest() throws SQLException, ClassNotFoundException {
            Goods testGood=good.getGoodByName("googleglass");
            goodsDAO.insertGoodsInShop(testGood, 500, "mainGroup");
            int expected=good.getGoodByName("googleglass").getId();
            int actual=goodsDAO.getGoodsInShopByGoodName("googleglass").getGoodId();
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void getByGoodNameTest() throws SQLException, ClassNotFoundException {
            Assert.assertNotNull(goodsDAO.getGoodsInShopByGoodName("testGood"));

        }


        @Test
        public void updateAmountTest() throws SQLException, ClassNotFoundException {
            goodsDAO.updateGoodsInShopAmount("googleglass", 152);
            int expected=152;
            int actual=goodsDAO.getGoodsInShopByGoodName("googleglass").getAmount();
            Assert.assertEquals(expected, actual);
        }



    }


