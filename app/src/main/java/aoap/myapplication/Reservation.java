package aoap.myapplication;

/**
 * Created by Austin on 11/13/2017.
 */

public class Reservation {
    private String name;
    private String time;
    private String dish;
    private String price;
    private String table;

    public Reservation(String name, String time, String dish, String price, String table){
        this.name = name;
        this.time = time;
        this.dish = dish;
        this.price = price;
        this.table = table;
    }

    public String getName(){
        return name;
    }

    public String getTime(){
        return time;
    }

    public String getDish(){
        return dish;
    }

    public String getPrice(){
        return price;
    }

    public String getTable(){
        return table;
    }

}
