package innere;

public class ElementSammlung 
{
	//die elemente
	private Object[] elemente;
	private int anzElemente;
	
	
	public ElementSammlung(int maxAnzahlElemente)
	{
		elemente=new Object[maxAnzahlElemente];
	}
	
	
	//element hinzuf�gen
	public void addElement(Object elem)
	{
		if(anzElemente<elemente.length)
		{
			elemente[anzElemente++]=elem;
		}
	}
	
	
	//weitere element-sammlungs-methoden....
	
	
	//methode, welche einen iterator an den aufrufer zur�ckgibt:
	public ISammlungIterator iterator()
	{
		return new SammlungIterator();
	}
	
	
	//Innere Klassen(n) als Iterator
	private class SammlungIterator implements ISammlungIterator
	{

		private int aktuellePosition;
	
		@Override
		public Object nextElement() 
		{
			return elemente[aktuellePosition++];
		}

		@Override
		public boolean elementVorhanden() 
		{
			return elemente[aktuellePosition]!=null;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
