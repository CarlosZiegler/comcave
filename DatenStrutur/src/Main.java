import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		File datein = new File("docs/fragen.txt");

		int zeichen;
		FileReader fr = null;
		try {
			fr = new FileReader(datein);
			while (((zeichen = fr.read()) != -1)) {
				System.out.print((char) zeichen);
			}
		} catch (IOException e) {
			System.out.println("Fhler beim lesen der Datei ->" + e.getMessage());
		} finally {

			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("");
		 try {
		 leseFrage();
		 } catch (Exception e) {
		 //TODO: handle exception
		 }

		System.out.println("");
		try {
			leseFrageMit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void leseFrage() throws IOException {

		String zeile;
		BufferedReader buff = null;
		try {
			buff = new BufferedReader(new FileReader("docs/fragen.txt"));
			while ((zeile = buff.readLine()) != null) {
				String[] frageZeile = zeile.split(";");
				System.out.println("Frage Nr.: " + frageZeile[0]);
				System.out.println(frageZeile[1]);
				System.out.println("A:" + frageZeile[2]);
				System.out.println("B:" + frageZeile[3]);
				System.out.println("C:" + frageZeile[4]);
				System.out.println("D:" + frageZeile[5]);
			}

		} catch (IOException e) {
			System.out.println("Error" + e.getMessage());
		} finally {

			try {
				if (buff != null) {
					buff.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

	}

	public static void leseFrageMit() {

		String zeile;
		try (BufferedReader buff = new BufferedReader(new FileReader("docs/fragen.txt"))) {

			while ((zeile = buff.readLine()) != null) {
			String[] frageZeile = zeile.split(";");
			System.out.println("Frage Nr.: " + frageZeile[0]);
			System.out.println(frageZeile[1]);
			System.out.println("A:" + frageZeile[2]);
			System.out.println("B:" + frageZeile[3]);
			System.out.println("C:" + frageZeile[4]);
			System.out.println("D:" + frageZeile[5]);
			}
		} catch (IOException e) {
			System.out.println("Fehler" + e.getMessage());
			Throwable[] unterdrueckAusnahmen = e.getSuppressed();
		}

	}

}
