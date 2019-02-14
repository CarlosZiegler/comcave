package studenten;

public enum Faechern {
	BWL(10), GRAFIK(6), INFORMATIK(4);
					
	private int regelstudienzeit;
	
	private Faechern(int regelstudienzeit) {
		this.regelstudienzeit = regelstudienzeit;
		
	}

	public int getRegelstudienzeit() {
		return regelstudienzeit;
	}

	public void setRegelstudienzeit(int regelstudienzeit) {
		this.regelstudienzeit = regelstudienzeit;
	}

}
