import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Misha on 23.07.2015.
 */
public class Goods {
    private String name;
    private int price;
    public  int id;
    public static int count=1;

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }

    private  int generateId(){
        return count++;
    }


    public Goods(String name, int price){
        this.name=name;
        this.price=price;
        this.id=this.generateId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
