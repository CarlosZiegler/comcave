import java.io.*;

public class Player extends Character implements Serializable{

    private double gold;
    private Inventory inventory;
    private int health;
    private int blockPrs;

    private Shield shield;
    private Helmet helmet;

    public Player(String name, String description) {
        super(name,description);
        gold = 100;
        health = 100;
        inventory = new Inventory();
        blockPrs = 0;
        shield = null;
        helmet = null;
    }
    
    public Helmet getHelmet() {
        return helmet;
    }
    
    public void removeHelmet(Helmet helmet) {
        health = health - helmet.getHealthBonus();
        this.helmet = null;
    }
    
    public void addHelmet(Helmet helmet) {
        if(this.helmet != null) {
            removeHelmet(this.helmet);
        }
            
        this.helmet = helmet;
        health = health + helmet.getHealthBonus();
    } 
    
    public Shield getShield() {
        return shield;
    }

    public void removeShield(Shield shield) {
        health = health - shield.getHealthBonus();
        blockPrs = blockPrs - shield.getBlockPercent();
        shield = null;
    }
    
    public void addShield(Shield eShield) {
        if(this.shield != null) {
            removeShield(this.shield);
        }
            
        this.shield = eShield;
        health = health + eShield.getHealthBonus();
        blockPrs = blockPrs + eShield.getBlockPercent();
    } 
    
    public int getBlockPrs() {
        return blockPrs;
    }
    
    public int getHealth() {
        return health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String printStatus() {
        return super.getName() + ", " + super.getDescription() + "\n" +"Health: " + health + ", Block chance " + blockPrs + "%, Gold: " + gold;
    }
    
    public void looseHealth(int dmg) {
        health = health - dmg;
        if (health < 0) {
            health = 0;
        }
        else if(health > 100) {
            health = 100;
        }
    }
    
    public double getGold() {
        return gold;
    }
    
    public void addGold(double g) {
        gold = gold + g;
    }
    
    public void removeGold(double g) {
        gold = gold - g;
    }
    
    public void die() {
        System.out.println("You have died...");
        System.exit(0);
    }
    
    public void heal(int healingAmount) {
        if(health + healingAmount > 100) {
            health = 100;
        }
        else {
            health = health + healingAmount;
        }
    }
}