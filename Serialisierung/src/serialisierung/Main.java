package serialisierung;

import java.io.*;

/*
 * 	Serialisierung in Java ermöglicht das Speichern von Objekten(Objektzuständen) in Dateien
 * 
 * 		-> Was wird gespeichert?
 * 
 * 			- Metadaten zum Objekt(implizite)
 * 
 * 			- Die Attributwerte eines Objektes
 * 
 * 		-> Was kann man nicht speichern?
 * 
 * 			- I/O-Streams
 * 
 * 			- Alles was static ist
 * 
 * 			- Alles was mit dem Schlüsselwort "transient" versehen ist
 * 
 * 		-> Für diesen Mechanismus stellt Java die beiden Klassen "ObjectOutputStream" und "ObjektInputStream"
 * 		   bereit
 * 
 * 				-> Mit den Methoden writeObject() bzw. readObject() wird der Mechanismus eingeleitet
 * 
 * 		-> Was passiert im Hintergrund beim De-Serialisieren?
 * 
 * 			1. Ein Objekt des entsprechenden Typs wird angelegt -> Konstruktoren!!!
 * 				
 * 			2. Die Attribute erhalten Defaultwerte(nicht die aus den Konstruktoren!!)
 * 
 * 			3. Die Attribute werden mit den Werten aus der Ser-Datei versehen
 * 
 * 
 * 
 * 
 * 		-> Alle Objekte, welche serialisiert werden sollen, müssen auf Klassen beruhen, welche das Interface
 * 		   Serializable implementiert haben!
 * 				-> Laufzeitfehler!!
 * 
 * 
 * 		-> Auch Unterobjekte werden automatisch mit serialisiert! -> Diese Objekte müssen auch Serializable 
 * 			sein!
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		Held held=new Held("Chuck Norris", 1000);
		held.setAlter(34);
		held.setLebensEnergie(444);
		
		//serialisieren:
		//den helden mit aktuellen werten speichern
		try(FileOutputStream fo=new FileOutputStream("held.ser");ObjectOutputStream ou=new ObjectOutputStream(fo))
		{
			ou.writeObject(held);
		}
		catch(IOException e)
		{
			System.out.println("Fehler beim Speichern des Helden! " + e.getMessage());
		}
		
		//de-serialisieren:
		//helden wieder so wie er war, laden
		
		try(FileInputStream fi=new FileInputStream("held.ser");ObjectInputStream oi=new ObjectInputStream(fi))
		{
			Held heldLoaded=(Held)oi.readObject();
			System.out.println("Held " + heldLoaded.getName() + " Alter: " + heldLoaded.getAlter() + 
					" Lebensenergie: " + heldLoaded.getLebensEnergie());
			
			held=heldLoaded;
			
		}
		catch(IOException e)
		{
			System.out.println("Fehler beim Laden des Helden " + e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Die zum Ladenden Objekt gehörende Klasse kann nicht gefunden werden! ");
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
