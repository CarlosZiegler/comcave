package builder;

public class AutoConfigMitKonstruktoren 
{
	private EAusstattung ausstattung; //Pflichtangabe -> entscheidet über andere Einstellungen
	private EMotor motor; //PURETEC_168 nur für SELECTION, PURETEC_E nur mit ECOTEC, Standardmotor: HDI_70
	private EFarbe farbe; //Standarfarbe: WEISS
	private ETyp typ; //Standardtyp: KOMPAKT
	private boolean automatik; //Bei GELAENDEWAGEN verboten
	private boolean panoramadach; //Nur bei EXCLUSIVE und SELECTION möglich
	
	public AutoConfigMitKonstruktoren(EAusstattung ausstattung)
	{
		this(ausstattung, ETyp.KOMPAKT);
	}
	
	public AutoConfigMitKonstruktoren(EAusstattung ausstattung, ETyp typ)
	{
		this(ausstattung, typ, EFarbe.WEISS);
	}
	
	public AutoConfigMitKonstruktoren(EAusstattung ausstattung, ETyp typ, EFarbe farbe)
	{
		this(ausstattung, typ, farbe, false );
	}
	
	public AutoConfigMitKonstruktoren(EAusstattung ausstattung, ETyp typ, EFarbe farbe, boolean dach)
	{
		this(ausstattung, typ, farbe, dach, false);
	}
	
	public AutoConfigMitKonstruktoren(EAusstattung ausstattung, ETyp typ, EFarbe farbe, boolean dach, boolean automatik)
	{
		this(ausstattung, typ, farbe, dach, automatik, EMotor.HDI_70 );
	}
	
	public AutoConfigMitKonstruktoren(EAusstattung ausstattung, ETyp typ, EFarbe farbe, boolean dach, boolean automatik, EMotor motor)
	{
		//hier müssten alle möglichen/relevanten kombinationen auf gültigkeit geprüft werden:
		
		this.ausstattung=ausstattung;
		this.typ=typ;
		this.farbe=farbe;
		this.panoramadach=dach;
		this.automatik=automatik;
		this.motor=motor;
	}
	
	
}
