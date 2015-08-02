package test;

import com.Goods;
import com.GoodsInShop;
import com.Groups;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Misha on 31.07.2015.
 */
public class GroupsTest {
    Goods goods = new Goods("someGood", 14);
    GoodsInShop goodsInShop = new GoodsInShop(goods, 34);
    ArrayList<GoodsInShop> listOfGoods = new ArrayList<GoodsInShop>();

    @Test
    public void getGoodsTest() {
        listOfGoods.add(goodsInShop);
        Groups groups = new Groups("testGroup", listOfGoods);
        Assert.assertEquals("someGood", groups.getGoods().get(0).getGood().getName());
    }

    @Test
    public void getChildrenTest() {
        Groups group1 = new Groups("firstGroup", null);
        Groups group2 = new Groups("secondGroup", null);
        ArrayList<Groups> children = new ArrayList<Groups>();
        children.add(group1);
        children.add(group2);
        Groups parent = new Groups("parent", children, listOfGoods);
        Assert.assertEquals(children, parent.getChildren());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullParametersTest() {
        Groups groups = new Groups("", null, null, listOfGoods);
    }


}
