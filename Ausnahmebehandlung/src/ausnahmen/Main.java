package ausnahmen;
/*
 * 	AUSNAHMEBEHANDLUNG / EXCEPTION HANDLING:
 * 
 * 		-> Was ist eine Ausnahme?
 * 
 * 			-> Ein spezifisches Problem zur Laufzeit, welches behandelt werden soll/muss
 * 
 * 			-> Es gibt zwei Typen von Ausnahmen:
 * 
 * 				-> Probleme, welche ein Softwareentwickler komplett unter Kontrolle hat(haben sollte)
 * 						-> Zugriff über null-Referenzen
 * 						-> Überlauf über Array-Grenzen hinweg
 * 
 * 					-> Hier werden die Entwickler NICHT dazu gezwungen, parallelen Problembehandlungscode zu entwickeln
 * 
 * 					-> Unchecked Exceptions
 * 
 * 						-> IN JAVA ERBEN ALLE Unchecked Excpetions von der Superklasse RuntimeExcpetion!!!
 * 
 * 
 * 				-> Probleme, welche ausserhalb der Kontrolle liegen
 * 						-> Netzwerkverbindungsprobleme
 * 						-> JVM entzieht dem Javaprogramm bestimmte Ressourcen
 * 
 * 					-> Hier werden Entwickler dazu gezwungen, parallelen Behandlungscode zu schreiben!
 * 
 * 					-> Man nennt solche Ausnahmen: Checked Excpetions
 * 
 * 
 * 		-> Alle Excpeptions, welche nicht vom Typ RuntimeException sind, MÜSSEN entweder behandelt werden, oder an den
 * 		   Aufrufer "geworfen" werden -> catch-or-throw-Regel!
 * 
 * 		-> Zu jedem "klassischen" Problem, welches zur Laufzeit auftreten kann, exisitiert eine Klasse 
 * 
 * 		-> Was passiert, wenn ein Problem zur Laufzeit auftritt?
 * 
 * 			1. Es wird eine passende Klasse, welche zu diesem Problem gehört benutzt und davon eine Objekt erzeugt
 * 			2. Dieses Objekt wird mit relevanten Informationen zum Problem ausgestattet:
 * 					- Wo ist das Problem aufgetaucht?
 * 					- Was ist die ursprüngliche Fehlermeldung?
 * 					- Stacktrace(Aufrufabfolge bis zum Problem)
 * 					- ...
 * 			3. Dieses Excpetion-Objekt kann nun lokal(dort wo das Problem aufgetaucht ist) von einem catch-Block aufgenommen werden,
 * 				oder nicht
 * 				3a) FALLS das Objekt lokal keinen passenden catch-Block findet, wird solange von Scope zu Scope, von innen nach
 * 					aussen nach einem catch-Block gesucht, bis am Ende der erste Aufrufer erreicht wird(die JVM)
 * 				-> WENN ein Exception-Objekt einmal bei der JVM gelandet ist, beendet diese den entsprechenden Thread und wirft
 * 			       die Fehlermeldung direkt aus
 * 
 * 
 * 
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		int var=15;
		//in einem try-Block steht immer NUR DERJENIGE CODE, welcher problembehaftet ist bzw. sein könnte!!!!
		try
		{
			System.out.println(division(var)); //hier wird eine methode aufgerufen, welche eine ArtithmeticException auslöst
			System.out.println("Nach der Division....."); //Diese Zeile wird nicht ausgeführt -> Programmausführung verlässt diesen Block
		}
		catch(NullPointerException ex) //-> catch-Blöcke immer von speziell nach allgemein sortieren!
		{
			/*	Was kommt üblicherweise in eine catch-Block?
			 * 
			 * 		- Eine adäquate Reaktion auf das aufgetretene Problem:
			 * 
			 * 			- Fehler-Log
			 * 			- Verbindungen sauber trennen
			 * 			- Passenden Fehlermeldungen/Anweisungen auswerfen
			 * 			- Analyse/zusätzliche Informationen sammeln und weitergeben
			 * 
			 * 		-> In echten Anwendungen darf ein catch-Block niemals leer bleiben
			 */
			System.out.println("Division ist nicht gelungen -> " + ex.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println("Ein unbekannter Fehler ist aufgetreten...");
		}
		

		System.out.println("Nach der Fehlerbehandlung.....");
		
		
		//Der finally-Block:
		try
		{
			//aufbau einer db-verbindung
			
			//transaktionen....
			//int i=3/0;
			System.out.println("Normaler try-Block ohne Ausnahmen....");
			
		}
		catch(Exception e)
		{
			System.out.println("Fehler ist aufgetreten: " + e.getMessage());
		}
		finally //im finally-Block sollte Code stehen, welcher die im try eingeleiteten Aktionen sauber zu Ende führt.....
		{
			//db-verbindung wieder sauber trennen
			System.out.println("Ich bin im finally.....");
		}
		
		System.out.println("Nach dem finally....");
		
		/*	-> Sobald ein try-Block betreten wurde, wird auch IMMER der zugehörige(falls vorhanden) finally-Block ebenfalls abschliessend
		 *  abgearbeitet!
		 * 
		 *  -> Der finally-Block wird betreten, UNANBHÄNGIG davon, ob im zugehörigen try eine Ausnahme auftritt, oder nicht!!!
		 * 
		 * 
		 * 
		 */
		
		
		try
		{
			
		}
		finally //an einen try-Block muss sich kein catch-Block anschliessen, wenn direkt auf den try ein finally folgt
		{
			
		}
		
		
		
		
		
		Main m=new Main();
		
		try
		{
			m.testeFinally();
		}
		catch(ArithmeticException e)
		{
			System.out.println("Fehler bei der mathematischen Operation...");
		}
		
		//*************************************
		System.out.println("---------------------------------------------------------------");
		ausnahmen();
		
		throw new MyOwnException("Ich werfe meine eigene Ausnahme!");
		
	}
	
	private static void ausnahmen()
	{
		try
		{
			int[] arr=new int[10];
			int x=0;
			for(int i=0;i<9;i++)
			{
				x=arr[i];
			}
			try
			{
				for(int i=0;i<=20;i++)
				{
					x=arr[i];
				}
			}
			catch(ClassCastException e)
			{
				System.out.println("Fehler im inneren catch....");
			}
			finally
			{
				System.out.println("Finally des inneren try wurde abgearbeitet...");
			}
			System.out.println("Anweisung nach dem inneren finally.....");
		}
		catch(ClassCastException ex)
		{
			System.out.println("Fehler beim Casten....");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Fehler bim Durchlaufen des Arrays: " + e.getMessage());
		}
		finally
		{
			System.out.println("Finally des äusseren catch wurde ausgeführt....");
		}
		System.out.println("Nach dem ganzen try-konstrukt....");
		
		
		
		
		
	}
	
	
	
	
	
	
	
	/**
	 *  Methode empfängt eine Ganzzahl und dividiert diese immer durch 0
	 * 
	 * 
	 * 
	 * @param int
	 * @return int
	 * @throws ArithmeticException
	 */
	private static int division(int a)
	{
		return a/0;
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * @throws ArithmeticException
	 */
	public void testeFinally() throws ArithmeticException, NullPointerException
	{
		try
		{
			int i=3;
			int div=i/0;
			//weiterer Code.....
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Behandlung der ArtihmethicExcpetion in der Methode testeFinally()...");
		}
		finally
		{
			System.out.println("Verbindung trennen....");
		}
	
	}
	
	public void testeCheckedExceptions() 
	{
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e) //InterruptedException MUSS entweder behandelt oder weitergereicht werden!!!
		{
			System.out.println("Thread wurde früher als die vereinbarten 1000 ms aufgeweckt...");
		}
	}
	
	public void methodeA() throws UnsupportedOperationException
	{
		//hier wird explizit ein Exception-Objekt erzeugt und mit der entsprechenden Meldung weitergereicht: 
		throw new UnsupportedOperationException("Diese Operation ist nicht erlaubt");
	}
	

}
