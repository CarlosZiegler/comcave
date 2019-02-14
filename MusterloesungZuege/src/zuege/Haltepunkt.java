package zuege;

public class Haltepunkt implements Comparable
{

	private String gleis;
	private String ankunft;
	private String abfahrt;
	private Bahnhof bahnhof;
	
	
	
	public Haltepunkt(String gleis, String ankunft) {
		super();
		this.gleis = gleis;
		this.ankunft = ankunft;
	}


	public String getGleis() {
		return gleis;
	}


	public void setGleis(String gleis) {
		this.gleis = gleis;
	}


	public String getAnkunft() {
		return ankunft;
	}


	public void setAnkunft(String ankunft) {
		this.ankunft = ankunft;
	}


	public String getAbfahrt() {
		return abfahrt;
	}


	public void setAbfahrt(String abfahrt) {
		this.abfahrt = abfahrt;
	}


	public Bahnhof getBahnhof() {
		return bahnhof;
	}


	public void setBahnhof(Bahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ankunft == null) ? 0 : ankunft.hashCode());
		result = prime * result + ((bahnhof == null) ? 0 : bahnhof.hashCode());
		result = prime * result + ((gleis == null) ? 0 : gleis.hashCode());
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
		Haltepunkt other = (Haltepunkt) obj;
		if (ankunft == null) {
			if (other.ankunft != null)
				return false;
		} else if (!ankunft.equals(other.ankunft))
			return false;
		if (bahnhof == null) {
			if (other.bahnhof != null)
				return false;
		} else if (!bahnhof.equals(other.bahnhof))
			return false;
		if (gleis == null) {
			if (other.gleis != null)
				return false;
		} else if (!gleis.equals(other.gleis))
			return false;
		return true;
	}

	//wie sollen die haltepunkte in zuglinie sortiert werden?
	@Override
	public int compareTo(Object o) {
		Haltepunkt temp=(Haltepunkt)o;
		return ankunft.compareTo(temp.getAnkunft());
	}

}
