package delegator;

public class Motorboot extends Boot implements IDelegator
{
	private double kw;
	private Delegator del;
	
	public Motorboot()
	{
		del=new Delegator(this);
	}

	@Override
	public double getKw() {
		return kw;
	}
	
	
	
}
