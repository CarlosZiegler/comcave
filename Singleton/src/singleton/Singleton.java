package singleton;
/*
 * 	Das Entwurfsmuster Singleton:
 * 
 * 
 * 		-> Das Problem:
 * 	
 * 			- Wie designe ich eine Klasse, von der später nur ein einziges Objekt im Speicher existieren kann?
 * 
 * 		-> Ziel:
 * 	
 * 			- Schaffung von zentralen (Verwaltungs-)Objekten, welche einmalig im Speicher existieren
 * 		
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class Singleton 
{
	//hier wird das einzige verfügbare Singleton-Objekt als Klassenattribut gespeichert:
	private static Singleton singleton;
	private String name;
	
	//Um zu verhindern, dass von aussen weitere Singltonobjekte erzeugt werden, ist der Konstruktor private!
	private Singleton() { }

		
	//Öffentliche Methode, welche den Zugriff auf das einzige Singleton-Objekt erlaubt:
	public static Singleton getSingleton() 
	{
		//um nicht bei jedem Zugriff ein neues Objekt zu erzeugen, wird singleton nur beim ersten Aufruf initialisiert:
		if(singleton==null)
		{
			singleton=new Singleton();
		}
		return singleton;
	}
	
	//dienste:
	//....
	
	
	
	
}
