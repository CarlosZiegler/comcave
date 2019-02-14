package kompositum;
//Container
public class Verzeichnis extends Komponente 
{

	private Komponente[] inhalt;
	private int aktuelleAnzKomponenten;
	
	public Verzeichnis(String name) 
	{
		super(name);
		inhalt=new Komponente[100];
	}
	
	
	//element in das verzeichnins einf�gen
	public void addElement(Komponente comp)
	{
		if(aktuelleAnzKomponenten < inhalt.length)
		{
			inhalt[aktuelleAnzKomponenten++]=comp;
			comp.setParent(this);
		}
	}
	
	
	@Override
	public String toString() //toString steht f�r die Standardzeichenkettenrepr�sentation des Objekts
	{
		return "Verzeichnis mit dem Namen " + getName() + " und " + aktuelleAnzKomponenten + " Elementen";
	}
	
	
	
	
	
	
}
