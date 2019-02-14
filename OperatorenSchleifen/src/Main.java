
public class Main {

	public static void main(String[] args) {

		// compound operatoren;
		// +=, -=, *=, /=;
		// a = a+1 -- a+=1;
		int x = 10;
		int y = 12;

		x *= 2 + 5;
		System.out.println(x);// Primeiro faz o uqe esta depois do igual, por ultimo ele multiplica
								// o x pelo resultado

		Boolean wahrheit = false;
		if (wahrheit == true) {
			System.out.println("Wahrheit = True");
		} else {
			System.out.println("Wahrheit = False");
		}

		// Concatenation
		String text = "";
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;

		System.out.println(text + a + b + c + d + e);

		//
		int wert = 2;
		int wertb = 3;

		if ((wertb == ++wert) | (wert < wertb++)) {

			System.out.println("Wert =" + ++wert + "wertB=" + wertb++);

		}

		int erg = testincr(20);

		System.out.println(erg);

		// ************************************************

		for (int i = 0; i < 9; i++) {
			if (i == 5) {
				continue;
			}

			System.out.println("ich loope");
		}

		aussen: for (int i = 0; i < 5; i++) {
			innen: for (int j = 0; j < 5; j++) {
				System.out.println("Ente");
				if (j > 3)
					break aussen;
				continue innen;
			}
			System.out.println("aussen");
		}

	}

	public static int testincr(int x) {
		return x++;

	}

}
