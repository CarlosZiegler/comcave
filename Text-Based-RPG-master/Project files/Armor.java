import java.io.*;

public class Armor extends CarryableItem implements Serializable{

    private int healthBonus;
    
    public Armor(String name, String description, int weight, int value, int healthBonus) {
        super(name, description, weight, value);
        this.healthBonus = healthBonus;
    }
    
    public int getHealthBonus() {
        return healthBonus;
    }
    
    public void drop(Room currentRoom) {
        Player player = currentRoom.getPlayer();
        if(player.getHelmet() == this) {
            player.removeHelmet((Helmet)this);
        }
        else if(player.getShield() == this) {
            player.removeShield((Shield)this);
        }
        else {
        }
    }
    
    public String use(Room currentRoom) {
        Player player = currentRoom.getPlayer();
        
        if(this instanceof Helmet) {
            player.addHelmet((Helmet)this);
        }
        else if (this instanceof Shield) {
            player.addShield((Shield)this);
        }
        else {
        }
        return "You equip " + super.getName();
    }
    
    public String print() {
        return super.getName() + ": " + super.getDescription() + "\nHealthbonus " + healthBonus;
    }
}