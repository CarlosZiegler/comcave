import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game implements Serializable {

	private ArrayList<String> listFragen;
	private int idGame;
	private String modul;
	private int anzahlRichtig;
	private int anzahlFalse;
	private ArrayList<Spieler> spieler;
	private boolean spielmodus;
	private boolean fragenErstellen;

	public boolean isSpielmodus() {
		return spielmodus;
	}

	public void setSpielmodus(boolean spielmodus) {
		this.spielmodus = spielmodus;
	}

	public boolean isFragenErstellen() {
		return fragenErstellen;
	}

	public void setFragenErstellen(boolean fragenErstellen) {
		this.fragenErstellen = fragenErstellen;
	}

	public ArrayList<Spieler> getSpieler() {
		return spieler;
	}

	public void setSpieler(Spieler e) {
		this.spieler.add(e);
	}

	public Game(Spieler s) {
		super();
		spieler = new ArrayList<Spieler>();
		listFragen = new ArrayList<String>();
		this.setSpieler(s);
		this.idGame = new Random().nextInt(15) + 1;
		this.spielmodus = true;
		this.setModul();

	}

	public void fragenErstellen() throws IOException {
		int wahl = 0;
		String tema = "";
		String pfad = "";
		Scanner key = new Scanner(System.in);
		System.out.println("Whalen Sie bitte das Thema: ");
		System.out.println("(1) Allgemeinwissen");
		System.out.println("(2) Informatik");
		System.out.println("(3) Geographie");
		System.out.println("(4) Geschichte");
		System.out.println("(5) Naturwissenschaften");
		wahl = key.nextInt();
		switch (wahl) {
		case 1:
			pfad = "docs/FragenAllgemmeinwissen.txt";
			tema = "Naturwissenschaften";
			break;
		case 2:
			pfad = "docs/fragenGechichte.txt";
			tema = "Informatik";
			break;
		case 3:
			pfad = "docs/FragenGeographie.txt";
			tema = "Geographie";
			break;
		case 4:
			pfad = "docs/FragenInformatik.txt";
			tema = "Geschichte";
			break;
		case 5:
			pfad = "docs/FragenNaturWissenschaften.txt";
			tema = "Allgemmeinwissen";
			break;
		}
		String text;
		Scanner schreiben = new Scanner(System.in);
		RandomAccessFile themeDatei = new RandomAccessFile(pfad, "rw");
		themeDatei.seek(themeDatei.length());
		boolean bleiben = true;
		while (bleiben) {
			System.out.println("Schreiben Sie bitte die Fragen:");
			text = schreiben.nextLine();
			themeDatei.writeChars(text);
			System.out.println("Schreiben Sie bitte die Antwort1:");
			text = ";" + schreiben.nextLine();
			themeDatei.writeChars(text);
			System.out.println("Schreiben Sie bitte die Antwort2:");
			text = ";" + schreiben.nextLine();
			themeDatei.writeChars(text);
			System.out.println("Schreiben Sie bitte die Antwort3:");
			text = ";" + schreiben.nextLine();
			themeDatei.writeChars(text);
			System.out.println("Schreiben Sie bitte die Antwort4:");
			text = ";" + schreiben.nextLine();
			themeDatei.writeChars(text);
			System.out.println("Schreiben Sie bitte die RICHTIG Antwort:");
			text = ";" + schreiben.nextLine();
			themeDatei.writeUTF(text);

			System.out.println("Mochtest du noch Fragen in der Thema " + tema + " ? (1) Ja oder (2) Nein:");
			wahl = key.nextInt();
			if (wahl == 1) {
				bleiben = true;
			} else {
				bleiben = false;
				schreiben.close();
				themeDatei.close();
			}
		}
	}

	public void testFragen(Spieler spieler) throws IOException {

		Scanner input = new Scanner(System.in);
		String zeile;
		int cont = 0;

		ArrayList<String> a = this.getListFragen();

		ArrayList<String> temporalList = this.getListFragen();
		while ((this.getListFragen().size() > 0) && (spieler.getHistory() < 3) && (spieler.getPunkt() > 0)) {

			int nummerRandon = new Random().nextInt(this.listFragen.size());

			String string = temporalList.get(nummerRandon);
			cont++;
			String[] frageZeile = string.split(";");
			System.out.println("");
			System.out.println("Frage Nr.: " + cont);
			System.out.println(frageZeile[0]);
			System.out.println("A:" + frageZeile[1]);
			System.out.println("B:" + frageZeile[2]);
			System.out.println("C:" + frageZeile[3]);
			System.out.println("D:" + frageZeile[4]);
			System.out.println("Antwort:");
			String key = input.nextLine();

			String antwort = "";
			switch (key.toUpperCase()) {
			case "A":
				antwort = frageZeile[1];
				break;
			case "B":
				antwort = frageZeile[2];
				break;
			case "C":
				antwort = frageZeile[3];
				break;
			case "D":
				antwort = frageZeile[4];
				break;
			case "H":
				this.lesenMenu();
				continue;
			case "S":
				this.status();
				continue;
			}

			if (antwort.equals(frageZeile[5])) {
				System.out.println("Antwort ist Richtig!!");
				spieler.setPunkt(1);
				spieler.setHistory(0);
				this.setAnzahlRichtig(1);
			} else {
				System.out.println("Antwort ist Falsche!!");
				spieler.setPunkt(-1);
				spieler.summeHistory(1);
				this.setAnzahlFalse(1);

			}
			System.out.println("Ihr Punktstand ist : " + spieler.getPunkt());
			temporalList.remove(nummerRandon);
			System.out.println(temporalList.size());
		}

		if (this.getListFragen().size() == 0) {
			System.out.println("--------------------------Test Beenden---------------------------- ");
			System.out.println("Ihre Ergebnisse: ");
			this.status();
			this.lesenMenu();

		}
		if ((spieler.getHistory() == 3) || (spieler.getPunkt() == 0)) {
			System.out.println("--------------------------Test Beenden---------------------------- ");
			System.out.println("*******************************************************************");
			System.out.println("                   Du hast nicht geschaft!!!!!!!!!!                ");
			System.out.println("*******************************************************************");
			this.status();
			this.lesenMenu();

		}

	}

	public ArrayList<String> getListFragen() {
		return listFragen;
	}

	public void setListFragen() {
		// lesen alles Textdatei
		int item = 0;
		String pfad = "";
		while (item < 6) {
			++item;
			if (item == 1) {
				pfad = "docs/FragenAllgemmeinwissen.txt";
			} else if (item == 2) {
				pfad = "docs/fragenGechichte.txt";
			} else if (item == 3) {
				pfad = "docs/FragenGeographie.txt";
			} else if (item == 4) {
				pfad = "docs/FragenInformatik.txt";
			} else if (item == 5) {
				pfad = "docs/FragenNaturWissenschaften.txt";
			}
			String zeile;
			BufferedReader buff = null;

			// add Fragen
			try {
				buff = new BufferedReader(new FileReader(pfad));
				while ((zeile = buff.readLine()) != null) {
					this.listFragen.add(zeile);

				}
			} catch (IOException e) {
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

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public String getModul() {
		return modul;
	}

	public void setModul() {
		if (this.isSpielmodus()) {
			this.modul = "Spielmodus";
			this.setFragenErstellen(false);
			;
		} else {
			this.modul = "Fragen Erstellen Modus";
			this.setSpielmodus(false);
		}

	}

	public int getAnzahlRichtig() {
		return anzahlRichtig;
	}

	public void setAnzahlRichtig(int anzahlRichtig) {
		this.anzahlRichtig += anzahlRichtig;
	}

	public int getAnzahlFalse() {
		return anzahlFalse;
	}

	public void setAnzahlFalse(int anzahlFalse) {
		this.anzahlFalse += anzahlFalse;
	}

	public void startGame() {

	}

	public void status() {
		System.out.println("-----------Status-----------");
		System.out.println("Game ID: " + this.idGame);
		System.out.println("Modus  : " + this.getModul());
		if (this.getModul() == "Spielmodus") {
			System.out.println("Richtig: " + this.getAnzahlRichtig());
			System.out.println("Falsche: " + this.getAnzahlFalse());
			System.out.println("Punkt  : " + this.getSpieler().get(0).getPunkt());
			System.out.println("----------------------------");
		}

	}

	public void lesenMenu() throws IOException {
		int wahlen;
		System.out.println("-------------------------");
		System.out.println("-      (M)MENU          -");
		System.out.println("-( 1 ) New Game         -");
		System.out.println("-( 2 ) Load Game        -");
		System.out.println("-( 3 ) Fragen Erstellen -");
		System.out.println("-( 5 ) Quit und Save    -");
		System.out.println("-------------------------");
		wahlen = new Scanner(System.in).nextInt();
		switch (wahlen) {
		case 1:

			int index = this.getSpieler().size() - 1;
			this.testFragen(this.getSpieler().get(index));
			break;

		case 3:
			
			this.fragenErstellen();
			break;
		default:
			break;
		}

	}

}
