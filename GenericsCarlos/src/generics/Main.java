package generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Artikel> artikelList= new ArrayList<Artikel>();
		
		Werkzeug hammer = new Werkzeug("Hammer");

		artikelList.add(hammer);
		artikelList.get(0).setArtikelNr("abb1212121");
		
		ArrayList<Werkzeug> werkzeugList = new ArrayList<Werkzeug>();
		
		Integer a;
		int b;
		
		a = 1;
		
		System.out.println(a.floatValue());
		
		test(werkzeugList);
		Iterator<Werkzeug> itw = werkzeugList.iterator();
		while (itw.hasNext()) {
			Werkzeug werkzeug = (Werkzeug) itw.next();
			
		}
		
	}
	private static void test(List li) {
		li.add(new String());

	}

}
