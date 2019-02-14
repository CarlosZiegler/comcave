package delegator;
//bietet Dienste an:
public class Delegator 
{
	//Delegator hält Referenz auf die Clients, damit er in ihnen Methoden aus der Schnittstelle aufrufen kann:
	private IDelegator client;
	
	public Delegator(IDelegator client)
	{
		this.client=client;
	}
	
	
	
	public double berechneWirkungsgrad()
	{
		double kw=client.getKw();
		
		
		//code für die berechnung...
		return 0;
	}
	
	
	
	public void dienstB()
	{
		
	}
	
	
	
}
