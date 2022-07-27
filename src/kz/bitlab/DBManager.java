package kz.bitlab;


import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Item> items = new ArrayList<>();
    private static Long id = 6L;



    public static void addItem(Item item) {
        item.setId(id);
        items.add(item);
        id++;
    }

    public static ArrayList<Item> getAllItems() {
        return items;
    }

    public static Item getItem(Long id) {
        for (Item itm : items) {
            if (itm.getId() == id) {
                return itm;
            }
        }
        return null;
    }

    public static void update(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == item.getId()) {
                items.set(i, item);
                break;
            }
        }
    }

    public static void delete(Long id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                break;
            }
        }

    }

}