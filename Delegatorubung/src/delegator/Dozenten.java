package delegator;

import java.util.Date;

public class Dozenten extends Person  {
 private Delegator delegator;
 public Dozenten() {
	 
	 delegator = new Delegator(this);
 }
public Delegator getDelegator() {
	return delegator;
}
	
		
}
