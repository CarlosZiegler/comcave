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
	 *  	-> Solange sich ein Objekt nicht �ndert, muss die hashCode immer denselben Wert liefern!
	 *  	-> Wenn f�r zwei Objekte die hashCode verschiedene Werte liefert, gelten diese beiden als ungleich
	 *  		-> die equals darf dann nicht true liefern f�r den Vergleich dieser beiden Objekte!
	 *  
	 *  	-> Wenn f�r zwei Objekte die hashCode identische Werte liefert, dann k�nnen diese beiden Objekte
	 *  	   inhaltlich gleich sein -> Die equals wird dann zus�tzlich bem�ht, um diese Gleichheit endg�ltig
	 *  	   festzustellen!
	 *  
	 *  	-> Wenn f�r zwei Objekte die equals true liefert, dann MUSS f�r diese beiden Objekte die hashCode
	 *  	   identische Werte liefern
	 *  
	 *  		-> Deshalb m�ssen in der hashCode alle Attribute einfliessen, welche in der equals verglichen werden!

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
				//f�r die gleichheit relevante attribute vergleichen
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
