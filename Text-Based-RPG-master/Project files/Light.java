import java.io.*;

public class Light extends CarryableItem implements Serializable{

    public Light(String name, String description, int weight, int value) {
        super(name, description, weight, value);
    }
    
    public String use (Room currentRoom) {
        
        if(currentRoom.isDark()) {
            return "You light the " + super.getName() +"." + "\n\n" + currentRoom.lightRoom();
        }
        else {
            return "Isn't it bright enough here?..";
        }
    }
    
    public String print() {
        return super.getDescription();
    }
}