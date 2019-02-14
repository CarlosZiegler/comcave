import java.util.ArrayList;
import java.io.*;

public class Inventory implements Serializable {

    private ArrayList<Item> inventory;
    private int weight;
    private GameEngine game;
    
    public Inventory() {
        inventory = new ArrayList<Item>();
        weight = 0;
        this.game = game;
    }
    
    public String printInventory() {
        return getInventory() +"\n" + weight + "/30 ";
    }
    
    private String getInventory() {
        String i = "Inventory:";

        for (Item eachItem : inventory) {
            i += " " + eachItem.getName() + ", ";
        }
        return i;
    }
    
    public String getItems(String name) {
        String item = null;
        for(Item eachItem : inventory) {
            item = eachItem.getName();
            if(item.equals(name)) {
                item = name;
                break;
            }
        }
        return item;
    }
    
    public void addItem(CarryableItem item) {
        int w = item.getWeight();
        weight = weight + w;
        inventory.add(item);
    }
    
    public void removeItem(CarryableItem item) {
        int w = item.getWeight();
        weight = weight -w;
        inventory.remove(item);
    }
    
    public CarryableItem getItem(String name) {
        String itemName = name;
        CarryableItem item = null;
        for(Item eachItem : inventory) {
            String iName = eachItem.getName();
            if(iName.equals(itemName)) {
                if(eachItem instanceof CarryableItem) {
                    item = ((CarryableItem)eachItem);
                    break;
                }
            }
        }
        return item;
    }
    
    public CarryableItem returnItems(String name) {
        String itemName = name;
        CarryableItem item = null;
        
        for (Item eachItem : inventory) {
            String eachName = eachItem.getName();
            if(eachName.equals(itemName)) {
                if(eachItem instanceof CarryableItem) {
                    item = ((CarryableItem)eachItem);
                    break;
                }
            }
        }
        
        return item;
    }
    
    public boolean getKey () {
        boolean hasKey = false;
        
        for(Item eachItem : inventory) {
            if (eachItem instanceof Key) {
                hasKey =  true;
            }
        }
        return hasKey;
    }
    
    public int getWeight() {
        return weight;
    }

}
