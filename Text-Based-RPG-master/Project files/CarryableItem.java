import java.io.*;

public class CarryableItem extends Item implements Serializable{
    
    private int weight;
    private int value;
    
    public CarryableItem(String name, String description, int weight, int value) {
        super(name, description);
        this.weight = weight;
        this.value = value;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getValue() {
        return value;
    }
    
    public String use(Room currentRoom) {
        return "";
    }
    
    public void drop() {
    }
    
    public String print() {
        return null;
    }
}