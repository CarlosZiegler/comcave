package seminar;

public class Dozent implements IKursinfo{
	private String name;
	private String vorname;
	private String telNr;
	private String fachbereich;
	private int dozentNR;
	private Seminarverwaltung verwaltung;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getTelNr() {
		return telNr;
	}
	public void setTelNr(String telNr) {
		this.telNr = telNr;
	}
	public String getFachbereich() {
		return fachbereich;
	}
	public void setFachbereich(String fachbereich) {
		this.fachbereich = fachbereich;
	}
	public int getDozentNR() {
		return dozentNR;
	}
	public void setDozentNR(int dozentNR) {
		this.dozentNR = dozentNR;
	}
	public Dozent(String name, String vorname, String telNr) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.telNr = telNr;
		verwaltung = Seminarverwaltung.getVerwaltung();
	}
	public Dozent(String name, String vorname, String telNr, String fachbereich, int dozentNR) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.telNr = telNr;
		this.fachbereich = fachbereich;
		this.dozentNR = dozentNR;
		verwaltung = Seminarverwaltung.getVerwaltung();
	}
	@Override
	public String getId() {
		return String.valueOf(dozentNR);
	}
	
	
	
}
