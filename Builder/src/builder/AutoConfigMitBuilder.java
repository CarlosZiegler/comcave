package builder;

public class AutoConfigMitBuilder 
{
	private EAusstattung ausstattung; //Pflichtangabe -> entscheidet über andere Einstellungen
	private EMotor motor; //PURETEC_168 nur für SELECTION, PURETEC_E nur mit ECOTEC, Standardmotor: HDI_70
	private EFarbe farbe; //Standarfarbe: WEISS
	private ETyp typ; //Standardtyp: KOMPAKT
	private boolean automatik; //Bei GELAENDEWAGEN verboten
	private boolean panoramadach; //Nur bei EXCLUSIVE und SELECTION möglich
	
	//Ein Konstruktor, an welche alle PFLICHTANGABEN übergeben werden
	// dieser Konstruktor kann NUR aus der inneren Klasse des Builders heraus aufgerufen werden!
	private AutoConfigMitBuilder(EAusstattung ausstattung)
	{
		this.ausstattung=ausstattung;
	}
	
	//INNERE KLASSE DES BUILDERS:
	public static class AutoBuilder
	{
		//ein attribut der äusseren klasse...diese instanz wird hier konfiguriert und am ende zurückgegeben
		private AutoConfigMitBuilder auto;
		
		//Konstruktor für alle PFLICHTANGABEN, in welchem alle Einstellungen(bis auf die Pflichtangabe) auf
		//Standardwerte gesetzt werden:
		public AutoBuilder(EAusstattung ausstattung)
		{
			//als erstes attribut mit pflichtangaben initialisieren 
			auto=new AutoConfigMitBuilder(ausstattung);
			
			//standardeinstellungen für alle werte des autos setzen:
			auto.motor=EMotor.HDI_70;
			auto.farbe=EFarbe.WEISS;
			auto.typ=ETyp.KOMPAKT;
			auto.automatik=false;
			auto.panoramadach=false;
		}
		
		//Config-Methoden für alle nicht-Pflichtattribute:
		public AutoBuilder mitMotor(EMotor motor)
		{
			auto.motor=motor;
			return this;
		}
		
		public AutoBuilder inFarbe(EFarbe farbe)
		{
			auto.farbe=farbe;
			return this;
		}
		
		public AutoBuilder vomTyp(ETyp typ)
		{
			auto.typ=typ;
			return this;
		}
		
		public AutoBuilder mitAutomatik()
		{
			auto.automatik=true;
			return this;
		}
		
		public AutoBuilder mitPanoramaDach()
		{
			auto.panoramadach=true;
			return this;
		}
		
		//diese methode wird nach fertiger konfiguration zum abschluss aufgerufen und prüft alle einstellungen
		//auf ihre gültigkeit
		public AutoConfigMitBuilder konstruiere()
		{
			//panoramadach checken:
			if(auto.panoramadach)
			{
				if(!(auto.ausstattung.equals(EAusstattung.EXCLUSIVE) || auto.ausstattung.equals(EAusstattung.SELECTION)))
				{
					throw new IllegalStateException("Fehler: Panoramadach nur mit Exclusive oder Selection erlaubt.");
				}
			}
			
			//motor checken:
			if(auto.motor.equals(EMotor.PURETEC_168) &&
					!auto.ausstattung.equals(EAusstattung.SELECTION))
			{
				throw new IllegalStateException("Fehler: Puretech_168 nur mit Selection erlaubt!");
			}
			if(auto.motor.equals(EMotor.PURETEC_E) &&
					!auto.ausstattung.equals(EAusstattung.ECOTEC))
			{
				throw new IllegalStateException("Fehler: Puretec_E nur mit Ecotec möglich!");
			}
			
			//automatik prüfen:
			if(auto.automatik && auto.typ.equals(ETyp.GELAENDEWAGEN))
			{
				throw new IllegalStateException("Fehler: Automatik nicht für Geländewagen erlaubt!");
			}
			
			//zum schluss nur noch das fertig konfigurierte auto zurückgeben:
			return auto;
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
