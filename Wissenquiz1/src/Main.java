
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Spieler carlos = new Spieler("Carlos");
		Game game001 = new Game(carlos);
		
		game001.setListFragen();
		game001.lesenMenu();
		System.out.println(game001.getListFragen().size());
		//game001.testFragen(carlos);
		//game001.status();
		//game001.leseFragen(carlos);
	}

	
}
