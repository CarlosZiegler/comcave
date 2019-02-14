package visitor;

public class ContainerKarton extends KartonComponent
{
	private KartonComponent[] inhalt;
	private int anzKomponenten;
	
	public ContainerKarton(String name)
	{
		super(name);
		inhalt=new KartonComponent[100];
	}
	
	
	public void add(KartonComponent comp)
	{
		if(anzKomponenten<inhalt.length)
		{
			inhalt[anzKomponenten++]=comp;
			comp.setParent(this);
		}
	}


	@Override
	public void accept(IVisitor v) {
		//alle unterkomponente im container durchlaufen und beim durchlaufen immer die jeweilige accept aufrufen und den
		//visitor übergeben:
		for(int i=0;i<inhalt.length;i++)
		{
			//ist da überhaupt an der stelle im array ein karton?
			if(inhalt[i]!=null)
			{
				inhalt[i].accept(v);
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
