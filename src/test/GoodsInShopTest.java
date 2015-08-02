package test;


import com.Goods;
import com.GoodsInShop;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Misha on 31.07.2015.
 */
public class GoodsInShopTest {

    @Test(expected = IllegalArgumentException.class)
    public final void testNullName() {
        new GoodsInShop(null, 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testWrongAmount() {
        new GoodsInShop(null, -12);
    }


    @Test
    public void testGetName() {
        Goods goods = new Goods("someGood", 23);
        GoodsInShop goodsInShop = new GoodsInShop(goods, 5);

        String expected = "someGood";
        Assert.assertEquals(expected, goodsInShop.getGood().getName());

    }
}
