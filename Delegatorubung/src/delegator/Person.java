package delegator;

import java.util.Date;

public abstract class Person implements IDelegator {
	private int id;
	private String nachName;
	private String vorName;
	private Date geburtstag;
	private String bereich;
	private String berufsBildung;
	
	public String getBerufsBildung() {
		return berufsBildung;
	}

	public void setBerufsBildung(String berufsBildung) {
		this.berufsBildung = berufsBildung;
	}

	public String getBereich() {
		return bereich;
	}

	public void setBereich(String bereich) {
		this.bereich = bereich;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNachName() {
		return nachName;
	}
	public void setNachName(String nachName) {
		this.nachName = nachName;
	}
	public String getVorName() {
		return vorName;
	}
	public void setVorName(String vorName) {
		this.vorName = vorName;
	}
	public Date getGeburtstag() {
		return geburtstag;
	}
	public void setGeburtstag(Date geburtstag) {
		this.geburtstag = geburtstag;
	}
}
