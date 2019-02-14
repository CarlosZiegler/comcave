package builder;

public class AutoConfigMitSettern 
{
	private EAusstattung ausstattung; //Pflichtangabe -> entscheidet �ber andere Einstellungen
	private EMotor motor; //PURETEC_168 nur f�r SELECTION, PURETEC_E nur mit ECOTEC, Standardmotor: HDI_70
	private EFarbe farbe; //Standarfarbe: WEISS
	private ETyp typ; //Standardtyp: KOMPAKT
	private boolean automatik; //Bei GELAENDEWAGEN verboten
	private boolean panoramadach; //Nur bei EXCLUSIVE und SELECTION m�glich
	
	//Pflichteinstellung
	public void setAusstattung(EAusstattung ausstattung)
	{
		this.ausstattung=ausstattung;
	}
	
	public void setTyp(ETyp typ)
	{
		this.typ=typ;
	}
	
	public void setAutomatik(boolean automatik)
	{
		this.automatik=automatik;
		if(typ.equals(ETyp.GELAENDEWAGEN))
		{
			automatik=false;
		}
	}
	
	
	
	
	
}
