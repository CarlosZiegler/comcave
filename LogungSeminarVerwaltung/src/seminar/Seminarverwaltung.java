package seminar;

public class Seminarverwaltung {

	private static Seminarverwaltung verwaltung;
	private static Seminar[] seminare;
	private static int anzSeminare;

	private Seminarverwaltung() {
		seminare = new Seminar[100];
	}

	public static Seminarverwaltung getVerwaltung() {

		if (verwaltung == null) {

			verwaltung = new Seminarverwaltung();
		}
		return verwaltung;

	}

	public static void addSeminar(Seminar seminar) {

		if (anzSeminare < seminare.length) {
			seminare[anzSeminare++] = seminar;
		} else {
			System.out.println("Seminar ist voll");
		}

	}

	public static void addSeminare(Seminar[] seminare) {

		Seminarverwaltung.seminare = seminare;

	}

	public static void getSeminarInfo(Seminar seminar) {

		System.out.println("Seminar zu Thema: " + seminar.getThema());
		System.out.println("Dozent" + seminar.getDozent().getName());
		System.out.println("List");

		for (int i = 0; i < seminar.getTeilnehmer().length; i++) {

			
			if (seminar.getTeilnehmer()[i]!=null) {
				System.out.println("Name: " + seminar.getTeilnehmer()[i].getName());
				System.out.println("ID: " + seminar.getTeilnehmer()[i].getId());
			}
			

		}
		System.out.println("Raum:" + seminar.getRaum());
		System.out.println("Start" + seminar.getStart());
		System.out.println("Ende" + seminar.getEnde());

	}
	
	public static void printKursubersicht() {
		
		for(int i = 0; i<seminare.length;i++) {
			if(seminare[i]!=null) {
				getSeminarInfo(seminare[i]);
			}
			
		}
		
	}
	
	
	

}
