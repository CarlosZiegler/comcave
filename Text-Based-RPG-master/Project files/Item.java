import java.io.*;

public class Item implements Serializable{
    
    private String name;
    private String description;
    
    /**
     * constructor, for våpen.
     * trenger maxdmg, minDmg, value og weight.
     * 
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String print() {
        return null;
    }
}