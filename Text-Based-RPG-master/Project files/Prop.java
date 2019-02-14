import java.io.*;

public class Prop extends Item implements Serializable{
    
    public Prop(String name, String description) {
        super(name, description);
    }
    
    public String print() {
        return super.getDescription();
    }
}