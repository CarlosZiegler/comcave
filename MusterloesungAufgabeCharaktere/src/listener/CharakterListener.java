package listener;

public class CharakterListener 
{
	private ISubject[] subjekte;
	private int aktAnzSubjekte;
	
	
	public CharakterListener(int maxAnzahlSubjekte)
	{
		subjekte=new ISubject[maxAnzahlSubjekte];
	}
	
	//registrierung neuer subjekte
	public void registerSubject(ISubject subject)
	{
		if(aktAnzSubjekte<subjekte.length)
		{
			subjekte[aktAnzSubjekte++]=subject;
		}
	}
	
	//alle benachrichtigen
	public void fireUpdate(charakter.Charakter charakter)
	{
		for(ISubject sub : subjekte)
		{
			if(sub!=null)
			{
				sub.update(charakter);
			}
		}
	}
	
	
	
	
	
	
	
}
