package inheritance;
/*
 * 	Das �berladen von Methoden:
 * 
 * 		-> �berladene Methoden sind Methoden mit gleichem Namen aber unterschiedlichen Parameterlisten
 * 
 * 		-> Ziel: Flexibilisierung der Funktionalit�t
 * 
 * 		-> Regeln:
 * 
 * 			- Methode MUSS denselben Namen haben
 * 			- Parameterliste muss sich von den anderen unterscheiden(Anzahl und/oder Typ der Parameter)
 * 			- R�ckgabetyp kann sich unterscheiden, muss aber nicht
 * 			- Sichtbarkeit kann sich unterscheiden, muss aber nicht
 * 			- Man kann auch in Unterklassen �berladen
 * 
 * 		---------------------------------------------------------------------------------------------------
 * 
 * 	�berschreiben von Methoden:
 * 
 * 		-> Eine Methode in einer Unterklasse, welche eine geerbte Methode spezialisiert
 * 
 * 		-> Ziel: Das Spezialisieren von Methoden
 * 
 * 		-> Regeln:
 * 
 * 			- Name muss identisch sein
 * 			- Parameterliste muss bezogen auf Anzahl und Typen absolut �bereinstimmen
 * 			- Sichtbarkeit darf beim �berschreiben nicht eingeengt werden!(Sie darf aber erweitert werden)
 * 			- Alles was nicht sichtbar ist, kann auch nicht �berschrieben werden
 * 			- static-Methoden kann man nicht �berschreiben
 * 			- final-Methoden k�nnen per Definition nicht �berschrieben werden
 * 			- Der R�ckgabetyp: Muss kovariant sein, falls er sich �ndert, ansonsten identisch
 * 
 * 
 * 
 * 
 * ------------------------------------------------------------------------------------------------------------
 * 
 * 	Invarianz:
 * 		
 * 		-> Man muss auf der selben Vererbungsebene bleiben
 * 
 * 
 * 	Kovarianz:
 * 
 * 		-> Man darf sich in Richtung Spezialiserung bewegen(Von Superklasse nach Unterklasse(n))
 * 
 * 
 * 	Kontravarianz:
 * 
 * 		-> Man darf sich in Richtung Generalisierung bewegen 
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
public class Lebewesen 
{
	private int alter;
	private String bezeichnung;
	private String name;
	private double gewicht;
	private double lebensErwartung;
	
	
	
	
	public Lebewesen(String bezeichnung)
	{
		this.bezeichnung=bezeichnung;
	}
	
	
	
	
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGewicht() {
		return gewicht;
	}
	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}
	public double getLebensErwartung() {
		return lebensErwartung;
	}
	public void setLebensErwartung(double lebensErwartung) {
		this.lebensErwartung = lebensErwartung;
	}
	
	
	public void bewegen()
	{
		
	}
	
	public int bewegen(int geschwindigkeit)
	{
		return 0;
	}
	
	public int bewegen(double geschw)
	{
		return 0;
	}
	
	private void bewegen(int geschwindigkeit, String start, String ziel)
	{
		
	}
	
	public Lebewesen gebaeren()
	{
		return new Lebewesen(null);
	}
	
	public void atmen()
	{
		System.out.println("Ich atme wie ein Lebewesen...");
	}
	
	
	
}
