import java.util.ArrayList;

/**
 * Created by Misha on 25.07.2015.
 */
public class GoodsInShop {
    private Goods good;
    private int amount;

    public GoodsInShop(Goods good, int amount){
        this.good=good;
        this.amount=amount;
    }

    @Override
    public String toString() {
        return good.toString() +
                ", amount=" + amount +
                '}';
    }

    public void setGood(Goods good){
        this.good=good;
    }

    public Goods getGood(){
        return good;
    }

    public void setAmount(int amount){
        this.amount=amount;
    }

    public int getAmount(){
        return amount;
    }

    public static void main(String[] args) {

        ArrayList<Groups> groupList=new ArrayList<Groups>();
        Groups Groupheadphones=new Groups("Groupheadphones", null, null);
        Groups Groupxbox=new Groups("Groupxbox", null, null);

        groupList.add(Groupheadphones);
        groupList.add(Groupxbox);

        Goods Xbox=new Goods("XboxWithHeadphones", 1000);
        Goods pc = new Goods("PC", 2000);
        System.out.println(Xbox.id);
        System.out.println(pc.id);

        GoodsInShop XboxInShop = new GoodsInShop(Xbox, 100);
        GoodsInShop pcInShop = new GoodsInShop(pc, 10);
        ArrayList<GoodsInShop> goodsContainer=new ArrayList<GoodsInShop>();
        goodsContainer.add(XboxInShop);
        goodsContainer.add(pcInShop);

        Groupheadphones.setGoods(goodsContainer);

        Groups mainAncestor=new Groups("resultGroup",groupList, null);

        System.out.println(mainAncestor.getChildren().get(0).getGoods().get(0).toString());

        }

        //Groups.generalGroup.setChildren(groupList);
        //System.out.println("+++++++++++++++++++++++");
        //System.out.println(Groups.generalGroup.getChildren().get(0).getGoods().get(0).getName());
    }


