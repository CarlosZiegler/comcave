import java.io.*;

public class Containers extends Item implements Serializable{
    
    private Item contains;
    
    public Containers(String name, String description, Item contains) {
        super(name, description);
        this.contains = contains;
    }
    
    public void removeContent(Item item) {
        contains = null;
    }
    
    public Item getContent() {
        return contains;
    }
    
    public String print() {
        return super.getDescription();
    }
}
        
       