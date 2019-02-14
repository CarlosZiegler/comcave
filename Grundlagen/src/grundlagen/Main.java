package grundlagen;
/*
 * 		Lebenszyklen:
 * 
 * 
 * 			Lebenszyklen zur Laufzeit(Runtime):
 * 			---------------------------------------
 * 			Lebenszyklus einer Klasse:
 * 
 * 				-> Von allen an einem Javaprogramm beteiligten Klassen wird am Start jeweils ein Klassenobjekt in den Heap geladen
 * 				
 * 
 * 			Lebenszyklus von allen Elementen, die static sind:
 * 
 * 				-> Gebunden an die Existenz der zugehörigen Klassen(also des Klassenobjekts)
 * 				-> Beim Auslesen der Klasse wird alles, was static ist, EINMALIG in das Klassenobjekt gespeichert
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public final class Main //finale Klassen können nicht erweitert werden!
{
	//Member/Attribut
	
	
	//ein privates array von char
	private static char[] cArr; //Klassenanttribut/Klassenvariable
	private int var; //private Instanzvariable
	private String text; //Eine Referenzvariable/Instanzvariable
	private final int[] zahlenfeld= {1, 2, 3}; //finale Referenzvariable -> Das Objekt dahinter kann man ändern, aber
											   //die Variable darf kein anderes Objekt mehr zugewiesen bekommen!
	private final double zahl=1; //primitive, finale Variable, deren erstmalig zugewiesener Wert nicht mehr geändert werden kann
	private final String wort="Wort";
	int komischeZahl=9; //Sichtbarkeit -> default(implizit) -> paketweit sichtbar
	protected int wert; //Paketweite Sichtbarkeit, zudem in Unterklassen sichtbar, welche sich in anderen Paketen befinden(im
						// Gegensatz zu default)
	//Konstante(immer static UND final):
	private static final double STEUERSATZ=21;
	
	/*
	 *  Static:
	 *  
	 *  	-> Jedes Element, was static ist, befindet sich einmalig im Speicher(alle Objekte teilen sich diesen Speicherbereich)
	 *  	-> Gebunden an die Existenz des Klassenobjektes/der Klasse und NICHT an die Existenz von Instanzen
	 *  	-> Wenn Methoden static sind:
	 *  			-> Aus so einem statischen Kontext heraus kann man direkt nicht auf Elemente zugreifen, welche selbt nicht
	 *  			   statisch sind -> Compilerfehler
	 * 
	 * 
	 * 
	 * 
	 */
	
	//startpunkt meiner anwendung -> Klassenmethode
	public static void main(String[] args) 
	{
		Main test=new Main();
		test.zahlenfeld[0]=50;
		//test.zahl=23; -> verboten, da final
		//test.zahlenfeld=new int[20]; -> verboten, da final
		//test.wort=new String("Neues Wort"); -> verboten, da final
		//test.wort="Neues Wort"; -> verboten, da final
		test.wort.toLowerCase();
		int var; //deklarierte lokale, primitive Variable vom Typ int mit dem Namen "var"
		char c='X'; //lokale, primitive Variable vom Typ char deklariert und direkt auch initialisert
		
		var=5; //die lokale Variable var ist nun mit dem Wert/Literal 5 initialisiert

		Main m; //lokale Referenzvariable vom Typ Main, mit dem Bezeichner "m";
		m=new Main(); //der new-Operator sorgt dafür, dass ein Objekt vom Typ Main auf dem Heap geladen wird!
		//Referenzvariablen speichern die Adresse eines Objektes auf dem Heap! 
		System.out.println(m);
		Main m1=new Main();
		m.var=4;
		m1.var=0;
		System.out.println(m1);
		m1=m;
		System.out.println(m1);
		
		// Main.class -> Ansprechen des im Heap geladenen Klassenobjekts zur Klasse Main
		Main.cArr=new char[12];
		//***********************************************************************************
		int x=10;
		int xTemp=12;
		int erg=m1.addiere(x, xTemp);
		System.out.println("Der Wert von x ist: " + x);
		Main testMain=new Main();
		Main testMain2=new Main();
		testMain.var=10;
		testMain2.var=12;
		int erg2=m1.addiere(testMain, testMain2);
		System.out.println("Der Wert von var in testMain ist " + testMain.var);
		
		
	}

	
	//Die Parameterübergabe an Methoden in Java erfolgt IMMER per Call-By-Value (nie Call-By-Reference)!!!
	private int addiere(int z, int xTemp)
	{
		z=0;
		return z + xTemp;
	}
	
	//finale methoden kann man nicht mehr überschreiben!
	private final int addiere(Main testMain, Main testMain2)
	{
		testMain.var=0;
		return testMain.var + testMain2.var;
	}

}

