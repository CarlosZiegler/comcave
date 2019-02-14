package generics;

public class Artikel {
	private String artikelNr;
	private String bezeichnung;
	public Artikel(String bezeichnung) {
		super();
		
		this.bezeichnung = bezeichnung;
	}
	public String getArtikelNr() {
		return artikelNr;
	}
	public void setArtikelNr(String artikelNr) {
		this.artikelNr = artikelNr;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikelNr == null) ? 0 : artikelNr.hashCode());
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikel other = (Artikel) obj;
		if (artikelNr == null) {
			if (other.artikelNr != null)
				return false;
		} else if (!artikelNr.equals(other.artikelNr))
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		return true;
	}
	
	
	
	
}
