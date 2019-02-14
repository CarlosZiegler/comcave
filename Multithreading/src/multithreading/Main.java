package multithreading;
/*
 * 	MULTITHREADING:
 * 
 * 		-> Eine M�glichkeit f�r Entwickler, parallele Codestr�nge zur Laufzeit auf separaten Threads
 * 		   abarbeiten zu lassen
 * 
 * 		-> Das Multithreading ist in Java Kernbestandteil der Sprache(java.lang)
 * 
 * 		-> Wenn man in Java m�chte, dass eine Klasse threadf�hig ist, dann muss diese Klasse entweder
 * 		   die vorhandene Klasse "Thread" erweitern, ODER das Interface "Runnable" implementieren!
 * 
 * 		-> In Java muss derjenige Code, welcher in parallelen Threads abgearbeitet werden soll, in die
 * 		   Methode "public void run()" !
 * 
 * 		-> Das Interface Runnable gibt die abstrakte Methode run() vor, und befindet sich in der Klasse
 * 		   Thread, weil Thread das Interface Runnable implementiert!
 * 
 * 		-> Der direkte Aufruf der Methode run() f�hrt NICHT ZU EINEM SEPARATEN THREAD!!!
 * 				-> die run() wird hier genauso wie jede Methode auf denselben Stack geladen!!
 * 
 * 		-> Die Methode start() veranlasst die Programmausf�hrung, den Inhalt der Methode run()
 * 		   auszulesen, und auf einen speraten Thread zu laden(neuer Stack wird er�ffnet)
 * 
 * 		-> Jeder Thread hat eine ID(automatisch vergeben durch JVM) bzw. einen Namen(vergeben durch
 * 		   Entwickler)
 * 
 * 				JVM -> Thread-0
 * 
 * 				-> Wenn der Entwickler eigene Namen m�chte, muss er an den entsprechenden Konstruktor der
 * 					Klasse Thread diesen �bergeben!
 * 
 * 		-> Einen Thread darf man nicht nochmal starten(auch nicht, wenn er abgearbeitet ist) !!!
 * 				-> Laufzeitfehler!
 * 
 * 		-> Damit die start()-Methode f�r den Start eines Thread aufgerufen werden kann, muss es immer
 * 		   eine lebendige Instanz vom Typ Thread geben!
 * 
 * 			-> Wenn eine Klasse Runnable implementiert, ist die start() nicht vorhanden!
 * 				-> Hier muss man also �ber eine Thread-Instanz gehen und das Runnable an den 
 * 				   Konstruktor der Klasse Thread �bergeben
 * 	
 * 		-> Zust�nde(state) von Threads:
 * 
 * 			- "NEW" -> Es gibt eine neue Thread-Instanz auf dem Heap, die run() l�uft noch nicht!
 * 
 * 			- "RUNNABLE" -> Nach dem Aufruf der start() wird die run() ausgelesen und auf einen neuen
 * 					  		Stack geladen, die run() wird aber noch nicht abgearbeitet!
 * 
 * 			- "RUNNING" -> Die run()-Methode wird gerade abgearbeitet
 * 
 * 			- "WAITING"/"BLOCKED"/"SLEEPING" -> Der Thread stoppt tempor�r die Abarbeitung der run(),
 * 			   um diese genau dort sp�ter wieder fortzuf�hren
 * 
 * 			- "DEAD"/"TERMINATED" -> Wenn die run() eines Thread komplett abgearbeitet wurde, wird der
 * 				Thread zerst�rt
 * 
 * 					-> Weitere Ursachen f�r den "Tod" eines Thread:
 * 
 * 						-> Wenn in der run() eine unbehandelte Ausnahme auftritt!
 * 
 * 						-> System.exit(0);
 * 
 * 
 * 		-> Ein Javaprogramm gilt also dann als beendet, wenn sein letzter Vordergrundthread terminiert
 * 		   wurde!
 * 		 
 * 			
 * 
 * 
 */



public class Main {

	public static void main(String[] args) 
	{
		Monster m1=new Monster("Hulk");
		m1.start();
		Monster m2=new Monster("Godzilla");
		m2.start();
		Monster m3=new Monster("Goblin");
		m3.start();
		
		Held hero=new Held("Chuck Norris");
		Thread chuckNorris=new Thread(hero, "Chuck Norris");
		chuckNorris.start();
		
		Held superman=new Held("Superman");
		new Thread(superman, "Superman").start();
		
		new Thread(new Held("Batman"), "Batman").start();
		
		Thread.yield();
		
		try {
			m1.join(); //Current Thread(hier der Thread "main") wartet solange mit der Abarbeitung weiterer
					   //Anweisungen, bis m1 seine run() komplett abgearbeitet hat
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//threads per anonyme klasse starten
		Monster anonymesMonster=new Monster("Anonymes Monster")
				{
					@Override
					public void run()
					{
						System.out.println("Ich bin ein anonymes Monster...");
					}
				};
		anonymesMonster.start();
		
		new Monster("Schnelles Anonmonster")
		{
			@Override
			public void run()
			{
				
			}
		}.start();
		
				
		new Thread(new Held("HeldA"))
		{
			@Override
			public void run()
			{
				
			}
		}.start();
		
		
		
	}

}
