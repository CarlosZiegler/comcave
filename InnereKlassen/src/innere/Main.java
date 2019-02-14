package innere;
/*
 * 	INNERE KLASSEN:
 * 
 * 		-> Innere Klassen werden vor allem dann benutzt, wenn man sehr schnell(lokal), bzw sehr speziell typisieren möchte
 * 
 * 
 * 		-> Es gibt unterschiedliche Formen von inneren Klassen:
 * 
 * 			1. Elementklassen -> Werden im Scope anderer Klassen definiert
 * 			2. Methodenklassen -> Werden im Scope einer Methode definiert
 * 			3. Anonyme Klassen -> Können (fast) überall definiert werden
 * 
 * 			4. Statische innere Klassen -> Elementklassen, welche static sind
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
public class Main 
{

	public static void main(String[] args) {
		Auto karre=new Auto();
		
		ElementSammlung sammlung=new ElementSammlung(100);
		//elemente hinzufügen...
		sammlung.addElement(karre);
		//....
		
		
		//elementsammlung per iterator durchlaufen:
		ISammlungIterator iter=sammlung.iterator();
		while(iter.elementVorhanden()) //schleife läuft solange element vorhanden sind
		{
			//das nächste element der sammlung holen:
			Object elem=iter.nextElement();
			//ist das element vom typ Auto?
			if(elem instanceof Auto)
			{
				Auto temp=(Auto)elem;
				temp.fahren();
			}
		}
		
	}
	
	
	
	
	public void testeInnereKlassen()
	{
		//versuch, ein objekt von Motor zu erzeugen:
		Auto karre=new Auto();
		Auto.Motor m=karre.new Motor(100); //erst über die referenz auf ein lebendiges auto-objekt kann 
		
		//*********
		Auto.Motor automotor=new Auto().new Motor(100);
		
		//
		IMotor v8=karre.buildMotor(230);
		v8.beschleunigung();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
