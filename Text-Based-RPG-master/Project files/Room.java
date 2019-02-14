import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

/**
 * Room klassen inneholder informasjon om et rom i spillet.
 * Feltet exits er en HashMap med String og Room objekter. Setter utganger fra rom objektet.
 * Klassen inneholder objekter av klassen Item, Shop, ArrayList, Enemy.
 * isOpen er en boolean verdi for om rommet er låst eller ikke.
 */
public class Room implements Serializable {
    
    private String name;
    private String description;
    private boolean isOpen;
    private HashMap<String, Room> exits;
    private Enemy enemy;
    private boolean hasEnemy;
    private ArrayList<Item> inventory;
    private Shop shop;
    private Player player;
    private boolean isDark;
    private ArrayList<Character> npcs;
    
    /**
     * @constructor
     * Setter beskrivelse, isOpen, utganger, fiende og items.
     * @param String description - beskrivelse av rommet.
     * @param boolean isOpen - definerer om rommet er låst.
     */
    public Room(String name, String description, boolean isOpen) {
        this.name = name;
        this.description = description;
        this.isOpen = isOpen;
        exits = new HashMap<String, Room>();
        inventory = new ArrayList<Item>();
        enemy = null;
        hasEnemy = false;
        isDark = false;
        npcs = new ArrayList<Character>();
    }
    
    public void addNPC(Character npc) {
        npcs.add(npc);
    }
    
    public Character getNPC(String name) {
        Character p = null;
        for(Character each : npcs) {
            if(name.equals(each.getName())) {
                p = each;
            }
        }
        return p;
    }
    
    public void playerEnters(Player player) {
        this.player = player;
    }
    
    public void playerLeaves() {
        player = null;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public String getName() {
        return name;
    }
    
    /**
     * Setter en butikk i rommet.
     * @Shop shop.
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    
    /**
     * Returnerer shop - butikken i rommet.
     */
    public Shop getShop() {
        return shop;
    }
    
    /**
     * returnerer en boolean verdi true om det er en butikk i rommet.
     */
    public boolean hasShop() {
        if (shop != null) {
            return true;
        }
        return false;
    }
    
    /**
     * Legger til et objekt av Item klassen i en ArrayList.
     * @param Item
     */
    public void addItem(Item item) {
        inventory.add(item);
    }
    
    /**
     * 
     */
    public void setExit(String description, Room neighbour) {
        exits.put(description, neighbour);
    }
    
    public void removeTest(Item item) {
        inventory.remove(item);
    }
    
    public String getShortDescription() {
        return description;
    }
    
    public String getLongDescription() {
        if(isDark()) {
            return "This room is too dark to see..";
        }
        else {
            return name + "\n\n" + description + ".\n\n" + getExitString() + "\n" + getItemNames() + "\n" + getNpcNames();
        }
    }
    
    private String getNpcNames() {
        String names = "People: ";
        for(Character each : npcs) {
            names = names + each.getName() + ", ";
        }
        return names;
    }
    
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit + ", ";
        }
        return returnString;
    }
    
    private String getItemNames() {
        String itemNames = "Items:";

        for(Item eachItem : inventory) {
            if (eachItem instanceof CarryableItem) {
                itemNames += " " + eachItem.getName() + ", ";
            }
        }
        return itemNames;
    }
    
    public Item returnItemsInRoom(String name) {
        for (Item eachItem : inventory) {
            if (eachItem.getName().equals(name)) {
                return eachItem;
            }
        }
        return null;
    }
    
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    
    public boolean getIsOpen() {
        return isOpen;
    }
    
    public void unlock() {
        isOpen = true;
    }
    
    public boolean checkEnemy() {
        return hasEnemy;
    }
    
    public Enemy getEnemy() {
        return enemy;
    }
    
    public void addEnemy( Enemy monster) {
        enemy = monster;
        hasEnemy = true;
    }
    
    public void killEnemy() {
        enemy = null;
        hasEnemy = false;
    }

    public HashMap<String, Room> getExits() {
        return exits;
    }
    
    public void darken() {
        isDark = true;
    }
    
    public String lightRoom() {
        isDark = false;
        return getLongDescription();
    }
    
    public boolean isDark() {
        return isDark;
    }
}