package kz.bitlab;


import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Item> items = new ArrayList<>();

    static {
        items.add(new Item( 1l ,"Iphone13 Pro", 450000, 50));
        items.add(new Item( 2L ,"Iphone13 Pro", 450000, 50));
        items.add(new Item( 3l ,"Iphone13 Pro", 450000, 50));
        items.add(new Item( 4l ,"Iphone13 Pro", 450000, 50));
        items.add(new Item( 5l ,"Iphone13 Pro", 450000, 50));
    }



    public static void addItem(Item item){
        items.add(item);
    }

    public static ArrayList<Item> getAllItems(){
        return items;
    }

}