import java.util.*;
import java.io.*;

public class Weapon extends CarryableItem implements Serializable{
    
    private int minDmg;
    private int maxDmg;
    
    public Weapon(String name, String description, int weight, int value, int minDmg, int maxDmg) {
        super(name, description, weight, value);
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
    }
    
    public int getMinDmg() {
        return minDmg;
    }
    
    public int getMaxDmg() {
        return maxDmg;
    }
    
    public String print() {
        return super.getName() + ": " + super.getDescription() + "\nDamage: " + minDmg + "-" + maxDmg;
    }
    
    public String use(Room currentRoom) {
        String p = null;
        Enemy enemy = currentRoom.getEnemy();
        
        if(!currentRoom.checkEnemy()) {
            return "You swing your " + super.getName();
        }
        else {
            Random randomGenerator = new Random();
            Player player = currentRoom.getPlayer();
            
            int hitChance = randomGenerator.nextInt(101 - 1) + 1;
            
            if(hitChance > enemy.getBlockPrs()) {
                p = playerAttack(currentRoom);
            }
            else {
                p =  enemy.getName() + " blocks your attack.";
            }
            if(currentRoom.checkEnemy() == true) {
                if(hitChance > player.getBlockPrs()) {
                    p = p + "\n\n" + enemy.getAttack(currentRoom);
                }
                else {
                    p = p + "\n\nYou block the attack from " + enemy.getName();
                }
            }
            else {
                p = "With all your strength you strike at the " + enemy.getName() + ", the " + enemy.getName() + " falls dead on the ground.." + "\n\n" + currentRoom.getLongDescription();
            }
        }
 
        
        return p;
    }
    
    private String playerAttack(Room currentRoom) {
        Enemy enemy = currentRoom.getEnemy();
        Player player = currentRoom.getPlayer();
        Random randomGenerator = new Random();
        
        int dmg = randomGenerator.nextInt(maxDmg + minDmg) + minDmg;
        
        enemy.looseHealth(dmg);
        
        if(enemy.getHealth() <= 0) {
            currentRoom.killEnemy();
            return "";
        }
        else {
            return "You swing your " + super.getName() + " at " + enemy.getName() + " for " + dmg + " damage!, Enemy has " + enemy.getHealth() + " health left.";
        }
    }
}

