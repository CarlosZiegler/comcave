package innere;

//-> Ohne ein Objekt der �usseren Klasse, kann es KEIN Objekt einer inneren Elementklasse geben!
//-> Aus einer inneren Elementklassen kann man auf ALLES zugreifen, was die �ussere Klasse an Attributen/Methoden anbietet!
//-> Nur weil es ein Objekt der �usseren Klasse gibt, existiert NICHT implizit auch ein Objekt der inneren!!!
//		-> Objekte innerer Klassen m�ssen explizit erzeugt werden!
//-> Innere Elementklassen ERBEN NICHT implizit von deren �usseren Klassen!
//-> Eine innere Elementklasse kann andere Klassen erweitern(innere UND �ussere)
//-> Eine �ussere Klasse kann nicht von ihren inneren Klassen erben!
//-> Elementklassen k�nnen ohne Weiteres auch Interfaces implementieren
//-> Innerhalb von Elementklassen darf es keine statischen Elemente geben!

public class Auto 
{
	private double gewichtInKg;
	private static int anzahlTueren;
	private Motor m;
	
	
	public Auto()
	{
		m=new Motor(90);
	}
	
	
	public Auto(int ps)
	{
		m=new Motor(ps);
	}
	
	
	//�blicherweise erlaubt man den zugriff auf innere klassen von AUSSEN immer nur �ber entsprechende methoden:
	public IMotor buildMotor(int ps)
	{
		return new Motor(ps);
	}
	
	
	//************************************************************************************************************
	// ELEMENTKLASSEN
	//innere klasse:  ********************************************************************************************
	public class Motor implements IMotor
	{
		private int ps;
		
		public Motor(int ps)
		{
			this.ps=ps;
			anzahlTueren=5;
		}
		
		//methoden...
		public void beschleunigung()
		{
			gewichtInKg=9.12*100;
			bremsen(); //direkter aufruf einer methode der �usseren klasse
		}
		
		//innere klasse
		private class Getriebe
		{
			
		}

		public int getPs() {
			return ps;
		}


		public void setPs(int ps) {
			this.ps = ps;
		}
		
		
		
	}
	//******************************************************************************************************************
	
	private class ElektroMotor extends Motor //Eine innere Klasse erweitert eine andere innere Klasse -> Konstruktorverkettung!
	{

		public ElektroMotor(int ps) {
			super(ps);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	
	
	
	public void bremsen()
	{
		
	}
	
	public void fahren()
	{
		//beschleunigung();  -> aus der �usseren klasse kann man nicht direkt auf elemente der inneren zugreifen! -> compilerfehler
		
		Motor m=new Motor(120);
		m.beschleunigung();
	}
	
	//*************************************************************************************************
	// METHODENKLASSEN
	//*************************************************************************************************
	public void lenkung()
	{
		int variable=0;
		
		// methodenklasse *********** -> k�nnen nicht private, public, protected, static sein
		//							  -> k�nnen abstract/final, k�nnen andere klassen erweitern und interfaces implementieren
		final class ServoFluessigkeit 
		{
			double pneumatischerDruck;
			
			public double winkelEinstellungVorneRechts()
			{
				return 0;
			}

		}
		//***************************
		ServoFluessigkeit se=new ServoFluessigkeit(); //man kann erst objekte erzeugen, NACHDEM die methodenklasse ausgelesen wurde!
		se.winkelEinstellungVorneRechts();
		
	}
	
	
}
