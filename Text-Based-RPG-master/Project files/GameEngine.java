import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Klassen Game, starter og kjører spillet.
 * Inneholder 8 felter.
 * Klassen inneholder metodene for handlinger spilleren kan utføre, og metoder for å fylle ut spillverdenen.
 * Klassen bruker objekter av klassene Room, Parser, Inventory, ArrayList, Player, Enemy, Scanner, Random, Shop, CommandWord.
 * 
 * @author Aleksander Jacobsen  
 * @version 1.0 (14.04.2014)
 */

public class GameEngine implements Serializable {
    
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;
    private Player player;
    private Enemy enemy;
    private Gui gui;
    
    static String[] display = {


"                                             /   \\                                  ",
"            _                        )      ((   ))     (                           ",
"           (@)                      /|\\      ))_((     /|\\                          ",
"|-|                     / | \\    (/\\|/\\)   / | \\                      (@)",
"| | -------------------/--|-voV---\\`|'/--Vov-|--\\---------------------|-|",
"|-|                         '^`   (o o)  '^`                          | |",
"| |                               `\\Y/'                               |-|",
"|-|                                                                   | |",
"| |                           WORLD OF ZUUL                           |-|",
"|-|                                                                   | |",
"| |                                                                   |-|",
"|_|___________________________________________________________________| |",
"(@)              l   /\\ /         ( (       \\ /\\   l                `\\|-|",
"                 l /   V           \\ \\       V   \\ l                  (@)",
"                 l/                _) )_          \\I                     ",
"                                   `\\ /'                                 ",
"                                           `                                "};

    
    
    /**
     * constructor
     * Lager et nytt Parser og Player objekt.
     * utfører fillRooms().
     */
    public GameEngine() {
        midgaardKeep();
        player = new Player("Adventurer", "A young and ambitious adventurer seeking gold and fame.");
    }
    
    
    public Room getCR() {
        return currentRoom;
    }
    public void setParser(Parser parser) {
        this.parser = parser;
    }
    
    public Parser getParser() {
        return parser;
    }
    
    public void setGui(Gui gui) {
        this.gui = gui;
    }
    
    public Gui getGui() {
        return gui;
    }
    
    /**
     * Utfører printWelcome() metoden.
     * Starter spillet og kjører i en while loop til @boolean finished blir true.
     * lager et nytt object av Command klassen.
     */
    public void play(){
        printWelcome();
    }
    
    public Player getPlayer() {
        return player;
    }
    
    /**
     * Printer velkommen teksten og bruker input fra bruker til å sette navn på Player objekt.
     * Printer ut beskrivelse av nåværende rom.
     */
    private void printWelcome() {   
        gui.styleWhite("");
        for(String each : display) {
            gui.styleYellow(each);
        } 
        gui.styleYellow("");
        gui.styleYellow("");
        gui.styleYellow("Welcome to the World of Zuul!");
        gui.styleYellow("Made by Aleksander Jacobsen");
        gui.styleYellow("");
        gui.styleYellow("World of zuul is a text-based roleplaying game set in the world of Zuul. ");
        gui.styleYellow("You are an adventurer seeking gold an fame, you have heard the world of zuul holds deep caves filled with treasure and magical mysteries.");
        gui.styleYellow("");
        gui.styleYellow("");
        gui.styleWhite(currentRoom.getLongDescription());
    }
    
    /**
     * Prosesserer og utfører metode ut ifra Command objektet.
     * @param Command command
     * returnerer en boolean verdi til start() metoden om spillet skal avsluttes.
     */
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;
        gui.styleWhite("");
        
        if(command.isUnknown()) {
            gui.styleWhite("That command is unknown.");
            return false;
        }
        
        String commandWord = command.getCommandWord();
        
        if(commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            checkRoomExit(command);
        }
        else if (commandWord.equals("quit")) {
            quit(command);
        }
        else if (commandWord.equals("take")) {
            takeItem(command);
        }
        else if (commandWord.equals("drop")) {
            dropItem(command);
        }
        else if (commandWord.equals("inventory")) {
            openInventory(command);
        }
        else if (commandWord.equals("open")) {
            openContainer(command);
        }
        else if (commandWord.equals("look")) {
            look(command);
        }
        else if (commandWord.equals("examine")) {
            examineItem(command);
        }
        else if (commandWord.equals("unlock")) {
            unlockRoom(command);
        }
        else if (commandWord.equals("status")) {
            gui.styleWhite(player.printStatus());
        }
        else if (commandWord.equals("buy")) {
            buy(command);
        }
        else if (commandWord.equals("sell")) {
            sell(command);
        }
        else if (commandWord.equals("use")) {
            use(command);
        }
        else if (commandWord.equals("clear")) {
            gui.clear();
        }
        else if (commandWord.equals("talk")) {
            talk(command);
        }
        else if (commandWord.equals("give")) {
            give(command);
        }
        
        return wantToQuit;
    }
    
    /**
     * Printer ut alle tilgjengelige kommandoer.
     * Kommandoer fra arraylist i CommandWords klassen.
     */
    private void printHelp() {
        gui.styleWhite("The known commands are: ....");
        String[] validCommands = parser.showCommands();
        for(String each : validCommands) {
            gui.styleWhite(each);
        }
    }
    
    /**
     * Bruker command objektet som parameter for sjekke om retningen bruker vil gå har en utgang og om utgangen er låst.
     * Hvis det er en utgang og den ikke er låst utfører den goRoom() metoden.
     * @param Command command
     */
    private void checkRoomExit(Command command) {
        if (!command.hasSecondWord()) {
            gui.styleWhite("Go where?..");
            return;
        }
        
        String direction = command.getSecondWord();
           
        Room nextRoom = currentRoom.getExit(direction);
          
        if (nextRoom == null) {
            gui.styleWhite("you cant go that way...");
        }
        else if (nextRoom.getIsOpen() == false) {
            gui.styleWhite("The door is locked..");
        }
        else {
            goRoom(command, nextRoom);
        }
    }
    
    /**
     * Fører brukeren til neste rom.
     * Sjekker om rommet har en fiende, hvis rommet har en fiende må brukeren velge om han vil sloss eller ikke.
     * Hvis brukeren vil sloss utføres printAttacker() og killEnemy() metodene.
     * Hvis brukeren ikke vil sloss føres brukeren tilbake til forrige rom.
     * 
     * Sjekker også om rommet har et objekt av klassen Shop og printer ut butikken.
     * @param Command command
     * @param Room nextRoom
     */
    private void goRoom(Command command, Room nextRoom) {
        previousRoom = currentRoom;
        previousRoom.playerLeaves();
        currentRoom = nextRoom;
        currentRoom.playerEnters(player);
        
        if (currentRoom.checkEnemy()) {
            gui.styleWhite("There is " + currentRoom.getEnemy().getName() + " here.\n");
            gui.styleWhite(currentRoom.getEnemy().getDescription());
        }
        else {
            gui.styleWhite(currentRoom.getLongDescription());
        
            if(currentRoom.hasShop()) {
                gui.styleWhite(currentRoom.getShop().printShop());
            }
        }
    }
    
    /**
     * Utfører et kjøp fra butikken.
     * @param Command command
     */
    private void buy(Command command) {
        Shop shop = currentRoom.getShop();
        
        if(!currentRoom.hasShop()) {
            gui.styleWhite("There is no shop here..");
        }
        else if (!command.hasSecondWord()) {
            gui.styleWhite("Buy what?..");
        }
        else if(command.getSecondWord().equals(shop.checkInventory(command.getSecondWord()))) {
            CarryableItem item = currentRoom.getShop().buyItem(command);
            player.getInventory().addItem(item);
            gui.styleWhite("You buy " + item.getName() + " for " + item.getValue());
            double value = item.getValue();
            player.removeGold(value);
        }
        else {
            gui.styleWhite("There is no such item in the shop..");
        }
    }
    
    /**
     * Utfører et salg til butikken.
     * @param Command command
     */
    private void sell(Command command) {
        Shop shop = currentRoom.getShop();
        Inventory i = player.getInventory();
        
        if(!currentRoom.hasShop()) {
            gui.styleWhite("There is no shop here..");
        }
        else if(!command.hasSecondWord()) {
            gui.styleWhite("Sell what?..");
        }
        else if(command.getSecondWord().equals(i.getItems(command.getSecondWord()))) {
            CarryableItem item = i.getItem(command.getSecondWord());
            i.removeItem(item);
            shop.sellItem(item);
            double value = item.getValue() * 0.9;
            player.addGold(value);
            gui.styleWhite("You sell " + item.getName() + " for " + item.getValue());
        }
        else {
            gui.styleWhite("You have no such item..");
        }
    }
    
    /**
     * Sender brukeren tilbake til forige rom.
     * @param Room previousRoom
     */
    private void goBack(Room previousRoom) {
        currentRoom = previousRoom;
    }
    
    /**
     * Låser opp rommet hvis bruker har nøkkel.
     * @param Command command
     */
    private void unlockRoom(Command command) {
        if(!command.hasSecondWord()) {
            gui.styleWhite("Unlock what?..");
            return;
        }
        
        String direction = command.getSecondWord();
        
        Room nextRoom = currentRoom.getExit(direction);
        
        if (nextRoom == null) {
            gui.styleWhite("there is no door that way..");
        }
        else if (nextRoom.getIsOpen() == true) {
            gui.styleWhite("That door is already open..");
        }
        else if (nextRoom.getIsOpen() == false) {
            if (!player.getInventory().getKey()) {
                gui.styleWhite("You don't have a key..");
            }
            else {
                nextRoom.unlock();
                gui.styleWhite("You unlock the door..");
            }
        }
        
    }
    
    /**
     * Plasser et objekt av klassen Item i objektet bag av klassen Inventory.
     * @param Command command
     */
    private void takeItem(Command command) {

        Item isItem = currentRoom.returnItemsInRoom(command.getSecondWord());
        int w = player.getInventory().getWeight();
        
        if (isItem != null) {
            if (isItem instanceof CarryableItem) {
                if(((CarryableItem)isItem).getWeight() + w > 30) {
                    gui.styleWhite("You cant carry that mutch weight..");
                }
                else {
                    player.getInventory().addItem(((CarryableItem)isItem));
                    gui.styleWhite("you take " + isItem.getName());
                    currentRoom.removeTest(isItem);
                }
            }
            else {
                gui.styleWhite("You cant take that..");
            }
        }
        else {
            gui.styleWhite("Take what?");
        }
    }
    
    /**
     * Fjerner et Item objekt fra bag, og plasserer det i rommet.
     * @param Command command
     */
    private void dropItem(Command command) {
        String item = command.getSecondWord();
        
        CarryableItem items = player.getInventory().returnItems(item);

        if(items != null) {
            if(!(items instanceof Armor)) {
                player.getInventory().removeItem(items);
                currentRoom.addItem(items);
            }
            else {
                ((Armor)items).drop(currentRoom);
                player.getInventory().removeItem(items);
                currentRoom.addItem(items);
            }
            gui.styleWhite("you drop " + items.getName());
        
        }
        else {
            gui.styleWhite("Drop what?");
        }
    }
    
    /**
     * Printer ut en beskrivelse av det nåværende Room objekt.
     * @param Command command
     */
    private void look(Command command) {

        if(command.hasSecondWord() && !command.getSecondWord().equals("room")) {
            gui.styleWhite("That command is unknown.");
        }
        else {
            gui.styleWhite(currentRoom.getShortDescription());
        }

    }
    
    /**
     * printer ut en beskrivelse av et Item objekt.
     * @param Command
     */
    private void examineItem(Command command) {
        Item item = currentRoom.returnItemsInRoom(command.getSecondWord());
        Character character = currentRoom.getNPC(command.getSecondWord());
        
        if(item != null) {
            gui.styleWhite(item.print());
        }
        else if (character != null) {
            gui.styleWhite(character.getDescription());
        }
        else {
            gui.styleWhite("Examine what?..");
        }
    }
    
    /**
     * Printer ut alle objektene i bag objektet.
     * @param Command command
     */
    private void openInventory(Command command) {

        if(command.hasSecondWord()) {
            gui.styleWhite("That command is unknown.");
        }
        else {
            gui.styleWhite(player.getInventory().printInventory());
        }
    }
    
    private void openContainer(Command command) {
        Item container = currentRoom.returnItemsInRoom(command.getSecondWord());
        
        if(container == null) {
            gui.styleWhite("Open what?..");
        }
        else if (!(container instanceof Containers)) {
            gui.styleWhite("You cant open that..");
        }
        else {
            Item contains = ((Containers)container).getContent();
            if(contains == null) {
                gui.styleWhite("You open the " + container.getName() + ", it is empty..");
            }
            else {
                gui.styleWhite("You open the " + container.getName() + ", inside is a " + contains.getName());
                currentRoom.addItem(contains);
                ((Containers)container).removeContent(contains);
            }
        }
    }
    
    /**
     * Returnerer en boolean verdi true, hvis command = quit.
     * 
     */
    private void quit(Command command) {
        if(command.hasSecondWord()) {
            gui.styleWhite("Quit what?");
        }
        else {
            System.exit(0);
        }
    }
    
    private void use(Command command) {
        if (!command.hasSecondWord()) {
            gui.styleWhite("Use what?..");
        }
        else {
            String cWord = command.getSecondWord();
            CarryableItem p = player.getInventory().returnItems(cWord);
            if (p == null) {
                gui.styleWhite("You have no sutch item..");
            }
            else {
                gui.styleWhite(p.use(currentRoom));
            }
        }
    }
    
    private void talk(Command command) {
        String commandWord = command.getSecondWord();
        if(!command.hasSecondWord()) {
            gui.styleWhite("Talk to whom?");
        }
        else {
            Character p = currentRoom.getNPC(commandWord);
            if(p == null) {
                gui.styleWhite("There is no sutch person here..");
            }
            else {
                gui.styleWhite(p.interact());
            }
        }
    }
    
    private void give(Command command) {
        String commandWord = command.getSecondWord();
        
        if(!command.hasSecondWord()) {
            gui.styleWhite("Give what?");
        }
        else {
            Item giveItem = player.getInventory().returnItems(commandWord);
            if(giveItem == null) {
                gui.styleWhite("You have no sutch item..");
            }
            else {
                String secondCommand = command.getThirdWord();
                if(!command.hasThirdWord()) {
                    gui.styleWhite("Give to whom?..");
                }
                else {
                    String target = command.getFourthWord();
                    if(!command.hasFourthWord()) {
                        gui.styleWhite("Give to whom?..");
                    }
                    else {
                        Character npc = currentRoom.getNPC(target);
                        if(npc == null) {
                            gui.styleWhite("There is no sutch person here..");
                        }
                        else {
                            gui.styleWhite(npc.give(giveItem));
                        }
                    }
                }
            }
        }
    }
    
    
    private void midgaardKeep() {
        Room hallway1,hallway2,hallway3,hallway4,hallway5,hallway6,hallway7,hallway8,neTowerBase,nwTowerBase,swTowerBase,seTowerBase,nGate,sGate,wGate,eGate,
        mHall1,mHall2,mHall3,mHall4,mHall5,mHall6,mHall7,mHall8,aelronsSanct,
        //second floor
        nwTowerSec,neTowerSec,seTowerSec,swTowerSec,tRoom1,tRoom2,tRoom3,tRoom4,tRoom5,tRoom6,tRoom7,tRoom8,tRoom9,aChamber1,aChamber2,aChamber3,aChamber4,aChamber5,aChamber6,
        sHallway1,sHallway2,sHallway3,sHallway4,sHallway5,sHallway6,
        //third floor
        nwTowerTh,neTowerTh,seTowerTh,swTowerTh,tHallway1,tHallway2,tHallway3,tHallway4,tHallway5,tHallway6,tHallway7,tHallway8,tHallway9,emptyBed,bardBed,
        queenBed,kingBed,jesterBed,aelmonBed,
        //fourth floor
        fFloor;
        
        //towers
        nwTowerBase = new Room("Northwest tower base", "You are at the base of the northwest tower.",true);
        neTowerBase = new Room("Northeast tower base", "You are at the base of the northeast tower.",true);
        seTowerBase = new Room("Southeast tower base", "You are at the base of the southeast tower.",true);
        swTowerBase = new Room("Southwest tower base", "You are at the base of the southwest tower.",true);
        
        //outer halls
        hallway1 = new Room("Hallway", "You are in the outer hallway.",true);
        hallway2 = new Room("Hallway", "You are in the outer hallway.",true);
        hallway3 = new Room("Hallway", "You are in the outer hallway.",true);
        hallway4 = new Room("Hallway", "You are in the outer hallway.",true);
        hallway5 = new Room("Hallway", "You are in the outer hallway.",true);
        hallway6 = new Room("Hallway", "You are in the outer hallway.",true);
        hallway7 = new Room("Hallway", "You are in the outer hallway.",true);
        hallway8 = new Room("Hallway", "You are in the outer hallway.",true);
        
        //gates to city
        nGate = new Room("North gate", "You are at the north gate to the keep",true);
        eGate = new Room("East gate", "You are at the east gate to the keep",true);
        wGate = new Room("West gate", "You are at the west gate to the keep",true);
        sGate = new Room("South gate", "You are at the south gate to the keep",true);
        
        //main hall
        mHall1 = new Room("Main hall", "You are in the main hall of midgaard keep.",true);
        mHall2 = new Room("Main hall", "You are in the main hall of midgaard keep.",true);
        mHall3 = new Room("Main hall", "You are in the main hall of midgaard keep.",true);
        mHall4 = new Room("Main hall", "You are in the main hall of midgaard keep.",true);
        mHall5 = new Room("Main hall", "You are in the main hall of midgaard keep.",true);
        mHall6 = new Room("Main hall", "You are in the main hall of midgaard keep.",true);
        mHall7 = new Room("Main hall", "You are in the main hall of midgaard keep.",true);
        mHall8 = new Room("Main hall", "You are in the main hall of midgaard keep.",true);
        
        //aelrons sanctuary
        aelronsSanct = new Room("Aelrons sanctuary", "You are in Aelrons sanctuary.",true);
        
        //Second level of keep
        //towers
        nwTowerSec = new Room("Northwest Tower", "You are on the second floor of the northwest tower.",true);
        neTowerSec = new Room("Northeast Tower", "You are on the second floor of the northeast tower.",true);
        swTowerSec = new Room("Southwest Tower", "You are on the second floor of the southwest tower.",true);
        seTowerSec = new Room("Southeast Tower", "You are on the second floor of the southeast tower.",true);
        
        //Throne room
        tRoom1 = new Room("Throne room", "You are in the throne room",true);
        tRoom2 = new Room("Throne room", "You are in the throne room",true);
        tRoom3 = new Room("Throne room", "You are in the throne room",true);
        tRoom4 = new Room("Throne room", "You are in the throne room",true);
        tRoom5 = new Room("Throne room", "You are in the throne room",true);
        tRoom6 = new Room("Throne room", "You are in the throne room",true);
        tRoom7 = new Room("Throne room", "You are in the throne room",true);
        tRoom8 = new Room("Throne room", "You are in the throne room",true);
        tRoom9 = new Room("Throne room", "You are in the throne room",true);
        
        //antechamber to throne room
        aChamber1 = new Room("Antechamber","You are in the antechamber to the throne room.",true);
        aChamber2 = new Room("Antechamber","You are in the antechamber to the throne room.",true);
        aChamber3 = new Room("Antechamber","You are in the antechamber to the throne room.",true);
        aChamber4 = new Room("Antechamber","You are in the antechamber to the throne room.",true);
        aChamber5 = new Room("Antechamber","You are in the antechamber to the throne room.",true);
        aChamber6 = new Room("Antechamber","You are in the antechamber to the throne room.",true);
        
        //second level hallways
        sHallway1 = new Room("Hallway", "You are in a hallway.",true);
        sHallway2 = new Room("Hallway", "You are in a hallway.",true);
        sHallway3 = new Room("Hallway", "You are in a hallway.",true);
        sHallway4 = new Room("Hallway", "You are in a hallway.",true);
        sHallway5 = new Room("Hallway", "You are in a hallway.",true);
        sHallway6 = new Room("Hallway", "You are in a hallway.",true);
        
        //Third level of keep
        //towers
        nwTowerTh = new Room("Northwest Tower", "You are on the third floor of the northwest tower.",true);
        neTowerTh = new Room("Northeast Tower", "You are on the third floor of the northeast tower.",true);
        seTowerTh = new Room("Southeast Tower", "You are on the third floor of the southeast tower.",true);
        swTowerTh = new Room("Southwest Tower", "You are on the third floor of the southwest tower.",true);
        
        //third level hallways
        tHallway1 = new Room("Hallway", "You are in a hallway on the third floor of the keep.",true);
        tHallway2 = new Room("Hallway", "You are in a hallway on the third floor of the keep.",true);
        tHallway3 = new Room("Hallway", "You are in a hallway on the third floor of the keep.",true);
        tHallway4 = new Room("Hallway", "You are in a hallway on the third floor of the keep.",true);
        tHallway5 = new Room("Hallway", "You are in a hallway on the third floor of the keep.",true);
        tHallway6 = new Room("Hallway", "You are in a hallway on the third floor of the keep.",true);
        tHallway7 = new Room("Hallway", "You are in a hallway on the third floor of the keep.",true);
        tHallway8 = new Room("Hallway", "You are in a hallway on the third floor of the keep.",true);
        tHallway9 = new Room("Hallway", "You are in a hallway on the third floor of the keep.",true);
        
        //bed chambers
        emptyBed = new Room("Empty bedroom", "You are in an empty bedroom.",true);
        bardBed = new Room("Court Bard's bedroom", "You are in the bedroom of the court bard.",true);
        queenBed = new Room("Queen's bedroom", "You are in the bedroom of the queen.",true);
        kingBed = new Room("King's bedroom", "You are in the kings bedroom.",true);
        jesterBed = new Room("Jester's bedroom", "You are in Jester's bedroom.",true);
        aelmonBed = new Room("Aelmon's bedroom", "You are in maester Aelmons bedroom.",true);
        
        //Fourth floor
        fFloor = new Room("Fourth floor", "You are on the fourth floor",true);
        
        //towerbase exits
        nwTowerBase.setExit("east",hallway1);
        nwTowerBase.setExit("south",hallway8);
        nwTowerBase.setExit("up",nwTowerSec);
        
        neTowerBase.setExit("west",hallway2);
        neTowerBase.setExit("south",hallway3);
        neTowerBase.setExit("up",neTowerSec);
        
        seTowerBase.setExit("north",hallway4);
        seTowerBase.setExit("west",hallway5);
        seTowerBase.setExit("up",seTowerSec);
        
        swTowerBase.setExit("east",hallway6);
        swTowerBase.setExit("north",hallway7);
        swTowerBase.setExit("up",swTowerSec);
        
        //outer hallway exits
        hallway1.setExit("west", nwTowerBase);
        hallway1.setExit("east", nGate);
        
        hallway2.setExit("west", nGate);
        hallway2.setExit("east", neTowerBase);
        
        hallway3.setExit("north", neTowerBase);
        hallway3.setExit("south", eGate);
        
        hallway4.setExit("north", eGate);
        hallway4.setExit("south", seTowerBase);
        
        hallway5.setExit("east", seTowerBase);
        hallway5.setExit("west", sGate);
        
        hallway6.setExit("east", sGate);
        hallway6.setExit("west", swTowerBase);
        
        hallway7.setExit("south", swTowerBase);
        hallway7.setExit("north", wGate);
        
        hallway8.setExit("south", wGate);
        hallway8.setExit("north", nwTowerBase);
        
        //gates exits
        nGate.setExit("west",hallway1);
        nGate.setExit("east",hallway2);
        nGate.setExit("south",mHall1);
        
        eGate.setExit("north",hallway3);
        eGate.setExit("south",hallway4);
        eGate.setExit("west",mHall3);
        
        sGate.setExit("east",hallway5);
        sGate.setExit("west",hallway6);
        sGate.setExit("north",mHall5);
        
        wGate.setExit("south",hallway7);
        wGate.setExit("north",hallway8);
        wGate.setExit("east",mHall7);
        
        //mainhall exits
        mHall1.setExit("north",nGate);
        mHall1.setExit("east",mHall2);
        mHall1.setExit("south",aelronsSanct);
        mHall1.setExit("west",mHall8);
        
        mHall2.setExit("west", mHall1);
        mHall2.setExit("south",mHall3);
        
        mHall3.setExit("north",mHall2);
        mHall3.setExit("east",eGate);
        mHall3.setExit("west",aelronsSanct);
        mHall3.setExit("south",mHall4);
        
        mHall4.setExit("north",mHall3);
        mHall4.setExit("west",mHall5);
        
        mHall5.setExit("east",mHall4);
        mHall5.setExit("south",sGate);
        mHall5.setExit("north",aelronsSanct);
        mHall5.setExit("west",mHall6);
        
        mHall6.setExit("east",mHall5);
        mHall6.setExit("north",mHall7);
        
        mHall7.setExit("south", mHall6);
        mHall7.setExit("east", eGate);
        mHall7.setExit("west", aelronsSanct);
        mHall7.setExit("north", mHall8);
        
        mHall8.setExit("south", mHall7);
        mHall8.setExit("east",mHall1);
        
        //aelrons sanctuary exits
        aelronsSanct.setExit("north", mHall1);
        aelronsSanct.setExit("east", mHall3);
        aelronsSanct.setExit("south",mHall5);
        aelronsSanct.setExit("west", mHall7);
        
        //Second level exits
        //towers
        nwTowerSec.setExit("up",nwTowerTh);
        nwTowerSec.setExit("down",nwTowerBase);
        nwTowerSec.setExit("south",sHallway1);
        
        swTowerSec.setExit("up",swTowerTh);
        swTowerSec.setExit("down",swTowerBase);
        swTowerSec.setExit("north",sHallway3);
        swTowerSec.setExit("east",aChamber1);
        
        seTowerSec.setExit("up",seTowerTh);
        seTowerSec.setExit("down",seTowerBase);
        seTowerSec.setExit("north",sHallway4);
        seTowerSec.setExit("west",aChamber3);
        
        neTowerSec.setExit("up",neTowerTh);
        neTowerSec.setExit("down",neTowerSec);
        neTowerSec.setExit("south",sHallway6);
        
        //secondlevel hallways
        sHallway1.setExit("north",nwTowerSec);
        sHallway1.setExit("south",sHallway2);
        
        sHallway2.setExit("north",sHallway1);
        sHallway2.setExit("south",sHallway3);
        
        sHallway3.setExit("north",sHallway2);
        sHallway3.setExit("south",swTowerSec);
        sHallway3.setExit("east",aChamber4);
        
        sHallway4.setExit("north",sHallway5);
        sHallway4.setExit("south",seTowerSec);
        sHallway4.setExit("west",aChamber6);
        
        sHallway5.setExit("north",sHallway6);
        sHallway5.setExit("south",sHallway4);
        
        sHallway6.setExit("north",neTowerSec);
        sHallway6.setExit("south",sHallway5);
        
        //Antechamber exits
        aChamber1.setExit("west", swTowerSec);
        aChamber1.setExit("north", aChamber4);
        aChamber1.setExit("east", aChamber2);
        
        aChamber2.setExit("west", aChamber1);
        aChamber2.setExit("north", aChamber5);
        aChamber2.setExit("east", aChamber3);
        
        aChamber3.setExit("west", aChamber2);
        aChamber3.setExit("north", aChamber6);
        aChamber3.setExit("east", seTowerSec);
        
        aChamber4.setExit("west", sHallway3);
        aChamber4.setExit("south", aChamber1);
        aChamber4.setExit("east", aChamber5);
        
        aChamber5.setExit("west", aChamber4);
        aChamber5.setExit("north", tRoom2);
        aChamber5.setExit("east", aChamber6);
        aChamber5.setExit("south", aChamber2);
        
        aChamber6.setExit("west", aChamber5);
        aChamber6.setExit("east", sHallway4);
        aChamber6.setExit("south", aChamber3);
        
        //Throne room exits
        tRoom1.setExit("east",tRoom2);
        tRoom1.setExit("north",tRoom4);
        
        tRoom2.setExit("west",tRoom1);
        tRoom2.setExit("east",tRoom3);
        tRoom2.setExit("south",aChamber5);
        tRoom2.setExit("north",tRoom5);
        
        tRoom3.setExit("west",tRoom2);
        tRoom3.setExit("north",tRoom6);
        
        tRoom4.setExit("east",tRoom5);
        tRoom4.setExit("north",tRoom7);
        tRoom4.setExit("south",tRoom1);
        
        tRoom5.setExit("west",tRoom4);
        tRoom5.setExit("north",tRoom8);
        tRoom5.setExit("east",tRoom6);
        tRoom5.setExit("south",tRoom2);
        
        tRoom6.setExit("west",tRoom5);
        tRoom6.setExit("north",tRoom9);
        tRoom6.setExit("south",tRoom3);
        
        tRoom7.setExit("east",tRoom8);
        tRoom7.setExit("south",tRoom4);
        
        tRoom8.setExit("west",tRoom7);
        tRoom8.setExit("south",tRoom5);
        tRoom8.setExit("east",tRoom9);
        
        tRoom9.setExit("west",tRoom8);
        tRoom9.setExit("south",tRoom6);
        
        //Third level exits
        nwTowerTh.setExit("down",nwTowerSec);
        nwTowerTh.setExit("east",tHallway1);
        
        neTowerTh.setExit("down",neTowerSec);
        neTowerTh.setExit("west",tHallway3);
        
        swTowerTh.setExit("down",swTowerSec);
        swTowerTh.setExit("east",tHallway7);
        
        seTowerTh.setExit("down",seTowerSec);
        seTowerTh.setExit("west",tHallway9);
        
        //Third level hallways exits
        tHallway1.setExit("west",nwTowerTh);
        tHallway1.setExit("east",tHallway2);
        
        tHallway2.setExit("east",tHallway3);
        tHallway2.setExit("west",tHallway1);
        tHallway2.setExit("south",tHallway4);
        
        tHallway3.setExit("east",neTowerTh);
        tHallway3.setExit("west",tHallway2);
        
        tHallway4.setExit("east",bardBed);
        tHallway4.setExit("north",tHallway2);
        tHallway4.setExit("west",emptyBed);
        tHallway4.setExit("south",tHallway5);
        
        tHallway5.setExit("east",queenBed);
        tHallway5.setExit("north",tHallway4);
        tHallway5.setExit("west",kingBed);
        tHallway5.setExit("south",tHallway6);
        
        tHallway6.setExit("east",aelmonBed);
        tHallway6.setExit("north",tHallway5);
        tHallway6.setExit("west",jesterBed);
        tHallway6.setExit("south",tHallway8);
        
        tHallway8.setExit("east",tHallway9);
        tHallway8.setExit("north",tHallway6);
        tHallway8.setExit("west",tHallway7);
        tHallway8.setExit("up",fFloor);
        
        tHallway7.setExit("east",tHallway8);
        tHallway7.setExit("west",swTowerTh);
        
        tHallway9.setExit("east",seTowerTh);
        tHallway9.setExit("west",tHallway8);
        
        //Fourth floor
        fFloor.setExit("down",tHallway8);
        
        
        /**
         * Create and set items
         */
        Weapon sword = new Weapon("sword","A rusted sword",5,10,10,20);
        Shield shield = new Shield("shiels", "An old and rusted shield.", 2, 10, 5, 10);
        
        Map keepMap = new Map("keep map", "A map showing the keep of Midgaard.",1,1,"keepMap.gif");
        
        nGate.addItem(sword);
        nGate.addItem(keepMap);
        
        
        /**
         * Create and set NPCs, enemies and shops
         */
        Guard midgaardGuard = new Guard("guard","A guard of the keep of Midgaard.");
        Guard royalGuard = new Guard("royal guard","A member of the royal kingsguard, shining armor and deadly steel in hand protecting the royal family at all costs.");
        
        Goblin goblin = new Goblin("goblin", "A goblin", 10,15,2,100);
        
        TextNPC aelmon = new TextNPC("aelmon", "The maester of the keep, mastering the arts of healing.",sword, "These troublesome times makes everyone requiering a sword..","Why thank you ser, Did you know the king and queen doesnt share a bed?","Now what would i do with that?");
        
        Shop beggar = new Shop("Beggar", "A beggar selling his dead fathers shield.", 0); 
        beggar.addToShop(shield);
        
        nGate.addNPC(midgaardGuard);
        sGate.addNPC(midgaardGuard);
        eGate.addNPC(midgaardGuard);
        wGate.addNPC(midgaardGuard);
        
        eGate.addEnemy(goblin);
        
        wGate.setShop(beggar);
        
        tRoom1.addNPC(royalGuard);
        tRoom2.addNPC(royalGuard);
        tRoom3.addNPC(royalGuard);
        tRoom4.addNPC(royalGuard);
        tRoom5.addNPC(royalGuard);
        tRoom6.addNPC(royalGuard);
        tRoom7.addNPC(royalGuard);
        tRoom8.addNPC(royalGuard);
        tRoom9.addNPC(royalGuard);
        
        aelmonBed.addNPC(aelmon);
        
        fFloor.addEnemy(goblin);
        
        /**
         * set starting point
         */
        currentRoom = nGate;
    }
}
