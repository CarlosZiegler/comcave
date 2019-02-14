package collections;

import java.util.Comparator;

public class BrotSortierer implements Comparator{

	private String sortierRichtung;
	
	public BrotSortierer(String sortierrichtung) {
		this.sortierRichtung=sortierrichtung;
	}
	
	public BrotSortierer()
	{
		
	}
	
	//compare nutzt dieselbe Logik wie die compareTo !
	
	//sortieren nach brot-name(lexikographisch):
	@Override
	public int compare(Object o1, Object o2) 
	{
		return ((Brot)o1).getName().compareTo(((Brot)o2).getName());
	}

}
