package lambdas;
import java.util.function.*;


public class TuerSteher 
{

	public boolean eintrittOK(Gast gast, Predicate<Gast> p)
	{
		if(p.test(gast))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
}
