package delegator;

public class Maschine implements IDelegator
{
	private double kw;
	//Referenz auf ein Delegator-Objekt:
	private Delegator delegator;
	
	public Maschine()
	{
		delegator=new Delegator(this);
	}
	

	public double getKw() {
		return kw;
	}

	public void setKw(double kw) {
		this.kw = kw;
	}


	public Delegator getDelegator() {
		return delegator;
	}
	
	
	
}
