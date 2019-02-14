import java.io.Serializable;

public class Spieler implements Serializable {

	private String name;
	private int punkt;
	private int history;
	private int nummerAntwort;

	public Spieler(String name) {
		super();
		this.name = name;
		this.punkt = 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPunkt() {
		return punkt;
	}

	public void setPunkt(int punkt) {
		this.punkt+= punkt;
	}

	public int getHistory() {
		return history;
	}

	public void summeHistory(int history) {
		this.history+= history;
	}

	public void setHistory(int history) {
		this.history= history;
	}
	public int getNummerAntwort() {
		return nummerAntwort;
	}

	public void setNummerAntwort(int nummerAntwort) {
		this.nummerAntwort = nummerAntwort;
	}

}
