package charakter;

public class Stadt 
{
	private Planquadrat[] planquadrate;
	private int maxAnzCharaktere;
	
	public Stadt(int maxAnzCharaktere)
	{
		planquadrate=new Planquadrat[100];
		this.maxAnzCharaktere=maxAnzCharaktere;
	}
	
	//füllt das planquadrat-array mit leeren planquadraten und vergibt dessen nummern(1-100)
	public void initPlanquadrate()
	{
		for(int i=0;i<planquadrate.length;i++)
		{
			planquadrate[i]=new Planquadrat();
			planquadrate[i].setNummer(i+1);
		}
	}
	
	//liefert einen planquadrat an einer bestimmten stelle(1-100)
	public Planquadrat getPlanquadratAt(int nummer)
	{
		if(nummer==0)
		{
			nummer=1;
		}
		return planquadrate[nummer-1];	
	}
	
	

	public Planquadrat[] getPlanquadrate() {
		return planquadrate;
	}

	public void setPlanquadrate(Planquadrat[] planquadrate) {
		this.planquadrate = planquadrate;
	}

	public int getAnzCharaktere() {
		return maxAnzCharaktere;
	}

	public void setAnzCharaktere(int anzCharaktere) {
		this.maxAnzCharaktere = anzCharaktere;
	}
	
	
	
	
	
	
	
	
	
	
	
}
