package hangman;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static Game game;

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Scanner a = new Scanner(System.in);
		boolean verify = true;
		while (verify) {
			System.out.println("----------------------------------");
			System.out.println("-              Menu              -");
			System.out.println("----------------------------------");
			System.out.println("( 1 )New Game");
			System.out.println("( 2 )Exit Game");
			String key = a.nextLine();
			int pass = 3;
			try {
				pass = Integer.parseInt(key);
				if (pass == 1) {
					start();
				} else if (pass == 2) {
					verify = false;
				} else {
					verify = false;

				}
			} catch (Exception e) {
				System.out.println("Diese Option ist nicht vorhanden. Versuchen Sie es erneut" + e.getMessage());
			} finally {

			}

		}
	}

	public static void start() {
		StringBuilder verify = new StringBuilder();
		StringBuilder wort = new StringBuilder();
		ArrayList<String> buschstabe = new ArrayList<String>();
		ArrayList<String> antwort = new ArrayList<String>();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < alphabet.length(); i++) {
			buschstabe.add(String.valueOf(alphabet.charAt(i)));
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Schreiben Sie bitte deinen Name");
		String input = scanner.nextLine();
		Player player1 = new Player(input);
		game = new Game(player1);
		System.out.println(
				"Player: " + game.getPlayer().getName() + " || Lebenspunkt: " + game.getPlayer().getLebenspunkt());
		System.out.println();
		String wortNr = Integer.toString(new Random().nextInt((game.getWort().size())));
		String[] wortUndThema = game.getWort().get(wortNr).split(":");
		String thema = wortUndThema[1];
		wort.append(wortUndThema[0]);

		int cont = 3;
		while (cont > 0) {// game.getPlayer().getLebenspunkt() >0 || wort.length() >0
			System.out.println("Das Theme ist : " + wortUndThema[1].toUpperCase());
			for (int i = 0; i < wort.length(); i++) {
				System.out.print(" __ ");

			}
			System.out.println("\n\n");
			for (String string : buschstabe) {
				System.out.print("-" + string + "-");
			}

			System.out.println();
			System.out.println("Antwort: ");
			Scanner input2 = new Scanner(System.in);
			String antwortWhal = input2.nextLine();
			while (antwort.contains(antwortWhal)) {
				System.out.println("Sie gaben schon diese Buschstaben benutzt! Versucht nochmal");
				System.out.println("Antwort: ");
				antwortWhal = input2.nextLine();
			}
			System.out.println(antwortWhal);
			antwort.add(antwortWhal.toUpperCase());
			verify.append(antwortWhal.toLowerCase());
			System.out.println(verify);
			System.out.println(wort.equals(verify));
			if (wort.equals(verify)) {
				System.out.println("Tem a letra. ");
			}
			System.out.println();
			cont--;
		}

		System.out.println();
		buschstabe.remove("C");

		// System.out.println(buschstabe.size());

		// System.out.println();

	}
}
