import java.io.*;

public class Save implements Serializable {
   
    
    public static void main(String[] args) {
        
    }
    
    public void save(GameEngine ge, String fn) {
        try
        {
            FileOutputStream fo = new FileOutputStream(fn +".ser");
            ObjectOutputStream os = new ObjectOutputStream(fo);
            
            os.writeObject(ge);
            os.close();
            fo.close();
        }
        catch(IOException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public GameEngine load(String fn) {
        GameEngine ge = null;
        try
        {
            FileInputStream fi = new FileInputStream(fn);
            ObjectInputStream is = new ObjectInputStream(fi);
            
            ge = (GameEngine)is.readObject();
            is.close();
            fi.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch (ClassNotFoundException c) 
        {
            c.printStackTrace();
            return null;
        }
        return ge;
    }
}