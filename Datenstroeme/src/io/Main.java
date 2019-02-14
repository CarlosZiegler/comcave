package io;

import java.io.*;


/*
 * 	Was bezeichnet man in der Informatik als einen Stream/Datenstrom?
 * 
 * 		-> Ein Datenstrom ist eine sequentielle Versendung von aufbearbeiteten Daten von einer Quelle
 * 		   zu einer Senke(Es gibt in der I/O-Welt keinen wahlfreien Zugriff)
 * 
 * 		-> Typisch f�r Streams: Die Senke kann niemals das Ende des Streams voraussehen
 * 
 *      -> Den Vorgang dieser Datenaufbearbeitung f�r einen Stream nennt man "Serialisierung"
 * 
 * 		-> I/O-Streams sollten nach ihrer Benutzung IMMER geschlossen werden(Closeble -> close() )
 * 
 * 		-> In Java gibt es zwei Gruppen von Streamklassen:
 * 
 * 			-> Byteorientierte Klassen
 * 
 * 				-> Klassennamen enden immer mit "Stream"
 * 
 * 				-> Die lesenden Klassen haben im Namen das Pr�fix "Input"
 * 
 * 				-> Die schreibenden haben das Pr�fix "Output"				
 * 
 * 
 * 
 * 
 * 
 * 			-> Characterorientierte Klassen
 * 
 * 				-> Klassenname enden mit "Reader" bzw. "Writer"
 * 
 * 
 * 			-> Wie arbeitet man grunds�tzlich mit Streams?
 * 
 * 				1. Stream �ffen -> Instanzen von Streamklassen erzeugen
 * 				2. Lesen/Schreiben per Methode(n) dieser Streamklassen, solange Daten vorhanden -> Schleife
 * 				3. Ge�ffnete Streams nach Nutzung wieder schliessen -> close()
 * 
 * 			-> System.in -> Ein InputStream f�r das byteweise Lesen von der Tastatur(Standard-Input-Stream)
 * 
 * 	-> Einige wichtige Streamklasse aus java.io :
 * 
 * 		InputStreamReader   -> Die Basisklasse f�r alle Reader, welche byte>character k�nnen
 * 
 * 		FileReader          -> Lesen aus Dateien
 * 
 * 		FilterReader		-> Filtern(z.B. mit RegEx)
 * 
 * 		BufferedReader		-> Pufferung von Eingabestreams, Kann ganze Zeilen lesen/verstehen
 * 
 * 		File				-> Bietet eine abstrakte Sicht auf das Dateisystem des OS
 * 
 * 
 * 
 * 
 * 
 */
public class Main 
{

	public static void main(String[] args) 
	{
		
		//Die Klasse File:
		//Liefert viele wertvolle Metainfos zu den Dateien/Verzeichnissen, speichert Pfade
		
		
		File datei=new File("docs/fragen.txt");
		
		//Die Klasse FileReader
		//Kann einzelne Zeichen eines Bytestreams zu einer Datei lesen
		int zeichen;
		FileReader fr=null;
		try
		{
			fr=new FileReader(datei);
			while(((zeichen=fr.read())!=-1))
			{
				System.out.print((char)zeichen);

			}
		}
		catch(IOException e)
		{
			System.out.println("Fehler beim Lesen der Date! -> " + e.getMessage());
		}
		finally
		{
			if(fr!=null)
			{
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		//frage lesen
		try {
			leseFrage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	//Der BufferedReader
	public static void leseFrage() throws IOException
	{
		String zeile;
		BufferedReader buff=null;
		try
		{
			buff=new BufferedReader(new FileReader("docs/fragen.txt"));
			while((zeile=buff.readLine())!=null)
			{
				
				String[] frageZeile=zeile.split(";");
				System.out.println("Frage Nr. " + frageZeile[0]);
				System.out.println(frageZeile[1]);
				System.out.println("A: " + frageZeile[2]);
				System.out.println("B: " + frageZeile[3]);
				System.out.println("C: " + frageZeile[4]);
				System.out.println("D: " + frageZeile[5]);
			}
			
		}
		catch(IOException e)
		{
			System.out.println("Fehler beim Lesen der Fragen!" + e.getMessage());
		}
		finally
		{
			if(buff!=null)
				buff.close();
		}
	
	}
	
	//try-with-ressource-statement: alle ressourcenklassen, welche das interface AutoCloseable implementieren,
	//k�nnen in diesem statement genutzt werden!
	public static void leseFrageMitStatement()
	{
		String zeile;
		//alle in den runden klammern ge�ffneten ressourcen werden kurz vor beenden des try wieder geschlossen
		try(BufferedReader buff=new BufferedReader(new FileReader("docs/fragen.txt")))
		{
			zeile=buff.readLine();
			String[] frageZeile=zeile.split(";");
			
		}
		catch(IOException e)
		{
			System.out.println("Fehler beim Lesen der n�chsten Frage! " + e.getMessage());
			Throwable[] unterdrueckteAusnahmen=e.getSuppressed();
		}
		
		
		/*
		 * 	1. Kurz bevor der try-Block verlassen wird, werden alle reservierten Ressourcen per close()
		 * 	   geschlossen
		 * 
		 * 	2. Man kann im try-with mit Semikoli getrennt beliebig viele Ressource �ffnen
		 * 
		 *  3. Wenn im try eine Ausnahme auftritt, dann werden, kurz bevor der try verlassen wird, alle
		 *     Ressourcen automatisch geschlossen
		 *     
		 *  4. Wenn im try mehrere Ausnahmen auftreten(beim Lesen und dann beim anschliessenden close()), dann
		 *     wird immer die ZUERST ausgel�ste Ausnahme behandelt/weitergereicht
		 *     
		 *     		-> Alle anderen ausgel�sten Ausnahmen werden "unterdr�ckt" und man kann im catch per
		 *             getSuppressed() auf diese wieder zugreifen
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
	}
	
	
	
	

}
