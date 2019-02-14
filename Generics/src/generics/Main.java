package generics;
import java.util.*;

/*
 * 	Generische Programmierung / Generics:
 * 
 * 
 * 		-> Generische Programmierung erlaubt das Typsieren von allgemein gehaltenen Typen auf konkrete Typen * 
 * 
 * 
 * 		-> IN JAVA IST GENERICS REINE COMPILEZEIT !!!!!!!!
 * 
 * 
 */
public class Main {

	public static void main(String[] args) 
	{
		ArrayList li=new ArrayList();
		Artikel loeffel=new Artikel("Löffel");
		li.add(loeffel);
		String text=new String("Text");
		li.add(text);
		//ohne generics muss der zugriff auf objekte von collections üblicherweise per typprüfung + cast erfolgen:
		if(li.get(0) instanceof Artikel)
		{
			Artikel a0=(Artikel)li.get(0);
		}
		
		//mal angenommen, jemand möchte eine ArrayList, welche NUR Artikel-Objekt annimmt/speichert
		ArrayList<Artikel> artikelListe=new ArrayList<Artikel>();
		//artikelListe.add(text); --> Die ArrayList akzeptiert hier KEINEN String -> Compilerfehler!
		artikelListe.add(loeffel); //-> hier kann also nur etwas landen, was vom typ Artikel ist!
		Werkzeug hammer=new Werkzeug("Hammer");
		artikelListe.add(hammer); //Werkezug ist ebenfalls vom Typ Artikel, wird also auch akzeptiert!
		//nun kann man OHNE Typprüfung und Typkonvertierung direkt auf spezielle Artikelmethoden zugreifen!
		artikelListe.get(0).setArtikelNr("ADB66666");
		//artikelListe.add(new Object()); -> Kontravarianz ist hier verboten!
		
		//Die Referenzvariable "werkzeugListe" ist vom Typ ArrayList<Werkzeug>  !!!!
		ArrayList<Werkzeug> werkzeugListe=new ArrayList<Werkzeug>();
		
		//Wichtige Begriffe:
		/*
		 *  Anweisung: ArrayList<Werkzeug> werkzeugListe;
		 *  
		 *  - ArrayList -> Rohtyp(raw type)
		 *  - <Werkzeug> -> Typparameter
		 *  - ArrayList<Werkzeug> -> Parametrisierter Typ(parameterized type)
		 *  
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		//-> Ein parametreisierter Typ muss genausoviele Typparameter haben, wie es Typvariablen in der
		// Klasse/dem Interface selbst gibt!
		MeineListe<Artikel> meineListe=new MeineListe<Artikel>();
		Artikel temp=meineListe.getElementAt(0);
		
		
		MeineListe<String> meineListeString = new MeineListe<String>();
		
		//Nutzung eines generisch parametrisierten Iterators
		Iterator<Artikel> it=meineListe.iterator();
		while(it.hasNext())
		{
			//hier wird die next() immer ein Artikel-Objekt liefern!
			it.next().getArtikelNr();
		}
		
		//Wenn ein generischer Typ NICHT parametrisiert und nur als Rohtyp benutzt wird, dann ersetzt
		//der Compiler alle Typvariablen durch Object !
		
		ArrayList<Werkzeug> arrLi=new ArrayList<Werkzeug>();
		testeListen(arrLi);
		Iterator<Werkzeug> itw=arrLi.iterator();
		while(itw.hasNext())
		{
			Werkzeug w=itw.next();
		}
		/*
		 * 	LinkedList<Artikel> und LinkedList<Werkzeug> sind NICHT TYPKOMPATIBEL!
		 *  (Auch wenn Werkzeug von Artikel erbt!)
		 * 	
		 * 	genausowenig sind 
		 * 
		 *  LinkedList<Werkzeug> und LinkedList<Artikel>
		 *  
		 *  kompatibel!
		 * 
		 * 
		 * 
		 */
		//LinkedList<Artikel> lili=new LinkedList<Werkzeug>(); -> COMPILERFEHLER
		//lili.add(new MassageIgel());
		
		LinkedList<MassageIgel> massegeListe=new LinkedList<>();
		LinkedList<Werkzeug> wListe=new LinkedList<>();
		
		printArtikelListe(massegeListe);
		printArtikelListe(wListe);
		
		//lili darf auf alles zeigen, was eine LinkedList mit einem zu Artikel kovariantem Typparameter
		//ausgestattet ist
		LinkedList<? extends Artikel> lili=new LinkedList<Werkzeug>();
		//das Hinzufügen von Elementen über Referenzvariablen, welche Wildcards nutzen, 
		//ist grundsätzlich verboten! -> Compilerfehler!
		//lili.add(new Werkzeug("Bohrmaschine"));
		LinkedList<Werkzeug> werkzeuge=(LinkedList<Werkzeug>) lili;
		
		
	}
	
	//Man sollte parametrisierte Typen niemals an Methoden übergeben, deren Parameter non-generisch sind!
	public static void testeListen(List li)
	{
		li.add(new String());
	}
	
	//diese methode akzeptiert alle listen, welche auf Werkzeug generisch parametrisiert wurden:
	public static void testeWerkzeugListen(List<Werkzeug> li)
	{
		//li.add(new String()); //-> Compilerfehler: Hier dürfen nur Werkzeuge hinzugefügt werden
	}
	
	//diese methode akzeptiert alle List, deren generischer Typparameter vom Typ Artikel ist(kovariant)
	public static void printArtikelListe(List<? extends Artikel> li)
	{
		//Hinzufügen nicht erlaubt!
		//li.add(new Artikel("jgiuio"));
	}
	
	//diese methode akzeptiert alle List, deren generischer Typparameter vom Typ MassageIgel oder eines
	//seiner Supertypen ist(kontravariant) 
	public static void printListe(List<? super MassageIgel> li)
	{
		
	}
	
	//diese methode akzeptiert ALLE List, unabhängig davon, welcher Typparameter!
	public static int countListe(List<?> li)
	{
		return li.size();
	}
	
	
	
	
	

}
