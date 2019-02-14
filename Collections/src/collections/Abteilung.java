package collections;

import java.util.ArrayList;

public class Abteilung 
{
	//? auf welcher art von collection soll ich die mitarbeiter der abteilung speichern?
	private ArrayList mitarbeiterListe;
	private String name;
	
	
	public Abteilung(String name)
	{
		this.name=name;
	}
	
	public void neuerMitarbeiter(Mitarbeiter m)
	{
		mitarbeiterListe.add(m);
	}
	
	
	
	
	
	
}
