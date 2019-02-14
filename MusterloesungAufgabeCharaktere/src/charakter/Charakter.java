package charakter;
import eigenschaften.*;
public class Charakter 
{
	private EName name;
	private EWaffe waffe;
	private ERasse rasse;
	private Planquadrat id;
	private listener.CharakterListener listener;
	
	
	public Charakter()
	{
		super();
	}
	
	
	
	public Charakter(Planquadrat id) {
		super();
		this.id = id;
	}
	
	//charakter über planquadrate bewegen(1-100)
	public boolean move(int pos)
	{
		boolean bewegungGelungen=false;
		if(pos>=1 && pos<=100) //compound operator
		{
			//bewegt sich charakter nach oben/unten?
			if(id.getNummer()+10==pos || id.getNummer()-10==pos)
			{
				bewegungGelungen=true;
			}
			else if(id.getNummer()+1==pos || id.getNummer()-1==pos)
			{
				//ist bewegung noch innerhalb der stadt?
				
				//aktuelle bewegung nach links?
				if(id.getNummer()-1==pos)
				{
					int x=(id.getNummer() % 10) - 1;
					if(x!=0)
					{
						bewegungGelungen=true;
					}
				}
				
				//aktuelle bewegung nach rechts?
				if(id.getNummer()+1==pos)
				{
					int x=(id.getNummer() % 10);
					if(x!=0)
					{
						bewegungGelungen=true;
					}
				}
				
				
			}
			//wenn bewegung zulässig, dann prüfen, ob zielplanquadrat besetzt ist
			if(bewegungGelungen)
			{
				if(id.isBesetzt())
				{
					bewegungGelungen=false;
				}
			}
			
		}
		if(bewegungGelungen)
		{
			//dem listener mitteilen dass der charakter sich bewegt hat
			listener.fireUpdate(this);
		}
		
		
		return bewegungGelungen;
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public listener.CharakterListener getListener() {
		return listener;
	}



	public void setListener(listener.CharakterListener listener) {
		this.listener = listener;
	}



	public EName getName() {
		return name;
	}
	public void setName(EName name) {
		this.name = name;
	}
	public EWaffe getWaffe() {
		return waffe;
	}
	public void setWaffe(EWaffe waffe) {
		this.waffe = waffe;
	}
	public ERasse getRasse() {
		return rasse;
	}
	public void setRasse(ERasse rasse) {
		this.rasse = rasse;
	}
	public Planquadrat getId() {
		return id;
	}
	public void setId(Planquadrat id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
