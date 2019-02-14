package seminar;

public class Seminar {
	private String thema;
	private Teilnehmer[] teilnehmer;
	private Dozent dozent;
	private String raum;
	private String start;
	private String ende;
	private int anzTeilnehmer;

	public Seminar(String thema) {
		super();
		this.thema = thema;
		teilnehmer = new Teilnehmer[25];
		anzTeilnehmer = 0;
	}

	public Seminar(String thema, Dozent dozent, String raum, String start, String ende) {
		this.thema = thema;
		this.dozent = dozent;
		this.raum = raum;
		this.start = start;
		this.ende = ende;
	}

	public void addTeilnehmer(Teilnehmer tn) {
		if (anzTeilnehmer < teilnehmer.length) {
			teilnehmer[anzTeilnehmer++] = tn;

		} else {
			System.out.println("Error - Kurs ist voll");
		}

	}
	
	public int getAnzTeilnehmer() {
		return anzTeilnehmer;
	}

	public void setAnzTeilnehmer(int anzTeilnehmer) {
		this.anzTeilnehmer = anzTeilnehmer;
	}

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public IKursinfo[] getTeilnehmer() {
		return teilnehmer;
	}

	
	public IKursinfo getDozent() {
		return dozent;
	}

	public void setDozent(Dozent dozent) {
		this.dozent = dozent;
	}

	public String getRaum() {
		return raum;
	}

	public void setRaum(String raum) {
		this.raum = raum;
	}

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

}
