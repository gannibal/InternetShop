package test.com.mentat.onlineshop;

import main.com.mentat.onlineshop.domain.Goods;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Misha on 30.07.2015.
 */
public class GoodsTest {
    @Test
    public final void testGenerateId() {
        Assert.assertEquals(1, new Goods("good", 1245).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testNullName() {
        new Goods(null, 124);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        new Goods("", 4);
    }


}
