import java.io.*;

public class Helmet extends Armor implements Serializable{

    public Helmet(String name, String description, int weight, int value, int healthBonus) {
        super(name, description,weight,value,healthBonus);
    }
}
