import java.util.*;
import java.io.*;

public class Wizard extends Enemy implements Serializable{
    
    private String[] attacks;

    
    public Wizard (String name, String description, int minDmg, int maxDmg, int blockPrs, int maxHealth) {
        super(name,description,minDmg,maxDmg,blockPrs, maxHealth);
        fillAttacks();
    }
    
    private void fillAttacks() {
        attacks = new String[] {
            "hurls a fireball",
            "summons a crackling ball of lightning",
            "shatters the earth beneath you",
            "engulfs you in flame",
        };
    }
}