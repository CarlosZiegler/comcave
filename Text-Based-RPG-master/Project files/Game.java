import java.io.*;

public class Game implements Serializable {
    
    private GameEngine game;
    private Parser parser;
    private Gui gui;

    
    public static void main(String[] args) {
        Parser parser = new Parser();
        Gui gui = new Gui();
        GameEngine game = new GameEngine();
        
        gui.setGame(game);
        gui.setParser(parser);
        game.setGui(gui);
        game.setParser(parser);
    }

}