import java.util.ArrayList;
import java.io.*;

public class Shop implements Serializable{
    
    private String name;
    private String description;
    private double gold;
    private Inventory inventory;
    
    public Shop(String name, String description, double gold) {
        this.name = name;
        this.description = description;
        this.gold = gold;
        inventory = new Inventory();
    }
    
    public String getName() {
        return name;
    }
    
    public String printShop() {
        return "\n" +  name + "\n" + description + "\n"  + inventory.printInventory() + "\n" + "Gold: " + gold; 
    }
    
    public String getDescription() {
        return description;
    }
    
    public void sellItem(CarryableItem item) {
        inventory.addItem(item);
        gold = gold - item.getValue();
    }
    
    public CarryableItem buyItem(Command command) {
        CarryableItem buyItem = inventory.getItem(command.getSecondWord());
        inventory.removeItem(buyItem);
        gold = gold + buyItem.getValue();
        return buyItem;
    }
    
    public void returnInventory() {
        inventory.printInventory();
    }
    
    public void addToShop(CarryableItem item) {
        inventory.addItem(item);
    }
    
    public void removeFromShop(CarryableItem item) {
        inventory.removeItem(item);
    }
    
    public String checkInventory(String name) {
        String i = inventory.getItems(name);
        return i;
    }
}