package immutable;

/*
 * 	Das Entwurfsmuster Immutable:
 * 
 * 		-> Problem:
 * 
 * 			-> Wie schaffe ich eine Klasse, deren Objekte nach der Objekterzeugung nicht mehr ver�nderbar sind?
 * 				-> Mit anderen Worten: Wenn das Objekt einmal auf dem Heap ist, lassen sich die Attribut-Werte nicht mehr �ndern
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


//Eine Immutable-Klasse ist letztlich auch immer final!
public final class Immutable 
{
	//alle attribute sind private
	private int zahl;
	private char[] zeichenkette;
	private String name;

	
	
	//�berall dort, wo an das Immutable die in dem Objekt zu speichernden Daten �bergeben werden, M�SSEN DIESE KOPIERT WERDEN,
	//wenn es sich um Referenzen/Komplexe Typen (Es sei denn, diese sind selbst auch immutable -> String, Wrapper...) handelt
	public Immutable(char[] zeichenkette) {
		super();
		this.zeichenkette = zeichenkette.clone();
	}

	public Immutable(int zahl) {
		super();
		this.zahl = zahl;
	}

	public Immutable(int zahl, char[] zeichenkette) {
		super();
		this.zahl = zahl;
		this.zeichenkette = zeichenkette.clone();
	}

	//Ein Immutable bietet idealerweise NUR getter und KEINE setter an!
	
	public int getZahl() 
	{
		return zahl;
	}
	
	
	//Alle Getter, welche eine Referenz liefern, sollten das dahinter steckende Objekt vor der R�ckgabe ebenfalls kopieren!!
	public char[] getZeichenkette() 
	{
		return zeichenkette.clone();
	}
	
	
	
	
	
	
	
}
