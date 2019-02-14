import java.util.*;
import java.io.*;

public class Key extends CarryableItem implements Serializable{
    
    private Room room;
    
    public Key(String name, String description, int weight, int value, Room room) {
        super(name, description, weight, value);
        this.room = room;
    }
    
    public String use(Room currentRoom) {
        HashMap p = room.getExits();
        Iterator it = p.values().iterator();
        while( it.hasNext()) {
            Room s = (Room)it.next();
            if(!(s.equals(currentRoom))) {
                return "You cant use that here..";
            }
            else {
                room.unlock();
                return "You use " + super.getName() + " to unlock " + room.getName();
            }
        }
        return "";
    }
    
    public Room getLock() {
        return room;
    }
    
    public String print() {
        return super.getName() + ": " + super.getDescription() + "\nUnlocks: " + room.getName();
    }
}