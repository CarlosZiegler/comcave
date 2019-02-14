import java.io.*;
import java.util.Random;

public class Healing extends CarryableItem implements Serializable{
    
    private int minHeal;
    private int maxHeal;
    
    public Healing(String name, String description, int weight, int value, int minHeal, int maxHeal) {
        super(name,description,weight,value);
        this.minHeal = minHeal;
        this.maxHeal = maxHeal;
    }
    
    private int getMinHeal() {
        return minHeal;
    }
    
    private int getMaxHeal() {
        return maxHeal;
    }
    
    public String print() {
        return super.getName() + ": " + super.getDescription() + "\nHeals " + minHeal + "-" + maxHeal;
    }
    
    public String use(Room currentRoom) {
        Player player = currentRoom.getPlayer();
        
        Random randomGenerator = new Random();
        
        int healingAmount = randomGenerator.nextInt(maxHeal + minHeal) + minHeal;
        
        player.heal(healingAmount);
        
        if(player.getHealth() == 100) {
            return "You use " + super.getName() + ", it gives you full health.";
        }
        else {
            return "You use " + super.getName() + ", it heals you for " + healingAmount + "health points.";
        }
    }
}