import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {

		Held held = new Held("Chuck Norris", 1000);
		held.setAlter(34);
		held.setLebensEnergie(444);

		// serialieserung

		try (FileOutputStream fo = new FileOutputStream("held.ser");
				ObjectOutputStream ou = new ObjectOutputStream(fo)) {

			ou.writeObject(held);

		} catch (IOException e) {
			System.out.println("Fehle beim Speichern " + e.getMessage());
		}

		
		
		//de-sereiliarising
		
		try(FileInputStream fi = new FileInputStream("held.ser"); ObjectInputStream oi = new ObjectInputStream(fi)) {
			
			Held heldLoaded = (Held)oi.readObject();
			System.out.println( "Held: " + heldLoaded.getName()+ " Alter: " + heldLoaded.getAlter());
			
		} catch (IOException e) {
			System.out.println("Fehler des" + e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Nicht gefunden" + e.getMessage());
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
