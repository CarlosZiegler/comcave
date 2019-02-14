import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Map extends CarryableItem implements Serializable{
    
    private JFrame frame;
    private String imgName;
        
    public Map(String name, String description, int weight, int value, String imgName) {
        super(name,description,weight, value);
        this.imgName = imgName;
    }
    
    public String print() {
        return super.getDescription();
    }
    
    public String use(Room currentRoom) {
        
        frame = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/6-frame.getSize().width/4, dim.height/4-frame.getSize().height/4);
        
        ImageIcon mapImage = new ImageIcon(imgName);
        Image img = mapImage.getImage();
        img = img.getScaledInstance(500, -1, img.SCALE_SMOOTH);
        mapImage.setImage(img);
        
        JLabel map = new JLabel(mapImage);
        
        frame.getContentPane().add(map);
        
        
        frame.setSize(500,400);
        frame.setVisible(true);
        return "You study the " + super.getName() + ".";
    }
}



