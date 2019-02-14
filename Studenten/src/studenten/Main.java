package studenten;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	Student Carlos = new Student("José");
	Carlos.setNamen("Carlos");
	Carlos.setMatrikelnummer(010001);
	Carlos.setAktuelSemester(3);
	ArrayList<Faechern> a = new ArrayList<Faechern>();
	a.add(Faechern.BWL);
	a.add(Faechern.INFORMATIK);
	Carlos.vergleichenRegelstudienzeit(a);
	
	Student Jose = new Student();
	Jose.setNamen("Jose");
	Jose.setMatrikelnummer(020002);
	Jose.setAktuelSemester(8);
	ArrayList<Faechern> b = new ArrayList<Faechern>();
	b.add(Faechern.BWL);
	b.add(Faechern.INFORMATIK);
	Jose.vergleichenRegelstudienzeit(b);
	
	
	
	
	

	}

}
