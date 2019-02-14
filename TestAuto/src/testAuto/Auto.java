package testAuto;

public class Auto {
	private int anzPs;
	 

	
	public Auto(int anzPs) {
		super();
		this.anzPs = anzPs; 
	}

	public int getAnzPs() {
		return anzPs;
	}

	public void setAnzPs(int anzPs) {
		this.anzPs = anzPs;
	}
	
	public String berechnungSchadstoffKlasse() {
		String klasse = null;
		 if (anzPs <= 75) {
			klasse ="Gruen";
		} if (anzPs > 75 &&anzPs <= 100) {
			klasse ="Gelb";
		}if (anzPs > 100 &&anzPs <= 140) {
			klasse ="Blau";
		}if (anzPs > 140) {
			klasse ="Rot";
		}
		return klasse;
		
		
	}
	 
}
