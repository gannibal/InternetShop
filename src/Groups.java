import java.util.ArrayList;

/**
 * Created by Misha on 23.07.2015.
 */
public class Groups {
    private String name;
    private ArrayList<Groups> children=new ArrayList<Groups>();
    private ArrayList<GoodsInShop> goods;
    public static Groups generalGroup=new Groups("General",null, null);

    public Groups(String name, ArrayList<Groups> children, ArrayList<GoodsInShop> goods){
        this.name=name;
        this.children=children;
        this.goods=goods;
        if(!this.name.equals("General"))
        this.addChildrenToGeneral();

    }

    public  void addChildrenToGeneral(){
        generalGroup.children.add(this);
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public ArrayList<GoodsInShop> getGoods(){
        return this.goods;
    }

    public void setGoods(ArrayList<GoodsInShop> goods){
        this.goods=goods;
    }

    public ArrayList<Groups> getChildren(){
        return this.children;
    }

    public void setChildren(ArrayList<Groups> children){
        this.children=children;
    }

    public void refreshBalanceOfGroup(Groups group){

    }
    public void refreshTotalBalance(){}

    public static void main(String[] args) {

        ArrayList<Goods> goods=new ArrayList<Goods>();

        Groups firstGroup=new Groups("first", null, null);

        Goods goods1=new Goods("headphones", 1000);
        goods.add(goods1);

        System.out.println(generalGroup.getChildren().get(0).name);

    }
}
