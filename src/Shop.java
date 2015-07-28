import java.util.ArrayList;

/**
 * Created by Misha on 24.07.2015.
 */
public class Shop {
    private ArrayList<Groups> groups;
    private static ShoppingCart cart=new ShoppingCart();

    public static GoodsInShop findInGroupAndAddToCart(Groups group, GoodsInShop goods) {
        GoodsInShop forCart=null;
        for (int i = 0; i < group.getGoods().size(); i++) {
            if (group.getGoods().get(i).getGood().getName().equals(goods.getGood().getName()))
                forCart=group.getGoods().get(i);

        }
        return forCart;
    }

    public  GoodsInShop getGoodsByName(ArrayList<Groups> groups1, GoodsInShop goods) {
        GoodsInShop good=null;
        for(Groups group: groups1){
            if(group.getGoods()!=null)
                good=findInGroupAndAddToCart(group, goods);
            if (group.getChildren()!=null&&good==null){
                for (int i = 0; i < group.getChildren().size(); i++) {
                    group = group.getChildren().get(i);
                    good=findInGroupAndAddToCart(group,goods);
                    if(cart.getOrders()!=null)
                        break;
                }
            }
        }

        return good;
    }

    public Goods getGoodsByGroup(Groups group){


        return null;
    }

    public void buyGoods(GoodsInShop goods){

    }

    public static void main(String[] args) {

        /*ArrayList<Groups> firstChild=new ArrayList<Groups>();
        Groups secondChild=new Groups("secondChild", null, null);
        Groups thirdChild=new Groups("thirdChild", null, null);

        firstChild.add(secondChild);
        firstChild.add(thirdChild);

        Goods Xbox=new Goods("XboxWithHeadphones", 1000);
        Goods pc = new Goods("PC", 2000);
        System.out.println(Xbox.id);
        System.out.println(pc.id);

        GoodsInShop XboxInShop = new GoodsInShop(Xbox, 100);
        GoodsInShop pcInShop = new GoodsInShop(pc, 10);
        ArrayList<GoodsInShop> goodsContainer=new ArrayList<GoodsInShop>();
        goodsContainer.add(XboxInShop);
        goodsContainer.add(pcInShop);

        secondChild.setGoods(goodsContainer);

        Groups mainAncestor=new Groups("resultGroup",firstChild, null);


        Shop shop=new Shop();
        Goods goods=new Goods("XboxWithHeadphones", 10);
        GoodsInShop find=new GoodsInShop(goods,10);
        shop.getGoodsByName(mainAncestor.getChildren(), find);
*/




        Goods fifth=new Goods("fifthGood", 100);
        GoodsInShop fifthGood=new GoodsInShop(fifth, 10);
        Goods fourth=new Goods("fourthGood", 10);
        GoodsInShop fourthGood=new GoodsInShop(fourth, 10);
        ArrayList<GoodsInShop> four=new ArrayList<GoodsInShop>();
        four.add(fourthGood);
        four.add(fifthGood);
        Groups fourthGroup=new Groups("fourthGroup", null, four);

        ArrayList<Groups> thirdGroupChildren=new ArrayList<Groups>();
        thirdGroupChildren.add(fourthGroup);
        Groups thirdGroup=new Groups("thirdGroup", thirdGroupChildren, null);

        //-------------------------------------------------------------------------

        Goods third=new Goods("thirdChild", 100);
        GoodsInShop thirdGood=new GoodsInShop(third, 10);

        Goods second=new Goods("secondChild", 10);
        GoodsInShop secondGood=new GoodsInShop(second, 10);
        ArrayList<GoodsInShop> secondChildGoods=new ArrayList<GoodsInShop>();
        secondChildGoods.add(thirdGood);
        secondChildGoods.add(secondGood);

        Groups secondChildGroup=new Groups("secondChildGroup",null, secondChildGoods);
        ArrayList<Groups> secondChildInList=new ArrayList<Groups>();
        secondChildInList.add(secondChildGroup);

        Goods firstGoods=new Goods("firstGood", 10);
        GoodsInShop firstGood=new GoodsInShop(firstGoods, 4);

        ArrayList<GoodsInShop> firstGoodInList=new ArrayList<GoodsInShop>();
        firstGoodInList.add(firstGood);

        Groups fistChild=new Groups("firstChild",secondChildInList,firstGoodInList);

        ArrayList<Groups> firstLevelChildren=new ArrayList<Groups>();
        firstLevelChildren.add(fistChild);
        firstLevelChildren.add(thirdGroup);

        Groups mainGroup=new Groups("mainGroup",firstLevelChildren,null);

        Shop shop=new Shop();
        Goods goods=new Goods("firstGood", 10);
        GoodsInShop find=new GoodsInShop(goods,10);
        GoodsInShop result=shop.getGoodsByName(mainGroup.getChildren(), find);
        System.out.println(result.getGood().getName());


    }
}
