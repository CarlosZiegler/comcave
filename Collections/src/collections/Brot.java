package collections;

public class Brot implements Comparable
{
	private String name;
	private int gewichtInGramm;
	
	
	public Brot(String name, int gewichtInGramm) {
		super();
		this.name = name;
		this.gewichtInGramm = gewichtInGramm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGewichtInGramm() {
		return gewichtInGramm;
	}
	public void setGewichtInGramm(int gewichtInGramm) {
		this.gewichtInGramm = gewichtInGramm;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gewichtInGramm;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brot other = (Brot) obj;
		if (gewichtInGramm != other.gewichtInGramm)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	/*
	 * 	Die Entscheidungslogik der compareTo():
	 * 
	 * 		-> Wenn die compareTo() eine 0 liefert, dann gelten die beiden verglichenen Objekte als gleichwertig
	 * 
	 * 		-> Wenn die compareTo() eine 1 liefert, dann ist das AKTUELLE Objekt GRÖSSER als das übergebene!
	 * 
	 * 		-> Wenn die compareTo() eine -1 liefert, dann ist das AKTUELLE Objekt KLEINER als das übergebene!
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	//Brote nach Gewicht aufsteigend sortieren:
	@Override
	public int compareTo(Object o) 
	{
		
		int gewichtung=0;
		if(o instanceof Brot)
		{
			Brot temp=(Brot)o;
			
			if(this.gewichtInGramm<temp.getGewichtInGramm())
			{
				gewichtung=-1;
			}
			else if(this.gewichtInGramm>temp.getGewichtInGramm())
			{
				gewichtung=1;
			}
		}
		
		return gewichtung;
	}
	
	
	
	
}
