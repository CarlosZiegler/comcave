package folge;
import java.util.Random;

public class Aufzaehlung {
 
	private Zahl[] zahlen;
	private int obergrenze;
	
	public Aufzaehlung(int anzZahlen, int obergrenze)
	{
		this.obergrenze = obergrenze;
		zahlen = new Zahl[anzZahlen];
		initRandom();
	}

	private class Zahl{
		private int zahl;
		
		public Zahl(int wert) {
			this.zahl = wert;
		}

		public int getZahl() {
			return zahl;
		}

		public void setZahl(int zahl) {
			this.zahl = zahl;
		}
		
		
	}
	private void initRandom()
	{
		Random zufallsGen = new Random();
		
		
		
		for(int i = 0; i < zahlen.length; i++)
		{
			zahlen[i] = new Zahl(zufallsGen.nextInt(obergrenze)+1);
		}
			
	}
	
	public IFolge iterator()
	{
		return new Reihenfolge();
	}
	
	private class Reihenfolge implements IFolge
	{
		
		private int position;

		@Override
		public boolean elementVorhanden() {
		
			boolean exist = false;
			if (position < zahlen.length) {
				exist = zahlen[position] != null;
				
			}
			return exist;
		}

		@Override
		public Object getNextElement() 
		{
            return zahlen[position++].getZahl();	
		}
		
	}

	public Object getElementAt(int index) {
		
		if(index < zahlen.length && index >= 0) {
			return zahlen[index].getZahl();
		}
		else {
			return null;
		}
		
	}








}
