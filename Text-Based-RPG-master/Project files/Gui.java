import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Document;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import java.io.*;

public class Gui implements Serializable{
    
    private JFrame frame;
    private JTextPane output;
    private JTextField input;
    private JTextArea stats;
    private GameEngine game;
    private Parser parser;
    private Save save;
    //private Client chatClient;
    
    
    public Gui() {
        makeFrame();
        save = new Save();
    }
    
    public void setGame(GameEngine game) {
        this.game = game;
    }
    
    public GameEngine getGame() {
        return game;
    }
    
    public void setParser(Parser parser) {
        this.parser = parser;
    }
    
    public Parser getParser() {
        return parser;
    }
    
    /**
     * makeFrame, Creates a gui with textarea for output and textfield for input, SWING
     */
     private void makeFrame() {
        frame = new JFrame("World of Zuul");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/4-frame.getSize().width/4, dim.height/4-frame.getSize().height/4);
        
        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());
        
        
        output = new JTextPane();
        output.setEditable(false);
        output.setOpaque(true);
        output.setBackground(Color.black);
        output.setBorder(BorderFactory.createEmptyBorder(5,5,10,10));
        output.setFont(new Font("monospaced", Font.BOLD, 12));
        
        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setPreferredSize(new Dimension(600,400));
        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setPreferredSize( new Dimension(0,0));
        
        ImageIcon image = new ImageIcon("goblin.jpg");
        Image img = image.getImage();
        img = img.getScaledInstance(150, -1, img.SCALE_SMOOTH);
        image.setImage(img);
        
        JLabel gameMap = new JLabel(image);
        gameMap.setOpaque(true);
        gameMap.setBackground(Color.black);
        gameMap.setForeground(Color.white);
        
        JLabel westLabel = new JLabel(image);
        westLabel.setOpaque(true);
        westLabel.setBackground(Color.black);
        
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BorderLayout());
        eastPanel.add(BorderLayout.CENTER, gameMap);
        
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BorderLayout());
        westPanel.add(BorderLayout.CENTER, westLabel);
        
        input = new JTextField();
        input.setBorder(BorderFactory.createLineBorder(Color.black));
        input.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        input.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String i = input.getText();
                styleRed(">");
                styleRed(i);
                parser.sendInput(i);
                input.setText("");
                input.requestFocus();
                
                //scrolling
                output.setCaretPosition(output.getDocument().getLength());
                
                Command command = parser.getCommand();
                game.processCommand(command);
                
            }
        });
        
        frame.getContentPane().add(BorderLayout.EAST, eastPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, input);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.getContentPane().add(BorderLayout.WEST, westPanel);
        
        setMenuBar(frame);
        
        frame.setSize(1000,700);
        frame.setVisible(true);
        
        //chatClient = new Client();
        //chatClient.go();
    }
    
    /**
     * creates menu
     */
    private void setMenuBar(JFrame frame) {
    
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem play = new JMenuItem("Play");
        play.setToolTipText("Start a game.");
        play.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, SHORTCUT_MASK));
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.requestFocus();
                game.play();
            }
        });
        JMenuItem quit = new JMenuItem("Quit");
        quit.setToolTipText("Quit game.");
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenuItem save = new JMenuItem("Save");
        save.setToolTipText("Save the game.");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, SHORTCUT_MASK));
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    JFileChooser filechooser = new JFileChooser();
                    if(filechooser.showSaveDialog(null) == 
                    JFileChooser.APPROVE_OPTION) {
                        File f = filechooser.getSelectedFile();
            
                        String filename = f.getPath();
                        Save savep = new Save();
                        savep.save(game,filename);
                        
                        styleWhite("");
                        styleYellow
                        ("This file was chosen for saving: " + f);
                        styleWhite("");
                        
                        File file = filechooser.getSelectedFile();
                        
                        String nameWithoutExtension = f.getName();
                        int pos = nameWithoutExtension.lastIndexOf(".");
                        if (pos > 0) {
                            nameWithoutExtension = nameWithoutExtension.substring(0, pos);
                        }
                        try {
                            FileWriter writer = new FileWriter(nameWithoutExtension + ".txt", true);
                            writer.write(output.getText());
                            writer.close();
                        } catch(IOException ex) {
                            ex.printStackTrace();
                        }
                        
                    } else {
                        styleWhite("");
                        styleYellow
                        ("No file was chosen or an error occurred");
                        styleWhite("");
                    };
            }
        });
        
        JMenuItem load = new JMenuItem("Load");
        load.setToolTipText("Loads a saved game.");
        load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, SHORTCUT_MASK));
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser filechooser = new JFileChooser();
                if(filechooser.showOpenDialog(null) == 
                JFileChooser.APPROVE_OPTION) {
                    File f = filechooser.getSelectedFile();
         
                    String filePath = f.getPath();
                    Save savep = new Save();
                    game = savep.load(filePath);
                    parser = game.getParser();
                    game.getGui().makeFrame();
                    game.getGui().styleYellow("Successfully loaded: " + f);
                    game.getGui().styleWhite("");
                    
                    
                    try {
                        String filename = f.getName();
                        
                        int pos = filename.lastIndexOf(".");
                        if (pos > 0) {
                            filename = filename.substring(0, pos);
                        }
                        
                        File myFile = new File(filename + ".txt");
                        FileReader fileReader = new FileReader(myFile);
                        BufferedReader reader = new BufferedReader(fileReader);
                        
                        String line = null;
                        
                        while((line = reader.readLine()) != null) {
                            game.getGui().styleWhite(line);
                        }
                        reader.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    
                    
                    game.getGui().styleWhite(game.getCR().getLongDescription());
                } else {
                    styleWhite("");
                    styleYellow
                    ("No file was chosen or an error occured");
                    styleWhite("");
                };
            }
        });
        
        JMenuItem clear = new JMenuItem("Clear");
        clear.setToolTipText("Clear the text on screen.");
        clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, SHORTCUT_MASK));
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("");
            }
        });
        
        JMenuItem story = new JMenuItem("Print story");
        story.setToolTipText("Print your story to a document.");
        story.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, SHORTCUT_MASK));
        story.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser filechooser = new JFileChooser();
                if(filechooser.showSaveDialog(null) == 
                JFileChooser.APPROVE_OPTION) {
                    File f = filechooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(f, true);
                        writer.write(output.getText());
                        writer.close();
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    styleWhite("");
                    styleYellow
                    ("No file was chosen or an error occurred");
                    styleWhite("");
                };
            }
        });
        
        menuBar.add(fileMenu);
        fileMenu.add(play);
        fileMenu.add(clear);
        fileMenu.add(story);
        fileMenu.add(save);
        fileMenu.add(load);
        fileMenu.add(quit);
        frame.setJMenuBar(menuBar);
    }

    public void clear() {
        output.setText("");
    }
    
    public void styleRed(String msg) {
        Style style = output.addStyle("inputStyle", null);
        StyleConstants.setForeground(style, Color.red);
        
        try {
            StyledDocument doc = (StyledDocument) output.getDocument();
            doc.insertString(doc.getLength(), msg + "\n", style);
        }
        catch (BadLocationException e) {
        }
    }
    
    public void styleWhite(String msg) {
        Style style = output.addStyle("Test", null);
        StyleConstants.setForeground(style, Color.white);
        SimpleAttributeSet left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
        
        try {
            String p = msg;
            StyledDocument doc = (StyledDocument) output.getDocument();
            doc.setParagraphAttributes(0,msg.length(),left,false);
            doc.insertString(doc.getLength(), msg + "\n", style);
        }
        catch (BadLocationException e) {
        }
    }
    
    public void styleYellow(String msg) {
        Style style = output.addStyle("inputStyle", null);
        StyleConstants.setForeground(style, Color.yellow);
        SimpleAttributeSet sa = new SimpleAttributeSet();
        StyleConstants.setAlignment(sa, StyleConstants.ALIGN_CENTER);
        
        try {
            StyledDocument doc = (StyledDocument) output.getDocument();
            doc.setParagraphAttributes(0,doc.getLength(),sa,false);
            doc.insertString(doc.getLength(), msg + "\n", style);
            
        }
        catch (BadLocationException e) {
        }
    }
}
        

