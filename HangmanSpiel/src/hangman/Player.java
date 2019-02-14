package hangman;

public class Player {
	private String name;
	private int lebenspunkt;

	public Player(String name) {
		super();
		this.name = name;
		this.lebenspunkt = 6;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLebenspunkt() {
		return lebenspunkt;
	}

	public void setLebenspunkt(int lebenspunkt) {
		this.lebenspunkt = lebenspunkt;
	}
	
	

}
