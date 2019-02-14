package inheritance;

public class Fisch extends Lebewesen 
{

	public Fisch(String bezeichnung) 
	{
		super(bezeichnung);
		
	}
	
	
	
	@Override
	public void atmen()
	{
		System.out.println("Ich atme mit Kiemen....");
	}
	
	
	//Spezielle Fisch-Methoden
	public void schwimmen()
	{
		System.out.println("Ich bin ein Fisch und kann schwimmen");
	}
	

}
