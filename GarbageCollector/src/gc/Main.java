package gc;
/*
 * 	Garbage Collector:
 * 
 * 		-> Läuft unter der Kontrolle der JVM, räumt nicht referenzierte Objekte vom Heap
 * 
 * 		-> Arbeitet auf dem Heap
 * 
 * 		-> Welche Objkte sind eigentlich abholbereit(eligible) durch den GC?
 * 
 * 			-> Objekte, welche aus keinem Stack(Thread) mehr referenziert werden
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class Main {

	
	private Main ref;
	
	public static void main(String[] args) 
	{
		Main m=new Main();
		//System.gc();
		
		Main m1=new Main();
		
		m=null;
		m1=null;
		//******************************************
		
		Main a=new Main();
		Main b=new Main();
		Main c=new Main();
		
		a.ref=b;
		b.ref=c;
		c.ref=a;
		
		a=null;
		b=null;
		c=null;
		
		
		Object g=m.test(new Object());
		
		
		
		

	}
	
	private Object test(Object o)
	{
		Object a=new Object();
		Object b=new Object();
		a=b;
		b=o;
		return a;
	}
	
	
	
	
	
	
	
	
	

}
