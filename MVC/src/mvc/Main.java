package mvc;
/*
 * 	MVC (Model View Controller)
 * 
 * 	-> Aufsplittung der Anwendung in 3 logische Anteile: 
 * 
 * 		-> In einen Anteil, den man View nennt, kommt der gesamte Code, welcher
 * 		   f�r die Darstellung und Erzeugung der GUI zust�ndig ist
 * 
 * 		-> Die Gesch�ftslogik wird unabh�ngig vom GUI-Anteil in ein Model
 * 		   verschoben
 * 
 * 		-> Ein Anteil, den man Controller nennt, vermittelt zwischen Model und
 * 		   View in beide Richtungen
 * 
 * 		-> Dabei kennt View den Controller, Model kennt Controller und Controller
 * 		   ist die einzige Instanz, die beide kennt
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
 * 
 * 
 * 
 * 
 */




public class Main 
{

	public static void main(String[] args)
	{
		new Controller();
	}
	
	
	
	
	
	
	
}
