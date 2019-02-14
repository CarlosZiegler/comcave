package delegator;

public class Seminarteilnehmer extends Person {

	private Delegator delegator;
	 public Seminarteilnehmer() {
		 
		 delegator = new Delegator(this);
	 }
	public Delegator getDelegator() {
		return delegator;
	}
	
	
}
