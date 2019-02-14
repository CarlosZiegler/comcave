package bmi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonBMI person = new PersonBMI();
		Scanner a = new Scanner(System.in);
		String geschlecht = "";
		double gewichte; 
		
		System.out.println("Schreiben Sie die Geschlecht (M)Mann (F)Frau");
		geschlecht = a.nextLine().toUpperCase();
		
		while (geschlecht.equals("F") == false && geschlecht.equals("M") == false) {
			System.out.println("Schreiben Sie die Geschlecht (M)Mann (F)Frau");
			geschlecht = a.nextLine().toUpperCase();
		}
			
		person.setGeschlescht(geschlecht.charAt(0));
		
		System.out.println("Schreiben Sie die gewischte");
		person.setMass(a.nextDouble());
		
		System.out.println("Schreiben Sie die Groﬂ");
		person.setHeight(a.nextInt());
		
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		System.out.println(person.getStatus());
		System.out.println(person.getBmi());
		
		
		
		
	}

}
