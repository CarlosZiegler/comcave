package inheritance;

public class Mensch extends Lebewesen
{

	public Mensch(int alter)
	{
		super(null);
		setAlter(alter);
		
	}
	
	public Mensch()
	{
		this(5);
	}
	
	
	
	public void testKonstruktor()
	{
		Mensch(5);
	}
	
	public void Mensch(int a)
	{
		
	}
	
	public void Mensch()
	{
		
	}
	
	//�berladen der methode bewegen auch in unterklassen m�glich!
	public void bewegen(int geschwindigkeit, String ziel)
	{
		
	}
	
	@Override
	public void bewegen()
	{
		
	}
	
	@Override
	public Mensch gebaeren()
	{
		return new Mensch();
	}
	
}
