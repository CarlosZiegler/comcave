
public class Game implements Iterator {
	private Charackter[] charakterAnzahl;
	private Charackter[] planquadrate;
	int position;
	

	public Game() {
		super();
		setPlanquadrate();

	}

	public Charackter[] getCharakterAnzahl() {
		return charakterAnzahl;
	}

	public void setCharakterAnzahl() {

		this.charakterAnzahl = new Charackter[12];
		for (int i = 0; i < charakterAnzahl.length; i++) {

			charakterAnzahl[i] = new Charackter();

		}
		
	}

	

	public void setPlanquadrate() {
		this.planquadrate = new Charackter[101];
	}

	public void setCharakterStadt() {
		
		for (int i = 0; i < charakterAnzahl.length; i++) {
			if (this.planquadrate[charakterAnzahl[i].getId()]!=null) {
				charakterAnzahl[i].setId();
				this.planquadrate[charakterAnzahl[i].getId()]= charakterAnzahl[i];
				
			}
			this.planquadrate[charakterAnzahl[i].getId()]= charakterAnzahl[i];
		}
		
		
	}

	public Charackter[] getPlanquadrate() {
		return planquadrate;
	}

	
	public void lesenGame() {
		
		for (int i = 0; i < this.getPlanquadrate().length; i++) {
			Charackter a = this.getPlanquadrate()[i];
			if (a != null) {
				System.out.println("" + a.getName() + " " + a.getId() );
			}else {
				System.out.println(i);
			}
			
		}
	}

	@Override
	public Charackter next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasNext() {
		
		return null;
	}
	
}
