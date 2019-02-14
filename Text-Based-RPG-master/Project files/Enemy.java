import java.util.*;
import java.io.*;

public class Enemy extends Character implements Serializable{
    
    private boolean isAlive;
    private int minDmg;
    private int maxDmg;
    private int maxHealth;
    private int health;
    private int blockPrs;
    private ArrayList<String> attacks;
    
    public Enemy(String name, String description, int minDmg, int maxDmg, int blockPrs, int maxHealth) {
        super(name, description);
        isAlive = true;
        this.maxHealth = maxHealth;
        health = maxHealth;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.blockPrs = blockPrs;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getMinDmg() {
        return minDmg;
    }
    
    public int getMaxDmg() {
        return maxDmg;
    }
    
    public boolean getState() {
        return isAlive;
    }
    
    public int getBlockPrs() {
        return blockPrs;
    }
    
    public void kill() {
        isAlive = false;
    }
    
    public void looseHealth(int dmg) {
        health = health - dmg;
        if(health < 0) {
            health = 0;
        }
        else if(health > 100) {
            health = 100;
        }
    }
    
    public String[] getAttacks() {
        return null;
    }
    
    public String getAttack(Room currentRoom) {
        double d = Math.random();
        Player player = currentRoom.getPlayer();
        
        if(d > 0.15) {
        
            Random randomAttack = new Random();
            String[] attacks = getAttacks();
            
            int p = 0;
            int s = 2; 
            int r = randomAttack.nextInt(s + p);
       
            String attack = "teeeest";//attacks[1];
        
            Random randomGenerator = new Random();
            int damage = randomGenerator.nextInt(maxDmg - minDmg) + minDmg;
            
            player.looseHealth(damage);
            
            if(player.getHealth() <= 0) {
                player.die();
                return "The player has died..";
            }
            else {
                return super.getName() + " " + attack + " for " + damage + "." + " Player has " + currentRoom.getPlayer().getHealth() + " health left.";
            }
        }
        else {
            Random randomHeal = new Random();
            int heal = randomHeal.nextInt(30-15) + 15;
            
            health = health + heal;
            if(health > maxHealth) {
                health = maxHealth;
                return super.getName() + " heals to full health.";
            }
            else {
                return super.getName() + " heals for " + heal + ". " + super.getName() + " has " + health + " health left.";
            }
        }
    }
}