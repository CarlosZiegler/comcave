package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Game {
	private Player player;
	private HashMap<String, String> wort;

	public Game(Player player) {
		super();
		this.player = player;
		this.wort = new HashMap<String, String>();
		setListWort();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public HashMap<String, String> getWort() {
		return wort;
	}

	public void setListWort() {
		// File datein = new File("docs/fragen.txt");
		String zeile;
		BufferedReader buff = null;

		try {
			buff = new BufferedReader(new FileReader("docs/list.txt"));
			while ((zeile = buff.readLine()) != null) {
				String[] worte = zeile.split(",");
				this.wort.put(worte[0], worte[1]);
			}
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		} finally {
			try {
				if (buff != null) {
					buff.close();
				}
			} catch (IOException e2) {
				System.out.println("Erroooorrrr" + e2.getMessage());
			}

		}

	}

	
	
	
}
