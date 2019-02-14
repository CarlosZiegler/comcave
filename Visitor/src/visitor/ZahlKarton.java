package visitor;

public class ZahlKarton extends KartonComponent
{

	
	private int zahl;
	
	public ZahlKarton(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public int getZahl() {
		return zahl;
	}

	public void setZahl(int zahl) {
		this.zahl = zahl;
	}

	@Override
	public void accept(IVisitor v) 
	{
		v.visitZahlKarton(this);
		
	}

	
	
	
	
}
