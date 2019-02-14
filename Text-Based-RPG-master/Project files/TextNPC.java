import java.util.HashMap;
import java.io.*;

public class TextNPC extends Character implements Serializable{
    
    private String firstResponse;
    private String secondResponse;
    private String wrongResponse;
    private HashMap<Item,String> interaction;
    private Item itemWants;
    
    public TextNPC(String name, String description, Item item, String firstResponse, String secondResponse, String wrongResponse){
        super(name,description);
        interaction = new HashMap<Item, String>();
        interaction.put(item, secondResponse);
        this.firstResponse = firstResponse;
        this.secondResponse = secondResponse;
        this.wrongResponse = wrongResponse;
        itemWants = null;
    }
    
    public String interact() {
        if(itemWants == null) {
            return firstResponse;
        }
        else {
            return secondResponse;
        }
    }
    
    public String give(Item item) {
        if(interaction.containsKey(item)) {
            itemWants = item;
            return interaction.get(item);
        }
        else {
            return wrongResponse;
        }
    }
}