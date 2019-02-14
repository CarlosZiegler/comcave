package collections;

public class Auto 
{
	private int ps;
	private String typ;
	
	
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	/*
	 *  Der Vertrag zwischen equals und hashCode:
	 *  
	 *  	-> Solange sich ein Objekt nicht ändert, muss die hashCode immer denselben Wert liefern!
	 *  	-> Wenn für zwei Objekte die hashCode verschiedene Werte liefert, gelten diese beiden als ungleich
	 *  		-> die equals darf dann nicht true liefern für den Vergleich dieser beiden Objekte!
	 *  
	 *  	-> Wenn für zwei Objekte die hashCode identische Werte liefert, dann können diese beiden Objekte
	 *  	   inhaltlich gleich sein -> Die equals wird dann zusätzlich bemüht, um diese Gleichheit endgültig
	 *  	   festzustellen!
	 *  
	 *  	-> Wenn für zwei Objekte die equals true liefert, dann MUSS für diese beiden Objekte die hashCode
	 *  	   identische Werte liefern
	 *  
	 *  		-> Deshalb müssen in der hashCode alle Attribute einfliessen, welche in der equals verglichen werden!

	 */
	
	
	
	
	@Override
	public boolean equals(Object obj)
	{
		//als erstes ein referenzvergleich:
		if(this==obj)
		{
			return true;
		}
		//steckt hinter obj auch ein objekt?
		if(obj!=null)
		{
			
			//steckt nun hinter obj ein auto?
			if(obj instanceof Auto)
			{
				Auto temp=(Auto)obj;
				//für die gleichheit relevante attribute vergleichen
				if(this.ps==temp.getPs() && this.typ.equals(temp.getTyp()))
				{
					return true;
				}
			}
		}
		return false;
		
	}
	
	@Override
	public int hashCode()
	{
		int faktor=33;
		int hash=1;
		hash*= faktor + ps;
		if(typ!=null)
		{
			hash*= faktor + typ.hashCode();
		}
		else
		{
			hash*=faktor;
		}
		
		return hash;
	}
	
	
	
	
	
	
	
}
