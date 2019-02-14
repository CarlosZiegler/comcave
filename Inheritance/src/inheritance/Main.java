package inheritance;
/*
 * 	Was passiert schrittweise, wenn ein Objekt in Java instanziiert wird?
 * 
 * 		1. Alle Attribute der Klasse werden ausgelesen
 * 
 * 		2. Die Attribute werden mit Defaultwerten initialisiert
 * 		
 * 		3. Der bei der Instanziierung aufgerufene Konstruktor wird ausgeführt
 * 
 * 		4. Da im Konstruktor die erste Anweisung(implizit/explizit) der Superaufruf ist(super()), wird zunächst der 
 * 		   entsprechende Superkontruktor geladen und auch auf dem Stack "gestapelt"
 * 
 * 		5. Wenn der oberste Superkonstruktor aufgerufen ist, beginnt die Abarbeitung aller aufgerufenen Konstruktoren auf dem 
 * 		   Stack von oben nach unten(LIFO)
 * 
 * 		6. Schliesslich wird, nachdem der letzte(also der zuerst aufgerufene) Konstruktor abgearbeitet wurde, eine Reihe von
 * 			Verweisen gesetzt -> a) ein Pointer zur Speicheradresse des Objekts  b) Verweise auf die virtuellen Methodentabellen
 * 								 b) Verweis auf das Klassenobjekt(static-Elemente)
 * 
 *  	7. Das fertige Objekt wird auf den Heap geladen
 * 
 * 		
 * 
 * 	Die Konstruktorverkettung
 * 
 * 		-> Ist notwendig, um alle Teilemente der Supertypen in das komplett fertige Objekt auf dem Heap zu laden
 * 
 * 
 * 	Konstruktoren
 * 
 * 		-> Konstruktoren werden nicht vererbt !!!  -> Demnach können sie auch nicht überschrieben werden!
 * 	
 * 		-> Wenn kein expliziter Konstruktor gesetzt wird, dann stellt der Compiler den Default!
 * 
 * 		-> Wenn aber ein expliziter Konstruktor gesetzt wurde, dann wird KEIN Default mehr gestellt!
 * 
 * 		-> Der Javacompiler sorgt immer dafür, dass eine komplette Konstruktorverkettung gestellt sein muß!
 * 
 * ---------------------------------------------------------------------------------------------------------------
 * 
 * 	Polymorphie/Polymorphismus:
 * 
 * 		1. Regel: Eine Referenzvariable darf auf alles zeigen, was kovariant ist!
 * 
 * 		2. Den Typ einer Referenzvariablen kann man nicht mehr ändern!
 * 
 * 		3. Man kann über eine Referenzvariable nur diejenigen Methoden aufrufen, welche auch in dem Typen der Variablen bekannt sind!!!
 * 
 * 		4. Ein Upcast kann immer implizit stattfinden!
 * 
 * 		5. Ein Downcast muss immer explizit erfolgen(unabhängig davon, ob er funktioniert oder nicht)!
 * 
 * 		6. Wenn ein expliziter Downcast als Anweisung gesetzt wird, dann gibt es keine Compilerfehler, - ALLERDINGS kann die
 * 		   Laufzeitumgebung eine ClassCastExcpetion werfen, falls die geforderte Konvertierung nicht erlaubt ist!!!!!
 * 
 * 				-> Wann ist ein Downcast erlaubt?
 * 					-> Wenn hinter der zu castenden Variablen vorher mal dieser konkrete Untertyp gesteckt hat!
 * 
 * 		7. Der Typ einer Referenzvariablen bestimmt, welche Methoden aufgerufen werden(können)
 * 
 * 
 */
public class Main 
{

	
	
	
	public static void main(String[] args) 
	{
		
		Lebewesen l=new Lebewesen("Bakterium"); //l ist KEINE polymorphe Referenzvariable
		//lebe ist eine Referenzvariable vom Typ Lebewesen, welche auf ein konretes Fisch-Objekt im Speicher zeigt:
		Lebewesen lebe=new Fisch("Karpfen"); //lebe ist eine polymorphe Referenzvariable
										//-> hier findet ein IMPLIZITER UPCAST zu Lebewesen statt!
		//lebe.schwimmen(); //diese Methode kann NICHT aufgerufen werden, da sie in Lebewesen nicht bekannt ist!!
		lebe.atmen(); //hier wird die SPEZIELLE/ÜBERSCHRIEBENE Variante der Methode aufgerufen!
		
		Fisch hai=new Fisch("Hai");
		Lebewesen lebt=new Lebewesen("lebt");
		//lebt=hai; //hier findet auch ein impliziter Upcast statt!
		//hai=(Fisch)lebt; //-> Hier wird ein DOWNCAST explizit durchgeführt! -> LAUFZEITFEHLER!!!!
			//-> Dieser Downcast wird NICHT GELINGEN, weil die Laufzeit eine Konvertierung von Lebewesen zum speziellen Fisch verbietet
		
		Fisch karpfen=(Fisch)lebe; //hier findet ein Downcast statt: Das urpsrüngliche(hinter lebe) steckende Fisch-Objekt soll sich 
								  //auch wieder wie ein spezieller Fisch verhalten(und nicht mehr wie das allgemeine Lebewesen)
		karpfen.schwimmen(); //nach dem Downcast kann man nun für dieses Objekt auch wieder die speziellen Fisch-Methoden aufrufen!
		
		
		Object o=new Object();
		o=new Fisch("Blafisch");
		Fisch thunfisch=(Fisch)o;
		
		
	}

	
	public void printLebewesen(Lebewesen l)
	{
		if(l instanceof Fisch)
		{
			((Fisch)l).schwimmen();
		}
		else if(l instanceof Mensch)
		{
			Mensch temp;
			temp=(Mensch)l;
			temp.gebaeren();
		}
		
	}
	
	
	
	
	
	
	
}
