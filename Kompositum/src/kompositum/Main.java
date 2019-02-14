package kompositum;
/*
 * 	DAS ENTWURFSMUSTER KOMPOSITUM / COMPOSITE:
 * 
 * 
 * 		-> Das Problem: 
 * 
 * 			-> Schaffung von hierarchisch verschachtelt-strukturierten Baumstrukturen mit OOP-Mitteln
 * 
 * 
 * 		-> Die Lösung:
 * 
 * 			- Eine abstrakte Superklasse(oft "Komponente") ist dafür da, damit die Grundeigenschaften aller Komponenten der
 * 		      Baumstruktur gesetzt werden und damit Containerklassen/Leafklassen diese erweitern können
 * 
 * 			- Containerklassen erweitern Komponente und können in sich sowohl Container als auch Leafs speichern
 * 
 * 			- Leafs erben ebenfalls von Komponente und beinhalten die entsprechenden Eigenschaften und Fähigkeiten
 * 
 * 		-> Alternativ kann zudem die Superklassen Komponente eine Schnittstelle(Interface) anbieten, damit von aussen einheitlich 
 * 			über die Baumstruktur operiert werden kann....
 * 
 * 
 * 		-> Das Durchlaufen einer reinen Kompositum-Struktur erfolgt normalerweise rekursiv!
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
public class Main {

	public static void main(String[] args) 
	{
		Verzeichnis root=new Verzeichnis("root");
		Verzeichnis home=new Verzeichnis("home");
		Verzeichnis dokumente=new Verzeichnis("Dokumente");
		
		root.addElement(home);
		home.addElement(dokumente);
		
		Datei bewerbung=new Datei("bewerbung.doc");
		Datei virus=new Datei("Liebesbrief.exe");
		
		dokumente.addElement(bewerbung);
		dokumente.addElement(virus);
		
		
		System.out.println(bewerbung.getParent());
		
		
		
		
		
		

	}

}
