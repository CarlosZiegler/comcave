import java.util.Random;

public class Charackter {
	int position;

	// Grundeigenschfatigen von Charakter
	// Double.valueOf(Math.random() * Name.values().length).intValue()
	public enum Name {
		OUGUDOUGU, KTULHU, KAAN, ISANA, OZZY, JENNIFER, KRYPIA, OBAMA, TEK, HYPRIO, BERTI;
		// Methoden zufälligen Eigenschaften von Name
		public static Name NameRandom() {
			Random ran = new Random();
			return Name.values()[ran.nextInt(11)];
		}

	}

	public enum Rasse {
		ARGONIER, MENSCH, KATARRANER, ZONIE, PROTOSS;

		public static Rasse RasseRandom() {
			Random ran2 = new Random();
			return Rasse.values()[ran2.nextInt(5)];
		}
	}

	public enum SpezielleGabe {
		BESCHWORUNG, ZERSTORUNG, ILLUSION, HEILUNG, SCHLEICHEN, POLYMORPHIE;

		public static SpezielleGabe SpezielleGabeRandom() {
			Random ran3 = new Random();
			return SpezielleGabe.values()[ran3.nextInt(6)];
		}
	}

	public enum Geschlecht {
		MANNLICH, WEIBLICH, HYBRID, NEUTRAL;

		public static Geschlecht GeschlechtRandom() {
			Random ran4 = new Random();
			return Geschlecht.values()[ran4.nextInt(4)];
		}

	}

	public enum Waffe {
		SCHWERT, ARMBRUST, HAMMER, BOGEN, ANGELRUTEN, SCHUSSWAFFEN;

		public static Waffe WaffeRandom() {
			Random ran5 = new Random();
			return Waffe.values()[ran5.nextInt(6)];
		}
	}

	// Attibute von Charakter
	private int id;
	private Name name;
	private Rasse rasse;
	private SpezielleGabe spezielleGabe;
	private Geschlecht geschlechte;
	private Waffe waffe;

	public Charackter() {
		super();

		this.id = setId();
		this.name = Name.NameRandom();
		this.rasse = Rasse.RasseRandom();
		this.spezielleGabe = SpezielleGabe.SpezielleGabeRandom();
		this.geschlechte = Geschlecht.GeschlechtRandom();
		this.waffe = Waffe.WaffeRandom();

	}

	public int setId() {
		Random id = new Random();
		return this.id = id.nextInt(100);
	}

	// Methoden Getter von Charakter
	public int getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public Rasse getRasse() {
		return rasse;
	}

	public SpezielleGabe getSpezielleGabe() {
		return spezielleGabe;
	}

	public Geschlecht getGeschlechte() {
		return geschlechte;
	}

	public Waffe getWaffe() {
		return waffe;
	}

}
