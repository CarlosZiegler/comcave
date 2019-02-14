package charakter;

public class Planquadrat 
{

	private Charakter charakter;
	private int nummer;
	
	
	
	
	
	public Planquadrat() {
		super();
	}


	public Planquadrat(Charakter charakter, int nummer) {
		super();
		this.charakter = charakter;
		this.nummer = nummer;
	}


	public Planquadrat(Charakter charakter) {
		super();
		this.charakter = charakter;
	}


	//liefert true, wenn planquadrat einen charakter hält
	public boolean isBesetzt()
	{
		return charakter!=null;
	}


	public Charakter getCharakter() {
		return charakter;
	}


	public void setCharakter(Charakter charakter) {
		this.charakter = charakter;
	}


	public int getNummer() {
		return nummer;
	}


	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	
	
	
	
	
}
