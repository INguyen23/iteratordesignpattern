package iteratordesignpattern;

import java.util.Iterator;
import java.util.ArrayList;

public class WishList {
    private String name;
    private Item[] items;
    private int count;

    public WishList(String name){
        this.name=name;
        items=new Item[5];
        count=0;
    }

    public void addItem(String title, String description, double price){
        if(count == items.length){
            items = growArray(items);
        }

        items[count] = new Item(title, description, price);
        count++;
    }

    public WishListIterator createIterator(){
        return new WishListIterator(items);
    }

    public double getTotalCost(){
        double total=0;
        for(int i=0;i<count;i++)
            total += items[i].getPrice();
        return total;
    }

    private Item[] growArray(Item[] items){
        Item[] temp = new Item[2*items.length];
        for(int i=0;i<items.length;i++)
            temp[i] = items[i];
        return temp;
    }
}
