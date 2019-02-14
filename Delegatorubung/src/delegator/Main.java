package delegator;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Seminarteilnehmer carlos = new Seminarteilnehmer();
		carlos.setNachName("Ziegler");
		carlos.setVorName("Carlos");
		carlos.setBerufsBildung("Fachinformatiker Anwendungsentwicklung");
		
		Dozenten andre = new Dozenten();
		andre.setBereich("SQL");
		andre.setBerufsBildung("TI Bachelor");
		andre.setNachName("Gottlob");
		andre.setVorName("Ausgustus");
		
		Kurse sql = new Kurse();
		sql.setDozent(andre);
		sql.setRaum(2004);
		sql.setStart("10/12/2018");
		sql.setEnde("20/01/2019");
		sql.setThema("Grundlage SQL");
		
		Kurse POO = new Kurse();
		POO.setDozent(andre);
		POO.setRaum(2004);
		POO.setStart("10/01/2019");
		POO.setEnde("25/02/2019");
		POO.setThema("Grundlage POO mit Java");
		
		
		Schulungsunternehmen comcave = new Schulungsunternehmen();
		comcave.setName("Comcave College");
		ArrayList<Dozenten> comcavedozent = new ArrayList<Dozenten>();
		comcave.setDozentenList(comcavedozent, andre);
		ArrayList<Seminarteilnehmer> comcaveteilnehmer = new ArrayList<Seminarteilnehmer>();
		comcave.setTeilnehmerList(comcaveteilnehmer, carlos);
		ArrayList<Kurse> comcaveKurslist = new ArrayList<Kurse>();
		comcave.setSeminarList(comcaveKurslist, sql);
		comcave.setSeminarList(comcaveKurslist, POO);
		comcave.setSeminarList(comcaveKurslist);
		
		/*for (Kurse kurse : comcaveKurslist) {
			String nome = kurse.getThema();
			Dozenten dozent = kurse.getDozent();
			System.out.println();
			System.out.println("Thema: "+ nome + "\nDozent: " + dozent.getNachName() + "\nStart:" + kurse.getStart() + "\nEnd:" +kurse.getEnde() +"\nRaum: "+ kurse.getRaum());
		}
		*/
		//carlos.getDelegator().getInformationenKurs(comcaveKurslist);
		//andre.getDelegator().getInformationenKurs(comcaveKurslist);
		//andre.getDelegator().getInformationenDozent(comcavedozent);
		andre.getDelegator().getInformationenTeilnehmer(comcaveteilnehmer);
		
		//carlos.getDelegator().getInformationenKurs(comcaveKurslist);
		//carlos.getDelegator().getInformationenDozent(comcavedozent);
		//carlos.getDelegator().getInformationenTeilnehmer(comcaveteilnehmer);
		
		
		
		
		
		

	}

}
