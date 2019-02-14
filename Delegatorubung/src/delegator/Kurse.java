package delegator;

public class Kurse {
	private String start;
	private String ende;
	private int raum;
	private String thema;
	private Dozenten dozent;
	
	public String getStart() {
	return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnde() {
		return ende;
	}
	public void setEnde(String ende) {
		this.ende = ende;
	}
	public int getRaum() {
		return raum;
	}
	public void setRaum(int raum) {
		this.raum = raum;
	}
	public String getThema() {
		return thema;
	}
	public void setThema(String thema) {
		this.thema = thema;
	}
	public Dozenten getDozent() {
		return dozent;
	}
	public void setDozent(Dozenten dozent) {
		this.dozent = dozent;
	}



}
