package builder;
/*
 * 	Das Entwurfsmuster Builder:
 * 
 * 		-> Ziel ist es, komplexe, konfigurierbare Objekte möglichst simple und elegant zu ermöglichen
 * 
 * 			-> Oft sollen bei solchen Objekten bestimmte Kombinationen verboten sein und nicht gesetzte
 * 			   Werte mit bestimmten Standardeinstellungen versehen werden
 * 
 * 
 * 		
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		//Eine mögliche Lösung mit "Teleskopkonstruktoren":
		//nicht praktisch, schwer zu testen und anzupassen!!!
		AutoConfigMitKonstruktoren karre=new AutoConfigMitKonstruktoren(EAusstattung.ATTRACTION);
		
		
		//Zweite Möglichkeit mit Settern:
		// -> Probleme: 1. Man kann Aufrufer nicht dazu zwingen, bestimmte Setter ZUERST aufzurufen!
		//			    2. Jeder Setter müsste alle möglichen Kombinationen auf Validität prüfen
		
		AutoConfigMitSettern karre2=new AutoConfigMitSettern();
		karre2.setAusstattung(EAusstattung.ATTRACTION);
		karre2.setTyp(ETyp.KOMBI);
		karre2.setAutomatik(true);
		karre2.setTyp(ETyp.GELAENDEWAGEN);
		
		//Konfigurieren mit dem Builder:
		AutoConfigMitBuilder auto=new AutoConfigMitBuilder.AutoBuilder(EAusstattung.ECOTEC)
				.inFarbe(EFarbe.BLAU)
				.mitMotor(EMotor.PURETEC_E)
				.konstruiere();
		
		
		
		

	}

}
