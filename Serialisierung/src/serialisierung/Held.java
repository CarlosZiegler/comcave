package serialisierung;

import java.io.Serializable;

public class Held extends MenschenWesen
{
	
	private Delegator del;
	
	public Held(String name, int lebensEnergie) {
		super(name, lebensEnergie);
		del=new Delegator();
	}
	
	
	
	
	
	
}
