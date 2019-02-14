import java.util.Scanner;
import java.io.*;

public class Parser implements Serializable{
    
    private CommandWords commands;
    private Scanner reader;
    private String input;
    
    public Parser() {
        commands = new CommandWords();
    }

    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;
        String word3 = null;
        String word4 = null;
        
        
        Scanner tokenizer = new Scanner(input.toLowerCase());
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
                if(tokenizer.hasNext()) {
                    String p = tokenizer.next();
                    if(commands.isCommand(p)) {
                        word3 = p; 
                        if(tokenizer.hasNext()) {
                            word4 = tokenizer.next();
                        }
                    }
                    else {
                        word2 = word2 + " " + p;
                        if(tokenizer.hasNext()) {
                            if(commands.isCommand(tokenizer.next())) {
                                word3 = tokenizer.next();
                                if(tokenizer.hasNext()) {
                                    word4 = tokenizer.next();
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if(commands.isCommand(word1)) {
            if(commands.isSecondCommand(word3)) {
                return new Command(word1,word2,word3,word4);
            }
            else {
                return new Command(word1, word2, null, null);
            }
        }
        else {
            return new Command(null, word2, null, null);
        }
    }
    
    public String[] showCommands() {
        return commands.showAll();
    }
    
    public void sendInput(String input){
        this.input = input;
    }
}