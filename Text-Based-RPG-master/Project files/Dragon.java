import java.util.*;
import java.io.*;

public class Dragon extends Enemy implements Serializable{
    
    private String[] attacks;
    
    public Dragon (String name, String description, int minDmg, int maxDmg, int blockPrs, int maxHealth) {
        super(name,description,minDmg,maxDmg,blockPrs,maxHealth);
        fillAttacks();
    }
    
    private void fillAttacks() {
        attacks = new String[] {
            "breath's fire",
            "swings it's razorsharp tail",
            "flaps it's wings",
            "strikes with it's claws",
            "bites"
        };
    }
    
    public String[] getAttacks() {
        return attacks;
    }
}