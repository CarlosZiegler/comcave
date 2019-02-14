import java.util.*;
import java.io.*;

public class Guard extends Character implements Serializable {
    
    private String[] sentences = {
        "Im watching you!", "Dont cause any trouble!", "Do you want something?!", "Hail the king!"};
        
        public Guard(String name, String description) {
            super(name,description);
        }
        
        public String interact() {
            Random sentenceGenerator = new Random();
            int i = sentenceGenerator.nextInt(sentences.length - 0);
            
            return sentences[i];
        }
    
}