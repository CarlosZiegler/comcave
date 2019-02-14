import java.util.*;
import java.io.*;

public class Goblin extends Enemy implements Serializable{
    
    private String[] attacks;

    
    public Goblin (String name, String description, int minDmg, int maxDmg, int blockPrs, int maxHealth) {
        super(name,description,minDmg,maxDmg,blockPrs,maxHealth);
        fillAttacks();
    }
    
    private void fillAttacks() {
        attacks = new String[] {
            "stabs",
            "swings it's sword",
            "kicks"
        };
    }

}