package delegator;

public class Fahrzeug implements IDelegator
{

	private double kw;
	//der delegator
	private Delegator delegator;
	
	public Fahrzeug()
	{
		delegator=new Delegator(this);
	}

	public double getKw() {
		return kw;
	}

	public Delegator getDelegator() {
		return delegator;
	}
	
	
	
	
	
}
