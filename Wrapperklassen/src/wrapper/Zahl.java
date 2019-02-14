package wrapper;

public class Zahl 
{
	private int zahl;

	public Zahl(int zahl) {
		super();
		this.zahl = zahl;
	}

	public int getZahl() {
		return zahl;
	}

	public void setZahl(int zahl) {
		this.zahl = zahl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + zahl;
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
		Zahl other = (Zahl) obj;
		if (zahl != other.zahl)
			return false;
		return true;
	}
	
	
	
	
}
