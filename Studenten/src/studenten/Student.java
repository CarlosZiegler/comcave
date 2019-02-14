package studenten;

import java.util.ArrayList;

public class Student {
	private String namen ;
	private int matrikelnummer;
	private ArrayList<Faechern> fachechern; 
	private int aktuelSemester;

	public Student() {
		super();
		
	}
	
	public Student(String n) {
		super();
		this.namen = n;
		
	}
	
	public String getNamen() {
		return namen;
	}
	public void setNamen(String namen) {
		this.namen = namen;
	}
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	public ArrayList<Faechern> getFachechern() {
		return fachechern;
	}
	public void setFachechern(Faechern a) {
		this.fachechern.add(a);
	}
	public int getAktuelSemester() {
		return aktuelSemester;
	}
	public void setAktuelSemester(int aktuelSemester) {
		this.aktuelSemester = aktuelSemester;
	}
	 public void vergleichenRegelstudienzeit(ArrayList<Faechern> f) {
		 int aktuel = getAktuelSemester();
		 for (Faechern faechern : f) {
			int temp = faechern.getRegelstudienzeit();
				if (aktuel < temp) {
					System.out.println("Student "+ this.namen +" ist angemeldet " + faechern + " und hat NICHT Regelstudienzeit überschritten");
				} else {
					System.out.println("Student "+ this.namen  + " ist angemeldet " + faechern + " und hat " + (aktuel-temp) + " Regelstudienzeit überschritten");
				}
		}
		 
	 }
	
	
}
