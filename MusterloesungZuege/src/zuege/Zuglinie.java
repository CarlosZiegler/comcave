package zuege;
import java.util.*;
public class Zuglinie 
{
	private TreeSet haltepunkte;
	private String bezeichner;
	
	
	
	
	
	public Zuglinie(String bezeichner) {
		super();
		this.bezeichner = bezeichner;
	}

	//methode für das hinzufügen von neuen haltepunkten
	public boolean addHaltepunkt(Haltepunkt h)
	{
		return haltepunkte.add(h);
	}
	
	/*
	 * diese methode löscht einen bereits vorhandenen haltepunkt aus dem treeset
	 * 
	 * 
	 */
	public boolean removeHaltepunkt(Haltepunkt h)
	{
		return haltepunkte.remove(h);
	}

	
	
	
	
	
	
	
	
	/*
	 * diese hashCode bezieht sich auf die attribute:
	 * 
	 * 	- haltepunkte : TreeSet
	 *  - bezeichner : String
	 * 
	 * 
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bezeichner == null) ? 0 : bezeichner.hashCode());
		result = prime * result + ((haltepunkte == null) ? 0 : haltepunkte.hashCode());
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
		Zuglinie other = (Zuglinie) obj;
		if (bezeichner == null) {
			if (other.bezeichner != null)
				return false;
		} else if (!bezeichner.equals(other.bezeichner))
			return false;
		if (haltepunkte == null) {
			if (other.haltepunkte != null)
				return false;
		} else if (!haltepunkte.equals(other.haltepunkte))
			return false;
		return true;
	}
	
	
	
	
	
}
