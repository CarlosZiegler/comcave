package kompositum;
//Leaf
public class Datei extends Komponente 
{

	private double dateiGroesseInByte;
	private String pfad;
	private boolean ausfuehrbar;
	
	
	public Datei(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	public double getDateiGroesseInByte() {
		return dateiGroesseInByte;
	}


	public void setDateiGroesseInByte(double dateiGroesseInByte) {
		this.dateiGroesseInByte = dateiGroesseInByte;
	}


	public String getPfad() {
		return pfad;
	}


	public void setPfad(String pfad) {
		this.pfad = pfad;
	}


	public boolean isAusfuehrbar() {
		return ausfuehrbar;
	}


	public void setAusfuehrbar(boolean ausfuehrbar) {
		this.ausfuehrbar = ausfuehrbar;
	}
	
	@Override
	public String toString()
	{
		return "Datei mit dem Namen " + getName() + ", der Größe " + getDateiGroesseInByte() + " im Verzeichnis: " + getParent().toString();
	}
	
	
	

}
