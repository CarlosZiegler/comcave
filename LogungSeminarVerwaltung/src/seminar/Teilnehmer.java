package seminar;

public class Teilnehmer implements IKursinfo {
	private String name;
	private String vorname;
	private String telNr;
	private int teilnehmerNR;
	private Seminarverwaltung verwaltung;
	
	
	
	public Teilnehmer(String name, String vorname, String telNr) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.telNr = telNr;
		verwaltung = Seminarverwaltung.getVerwaltung();
	}
	public Teilnehmer(String name, String vorname, String telNr, int teilnehmerNR) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.telNr = telNr;
		this.teilnehmerNR = teilnehmerNR;
		verwaltung = Seminarverwaltung.getVerwaltung();
	}
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
	public int getTeilnehmerNR() {
		return teilnehmerNR;
	}
	public void setTeilnehmerNR(int teilnehmerNR) {
		this.teilnehmerNR = teilnehmerNR;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return String.valueOf(teilnehmerNR);
	}

	public void dienstA(Seminar seminar) {
		
		verwaltung.getSeminarInfo(seminar);
		
	}
		
	
}
