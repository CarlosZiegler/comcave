import java.io.*;

public class Character implements Serializable{
    
    private String name;
    private String description;
    
    public Character(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public String interact() {
        return null;
    }
    
    public String give(Item item) {
        return null;
    }
}