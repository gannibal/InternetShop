package test;

import com.Goods;
import com.GoodsInShop;
import com.Groups;
import com.Shop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Misha on 02.08.2015.
 */
public class ShopTest {
    Goods fifth = new Goods("fifthGoodInShop", 100);
    GoodsInShop fifthGoodInShop = new GoodsInShop(fifth, 10);

    Goods fourth = new Goods("fourthGoodInShop", 10);
    GoodsInShop fourthGoodInShop = new GoodsInShop(fourth, 10);
    ArrayList<GoodsInShop> four = new ArrayList<GoodsInShop>();

    Groups fourthGroup = new Groups("fourthGroup", four);
    ArrayList<Groups> thirdGroupChildren = new ArrayList<Groups>();

    Groups thirdGroup = new Groups("thirdGroup", thirdGroupChildren, null);

    Goods third = new Goods("thirdChild", 100);
    GoodsInShop thirdGoodInShop = new GoodsInShop(third, 10);
    Goods second = new Goods("secondChild", 10);
    GoodsInShop secondGoodInShop = new GoodsInShop(second, 10);
    ArrayList<GoodsInShop> secondChildGoods = new ArrayList<GoodsInShop>();

    Groups secondChildGroup = new Groups("secondChildGroup", secondChildGoods);
    ArrayList<Groups> secondChildInList = new ArrayList<Groups>();


    Goods firstGoods = new Goods("firstGoodInShop", 10);
    GoodsInShop firstGoodInShop = new GoodsInShop(firstGoods, 4);

    ArrayList<GoodsInShop> firstGoodInList = new ArrayList<GoodsInShop>();

    Groups fistChild = new Groups("firstChild", secondChildInList, firstGoodInList);

    ArrayList<Groups> firstLevelChildren = new ArrayList<Groups>();
    Shop shop = new Shop();

    @Before
    public void initialization() {
        four.add(fourthGoodInShop);
        four.add(fifthGoodInShop);
        thirdGroupChildren.add(fourthGroup);

        secondChildGoods.add(thirdGoodInShop);
        secondChildGoods.add(secondGoodInShop);

        secondChildInList.add(secondChildGroup);
        firstGoodInList.add(firstGoodInShop);

        firstLevelChildren.add(fistChild);
        firstLevelChildren.add(thirdGroup);
        Shop.groups.setChildren(firstLevelChildren);
    }


    @Test
    public void findGoodTestWrongExpectation() {
        Assert.assertNotEquals(fourthGoodInShop, Shop.findGood(fourthGroup, fifth));
    }

    @Test
    public void findGoodTest() {
        Assert.assertEquals(fifthGoodInShop, Shop.findGood(fourthGroup, fifth));
    }

    @Test
    public void getGoodsByNameTest() {
        Assert.assertEquals(secondGoodInShop, shop.getGoodsByName(second));
    }

    @Test(expected = AssertionError.class)
    public void getGoodsByNameTestWrongExpectation() {
        Assert.assertEquals(second, shop.getGoodsByName(second));
    }

}
