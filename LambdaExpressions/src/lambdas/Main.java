package lambdas;
import java.util.*;

/*
 * 	- Lambda-Ausdrücke stammen aus dem funktionalen Paradigma
 * 
 * 	//Beispiele aus Haskell(rein funktionale Programmiersprache):
 * 
 * 	 verdoppleMich x=x+x
 * 	 verdoppleUns x y=x*2 + y*2
 * 	 rufeAuf x y = verdoppleMich x + verdoppleUns x y
 * 
 * 
 * 	-> Typisch für funktionales Programmieren: 
 * 
 * 			- Es gibt Ausdrücke, welche ausgewertet werden und am Ende ein Ergebnis liefern
 * 	-------------------------------------------		
 * 	Lambda-Ausdrücke in Java:
 * 
 * 		-> In Java kann man Lambdas auf sogenannten funktionalen Schnittstellen definieren und auswerten lassen
 * 
 * 			-> JEDER Lambda-Ausdruck in Java muss auf einer funktionalen Schnittstelle basieren!
 * 
 * 			-> Was sind funktionale Schnittstellen?
 * 
 * 				1. Interfaces, welche NUR EINE EINZIGE abstrakte Methode haben
 * 				2. Interfaces, welche mit der Annotation "@FunctionalInterface" gekennzeichnet sind
 * 
 * 			-> Bisher bekannte funktionale Interfaces:
 * 
 * 				- Runnable
 * 				- ActionListener
 * 				- Comparator
 * 				- Comparable
 * 				- ....
 * 
 * 
 * 			-> Mit der Einführung von Lambdas in Java sind eine Reihe von vordefinierten funktionalen
 * 			   Schnittstellen in die Sprache eingegangen(im Package java.util.function.)
 * 
 * 				- Predicate<T> - für die Auswertung von Fragestellungen, liefert boolean
 * 				- Consumer<T> - wertet den Lambda-Ausdruck aus und konsumiert ihn dann ohne Rückgabe: Ausgabe
 * 				- Function<T, R> - gibt etwas vom Typ R zurück - typisch für Konvertierungen von T nach R
 * 				- Supplier<R> - soll etwas vpm Typ R aufbauen und als Ergebnis liefern (Fabric)
 * 				- UnaryOperator<R> - der übergebene Typ wird angepasst und so verändert zurück gegeben
 * 				- ...
 * 
 * 			-> Man kann natürlich auch eigene funktionale Interfaces definieren!
 * 
 * 
 * 			-> Allgemeine Syntax für Lambdas:
 * 
 * 					(Parameter) -> {Anweisungen}
 * 
 * 			-> Alle Labda-Ausdrücke in Java haben einen Zieltyp, welchen der Compiler aus dem KONTEXT des
 * 			   Ausdruckes erkennen können muß!
 * 
 * 			
 * 			-> Lambda-Ausdrücke definieren und benötigen auch keine Klassen(auch keine inneren)!
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
		ArrayList<Brot> brotListe=new ArrayList<>();
		brotListe.add(new Brot(800, "Schwarzbrot"));
		brotListe.add(new Brot(200, "Toast"));
		brotListe.add(new Brot(1000, "Pumpernickel"));
		brotListe.add(new Brot(400, "Baguette"));
		brotListe.add(new Brot(380, "Steinofenbrot"));
		
		
		Collections.sort(brotListe, new Comparator<Brot>() {
			
			@Override
			public int compare(Brot b1, Brot b2)
			{
				if(b1.getGewicht()>b2.getGewicht())
				{
					return -1;
				}
				else if(b1.getGewicht()<b2.getGewicht())
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
		});
		
		//***********************************************************************************
		//Das selbe Sortieren per Lambda:
		Collections.sort(brotListe, (Brot b1, Brot b2) -> 
			{
				if(b1.getGewicht()>b2.getGewicht())
				{
					return -1;
				}
				else if(b1.getGewicht()<b2.getGewicht())
				{
					return 1;
				}
				else
				{
					return 0;
				}
			});
		
		//Lambda-Ausdrücke dürfen NIE Parameter haben, welche den gleichen Namen haben wie andere Variablen
		// IM SELBEN SCOPE!
		
		//Da Lambdas nicht auf Klassen beruhen, können in ihrem Scope keine Referenzen wie das "this" benutzt
		//werden!
		//**************************************************************************************
		
		//Lambda-Ausdrücke kann man Variablen zuweisen:
		Comparator<Brot> brotCompi=(Brot b1, Brot b2) -> {return b1.getBezeichnung().compareTo(b2.getBezeichnung());};
		Collections.sort(brotListe, brotCompi);
		
		//-> Der Java-Compiler erkennt immer per Typinferenz, in welchem Kontext der LA definiert wurde und
		// kann darauf basierend auch den Zieltyp des LA herleiten
		//Der Compiler erkennt also, dass der Comparator<Brot> natürlich nun zwei Parameter vom Typ Brot haben
		//MUSS - von daher lässt sich der LA noch weiter vereinfachen:
		Comparator<Brot> brotCompi2=(b1, b2) -> {return 0;};
		//da die Anweisungsklammer nur EINE Anweisung hat, lässt sich der LA noch weiter reduzieren:
		Comparator<Brot> brotCompi3=(b1, b2) -> b1.getBezeichnung().compareTo(b2.getBezeichnung());
		
		/*	Im folgenden Beispiel erkennt der Compiler per Typinferenz folgene Tatsachen/Konsequenzen:
		 * 
		 * 		1. s kann hier in diesem Zusammenhang nur vom Typ String sein(muss man also nicht schreiben)
		 * 		2. Comparable hat nur die Methode compareTo(String), mit nur EINEM Parameter -> Runde
		 * 		   Klammer muss nicht geschrieben werden -> Typ wird weggelassen
		 * 		3. Es gibt im Anweisungsteil nur eine Anweisung, also kann die geschweifte Klammer weg
		 * 		4. Die int compareTo(String) liefert immer einen int! -> Rückgabe ist eindeutig-> return muß
		 * 	       man nicht schreiben
		 * 
		 * 
		 */
		
		Comparable<String> compS = s -> s.length();
		
		//hier soll die compareTo immer 0 liefern - der Parameter-Teil soll nicht genutzt werden
		//anstatt des Parameters kann hier nun nur der Typ eingesetzt werden
		Comparable<String> compOhneArgument = String -> 0;
		
		//*****************************************************************************************
		List<Integer> nummern=new ArrayList<Integer>();
		nummern.add(new Integer(22));
		nummern.add(new Integer(499));
		nummern.forEach(s -> System.out.println(s));
		
		nummern.forEach(System.out::println); //hier wird die methode nicht direkt in System.out aufgerufen,
											  //sondern nur referenziert -> METHODENREFERENZ
		
		
		ArrayList<Integer> kopieListe=new ArrayList<Integer>();
		//nummern.forEach(s -> kopieListe.add(s));
		nummern.forEach(kopieListe::add); //hier wird per methodenreferenz und lambda uaf der funktionalen 
										  //schnittstelle Consumer operiert
		kopieListe.forEach(System.out::println);
		//**********************************************************************************************
		Diskothek dizze=new Diskothek();
		Gast otto=new Gast(16, "m");
		Gast linda=new Gast(19, "w");
		
		boolean ottoOK=dizze.getKaya().eintrittOK(otto, (Gast g) -> {return g.getAlter()>=18; });
		boolean lindaOK=dizze.getKaya().eintrittOK(linda, (Gast g)->{return g.getGeschlecht().equals("w") &&
				g.getAlter()<=16;});
		
		//**********************************************************************************************
		String userEingabe="    Name  ";
		String bearbeitet=EingabeTransformer.transform(userEingabe, EingabeTransformer.compose(String::trim, 
				String::toLowerCase, s -> s.substring(0, 3)));
		
		//**********************************************************************************************
		//* LAZYNESS
		
		String passwort=StringTransformator.of("  WoRT")
				.transform(String::trim)
				.transform(String::toLowerCase)
				.toString();
		
		System.out.println(passwort);
		
		
		
		
	}

}

class Brot
{
	private int gewicht;
	private String bezeichnung;
	public Brot(int gewicht, String bezeichnung) {
		super();
		this.gewicht = gewicht;
		this.bezeichnung = bezeichnung;
	}
	public int getGewicht() {
		return gewicht;
	}
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	@Override
	public String toString() {
		return "Brot [gewicht=" + gewicht + ", bezeichnung=" + bezeichnung + "]";
	}
	
	
	
	
	
	
}








