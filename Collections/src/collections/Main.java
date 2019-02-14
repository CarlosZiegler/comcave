package collections;
import java.util.*;
/*
 * 	COLLECTIONS:
 * 
 * 		-> Repr�sentieren Objektsammlungen
 * 		-> Speichern NUR Verweise auf Objekte(KEINE primitiven Werte!)
 * 		-> Collections speichern alle Objekte in Form des Typen Object -> Upcast nach Object
 * 
 * 			-> Typen von Collections:
 * 
 * 				- Collections vom Typ List
 * 				- Collections vom Typ Set
 * 				- Collections vom Typ Map
 * 				- Collections vom Typ Queue
 * 	
 * 		-> Collections verwalten ihre Objektsammlungen implizit und dynamisch
 * 		-> Bieten eine Reihe von sehr bequemen Methoden an, welche sich auf die Sammlung beziehen
 * 
 * 		-> Collections befinden sich im package java.util
 * 
 * 		-> Das Collection-Framwork wurde �berarbeitet und es gibt "alte" und "moderne" Collectionsklassen
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
@SuppressWarnings("all")
public class Main {

	
	public static void main(String[] args) 
	{
		/*	Collections vom Typ List
		 * 		
		 * 		-> Implementieren alle das Interface "List"
		 * 		-> Eine Liste besteht aus aneinandergeh�ngten Elementen(doppelt/einfach verkettet)
		 * 		-> Wachsen/schrumpfen dynamisch
		 * 		-> Bieten einen Iterator an
		 * 		-> Alle Listen indizieren ihre Elemente -> Wahlfreier Zugriff m�glich(per Index)
		 * 		-> Wenn Elemente "in der Mitte" gel�scht/eingef�gt werden, r�cken die anderen automatisch auf
		 * 		-> Das "normale" Hinzuf�gen per add() f�gt neue Elemente immer einfach hinten hinzu(am Ende)
		 * 		-> Einf�gereihenfolge = Ausgabereihenfolge !
		 */
		
		//"alte" List-Klasse Vector -> die alten Klassen sollte man nicht mehr nutzen(NICHT deprecated)
		Vector v=new Vector();
		
		//"moderne" List-Klassen:
		ArrayList arrLi=new ArrayList();
		Auto karre=new Auto();
		Auto audi=new Auto();
		arrLi.add(karre); //-> Auto erf�hrt hier einen impliziten UPCAST nach Object!!!!
		arrLi.add(audi);
		String text=new String("Text");
		arrLi.add(text);
		arrLi.add(karre);
		
		//holen der karre per index:
		Object temp=arrLi.get(2);
		if(temp instanceof Auto)
		{
			Auto a=(Auto)temp;
		}
		
		//durchlaufen der ganzen liste per iterator
		Iterator it=arrLi.iterator();
		while(it.hasNext())
		{
			Object o=it.next();
			//arrLi.remove(o); -> verboten!
			it.remove(); //WENN beim Iterieren gel�scht werden sollte, dann NUR mit der remove() des Iterators!!!!
			
		}
		
		//durchlaufen der liste per index und z�hlschleife:
		for(int i=0;i<arrLi.size();i++)
		{
			arrLi.get(i);
		}
		
		//for-each, "erweiterte for-schleife"
		for(Object o : arrLi)
		{
			
		}
		//LinkedList ist auch eine Collection vom Typ List, welche implizit alle Elemente auf doppelt
		//verketteten Nodes speichert
		LinkedList lili=new LinkedList();
		
		/*	COLLECTIONS vom Typ SET
		 * 
		 * 		-> Ein Set erlaubt keine doppelten Eintr�ge!
		 * 		-> Wenn jemand also versucht, ein bereits auf dem Set vorhandenes Objekt nochmal dort zu
		 * 		   speichern, wird das Set dieses Speichern verweigern !
		 * 		-> F�r die Funktionsf�higkeit eines Set werden grunds�tzlich Hashfunktionen/Hashwerte benutzt
		 * 
		 */
		
		// -> Wann sind zwei Objekte gleich?
		
		karre.setPs(100);
		karre.setTyp("Jeep");
		audi.setPs(100);
		audi.setTyp("Jeep");
		System.out.println(karre);
		System.out.println(audi);
		
		
		boolean gleich=karre.equals(audi);
		if(gleich)
		{
			System.out.println("audi und karre sind gleich");
		}
		else
		{
			System.out.println("audi und karre sind ungleich");
		}
		
		
		
		HashSet setti=new HashSet();
		setti.add(karre);
		if(setti.add(audi))
		{
			System.out.println("Einf�gen von audi hat geklappt");
		}
		else
		{
			System.out.println("audi wurde nicht vom Set aufgenommen...");
		}
		
		//LinkedHashSet garantiert, im Gegensatz zum HashSet die Einf�gereihenfolge
		
		/*
		 * 	Sortieren von Objekten in Collections
		 * 	
		 * 		-> Wie sortiere ein Objekte auf einer Liste?
		 * 			
		 * 			-> Die Untilityklasse Collections bietet zwei sort-Methoden an
		 * 
		 * 		-> Wie sortiere ich ein Set bzw. eine Map?
		 * 
		 * 			-> Daf�r gibt es die Tree-Klassen(TreeMap, TreeSet)
		 * 				-> Diese beiden Klassen sortieren implizit
		 * 
		 * 
		 * 
		 */
		
		//Brot-Objekte erzeugen
		ArrayList brotListe=new ArrayList();
		Brot toast=new Brot("Toast", 20);
		Brot pumpernickel=new Brot("Pumpernickel", 1200);
		Brot weizen=new Brot("Weizen", 500);
		Brot dinkel=new Brot("Dinkel", 300);
		Brot roggen=new Brot("Roggen", 700);
		
		brotListe.add(toast);
		brotListe.add(pumpernickel);
		brotListe.add(weizen);
		brotListe.add(dinkel);
		brotListe.add(roggen);
		
		System.out.println("Erste unsortierte Ausgabe der Brote: ");
		
		for(Object o : brotListe)
		{
			Brot tempBrot=(Brot)o;
			System.out.println(tempBrot.getName() + ", " + tempBrot.getGewichtInGramm() + " g.");
		}
		
		//Brote mit der sort-Methode der Klasse Collections sortieren:
		Collections.sort(brotListe);
		
		System.out.println("--------------------------------------");
		for(Object o : brotListe)
		{
			Brot tempBrot=(Brot)o;
			System.out.println(tempBrot.getName() + ", " + tempBrot.getGewichtInGramm() + " g.");
		}
		
		//sortieren per TreeSet:
		TreeSet tSet=new TreeSet();
		tSet.add(toast);
		tSet.add(pumpernickel);
		tSet.add(weizen);
		tSet.add(dinkel);
		tSet.add(roggen);
		
		System.out.println("--------------------------------------");
		//�ber das treeset iterieren:
		Iterator its=tSet.iterator();
		while(its.hasNext())
		{
			Brot tempBrot=(Brot)its.next();
			System.out.println(tempBrot.getName() + ", " + tempBrot.getGewichtInGramm() + " g.");
		}
		
		//Sortieren der Brote per "externem Sortierer" -> Comparator:
		Collections.sort(brotListe, new BrotSortierer());
		System.out.println("--------------------------------------");
		for(Object o : brotListe)
		{
			//in dieser for-each-schleife referenziert die variable o nacheinander die brot-objekte,
			//welche nach einem downcast ausgegeben werden:
			System.out.println(((Brot)o).getName() + ", " + ((Brot)o).getGewichtInGramm() + " g.");
		}
		
		
		//dieses treeset sortiert so, wie es im externen sortierer per compare() beschrieben wurde:
		TreeSet tSetComp=new TreeSet(new BrotSortierer());
		
		//brotliste per anonymer klasse absteigend nach gewicht sortieren:
		Collections.sort(brotListe, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if(((Brot)o1).getGewichtInGramm()>((Brot)o2).getGewichtInGramm())
				{
					return -1;
				}
				else if(((Brot)o1).getGewichtInGramm()<((Brot)o2).getGewichtInGramm())
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
		});
		
		/*  COLLECTIONS vom Typ Map:
		 * 
		 * 		-> Basieren auf dem Interface Map
		 * 		-> Repr�sentieren Schl�ssel-Wert-Paare
		 * 		-> Schl�ssel d�rfen nur einmal vorkommen
		 * 		-> Mit jedem Schl�ssel wird ein Objekt(oder null) assoziiert
		 * 		-> Arbeitet mit Hashwerten! -> equals und hashCode!!!!
		 * 
		 * 
		 * 
		 */
		HashMap map=new HashMap();
		Mitarbeiter mueller=new Mitarbeiter();
		Mitarbeiter schuster=new Mitarbeiter();
		
		map.put(mueller, new Abteilung("edv"));
		map.put(schuster, new Abteilung("faktura"));
		
		map.put(mueller, new Abteilung("buchhaltung"));
		
		//in welcher abteilung arbeitet der m�ller?
		Abteilung abteilungVomMueller=(Abteilung)map.get(mueller);
		
		
		//�ber eine map iterieren:
		
		//1. iterieren �ber alle schl�ssel der map:
		Iterator keysIt=map.keySet().iterator();
		while(keysIt.hasNext())
		{
			keysIt.next();
		}
		
		//2. iterieren �ber alle values der map:
		Iterator valuesIt=map.values().iterator();
		while(valuesIt.hasNext())
		{
			valuesIt.next();
		}
		
		//3. iterieren �ber gesamte schl�ssel-wert-paare(nodes)
		Iterator allesIt=map.entrySet().iterator();
		while(allesIt.hasNext())
		{
			Map.Entry eintrag=(Map.Entry)allesIt.next();
			System.out.println("Der Schl�ssel: " + eintrag.getKey() + ", der Wert: " + eintrag.getValue());
			
		}
		
		
		
		
			
		
		
		

	}
	
	
	public void printListe(List li)
	{
		
	}
	
	
	
	
	

}
