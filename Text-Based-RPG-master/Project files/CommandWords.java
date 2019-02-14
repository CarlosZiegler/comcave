import java.io.*;

public class CommandWords implements Serializable{
    
    private String[] validCommands = {
        "go", "quit", "help","clear", "use","to", "talk","give", "take", "drop", "inventory", "open", "look", "examine", "unlock", "equip", "status", "buy", "sell"
    };
    
    public CommandWords() {
    }
    
    public boolean isCommand(String aString) {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString)) 
            return true;
        }
        
        return false;
    }
    
    public boolean isSecondCommand(String aString) {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
            return true;
        }
        
        return false;
    }
    
    public String[] showAll() {
        return validCommands;
    }
}