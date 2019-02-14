package delegator;

import java.util.ArrayList;

public class Delegator {
	private IDelegator client;
	
	public Delegator(IDelegator client) {
		this.client = client;
		
	}
	
	public void getInformationenKurs(ArrayList<Kurse> listkurs){
		for (Kurse kurse :  listkurs) {
			String nome = kurse.getThema();
			Dozenten dozent = kurse.getDozent();
			System.out.println("\nKURSE\n");
			System.out.println("Thema: "+ nome + "\nDozent: " + dozent.getNachName() + "\nStart:" + kurse.getStart() + "\nEnd:" +kurse.getEnde() +"\nRaum: "+ kurse.getRaum());
		}}
		
	public void getInformationenDozent(ArrayList<Dozenten> listdozenten){
			for (Dozenten dozent : listdozenten) {
				System.out.println("\nDOZENTEN\n");
				System.out.println("Nachname: "+ dozent.getNachName() + "\nVorname: " + dozent.getVorName() + "\nBerufsbildung: " + dozent.getBerufsBildung());
			}	
		
		
	} 
	
	public void getInformationenTeilnehmer(ArrayList<Seminarteilnehmer> listteilnehmer){
		for (Seminarteilnehmer teilnehmer : listteilnehmer) {
			System.out.println("\nSEMINARTEILNEHMER\n");
			System.out.println("Nachname: "+ teilnehmer.getNachName() + "\nVorname: " + teilnehmer.getVorName() + "\nBerufsbildung: " + teilnehmer.getBerufsBildung());
		}	
	
	
} 
	
}
