import java.io.*;

public class Shield extends Armor implements Serializable{
    
    private int blockPrs;
    
    public Shield(String name, String description, int weight, int value, int blockPrs, int healthBonus) {
        super(name, description, weight, value, healthBonus);
        this.blockPrs = blockPrs;
    }
    
    public int getBlockPercent() {
        return blockPrs;
    }
   
    public String print() {
        return super.getName() + ": " + super.getDescription() + "\nHealthbonus " + super.getHealthBonus() + ", Block chance " + blockPrs;
    }
}