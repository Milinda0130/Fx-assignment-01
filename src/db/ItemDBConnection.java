package db;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDBConnection {

    private static ItemDBConnection instance;
    private List<Item> itemList;

    private ItemDBConnection(){

        itemList = new ArrayList<>();
    }

    public List<Item> getDBList(){
        return itemList;
    }
    public static ItemDBConnection getInstance(){
        return instance==null?instance=new ItemDBConnection():instance;
    }

}
