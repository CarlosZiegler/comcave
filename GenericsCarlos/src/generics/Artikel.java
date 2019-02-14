package generics;

public class Artikel {
	private String artikelNr;
	private String artikelBezeichnung;

	public String getArtikelNr() {
		return artikelNr;
	}

	public void setArtikelNr(String artikelNr) {
		this.artikelNr = artikelNr;
	}

	public String getArtikelBezeichnung() {
		return artikelBezeichnung;
	}

	public void setArtikelBezeichnung(String artikelBezeichnung) {
		this.artikelBezeichnung = artikelBezeichnung;
	}

	public Artikel(String artikelBezeichnung) {
		super();

		this.artikelBezeichnung = artikelBezeichnung;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikelBezeichnung == null) ? 0 : artikelBezeichnung.hashCode());
		result = prime * result + ((artikelNr == null) ? 0 : artikelNr.hashCode());
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
		if (artikelBezeichnung == null) {
			if (other.artikelBezeichnung != null)
				return false;
		} else if (!artikelBezeichnung.equals(other.artikelBezeichnung))
			return false;
		if (artikelNr == null) {
			if (other.artikelNr != null)
				return false;
		} else if (!artikelNr.equals(other.artikelNr))
			return false;
		return true;
	}

	
	
}
