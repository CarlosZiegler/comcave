package bmi;

public class PersonBMI {

	private double mass;
	private int height;
	private double bmi;
	private String name;
	private char geschlescht;
	private String status;

	public PersonBMI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonBMI(String name, double mass, int height, char geschlescht) {
		super();
		this.mass = mass;
		this.height = height;
		this.name = name;
		this.geschlescht = geschlescht;
		
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double d) {
		this.mass = d;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getBmi() {
		return bmi;
	}

	public void berechnenBmi() {
		String s = Integer.toString(this.height);
		double h = Double.parseDouble(s);
		h=h/100;
		this.bmi = this.mass / (h*h);
		
	}

	public String ergebnisseBMI() {

		String ergebnisse = null;

		if (this.geschlescht == 'M') {
			if (this.bmi < 20) {
				ergebnisse = "Untergewicht";
			}
			if (this.bmi > 19.99 && this.bmi <= 24.99) {
				ergebnisse = "Normalgewicht";
			}
			if (this.bmi > 24.99 && this.bmi <= 29.99) {
				ergebnisse = "Übergewicht";
			}
			if (this.bmi > 29.99 && this.bmi <= 34.99) {
				ergebnisse = "Starkes Übergewicht (Adipositas Grad I)";
			}
			if (this.bmi > 34.99 && this.bmi <= 39.99) {
				ergebnisse = "Starkes Übergewicht (Adipositas Grad II)";
			}
			if (this.bmi > 39.99) {
				ergebnisse = "Starkes Übergewicht (Adipositas Grad III)";
			}

		}
		if (this.geschlescht == 'F') {
			if (this.bmi < 19) {
				ergebnisse = "Untergewicht";
			}
			if (this.bmi > 18.99 && this.bmi <= 23.9) {
				ergebnisse = "Normalgewicht";
			}
			if (this.bmi > 23.99 && this.bmi <= 29.99) {
				ergebnisse = "Übergewicht";
			}
			if (this.bmi > 29.99 && this.bmi <= 34.99) {
				ergebnisse = "Starkes Übergewicht (Adipositas Grad I)";
			}
			if (this.bmi > 34.99 && this.bmi <= 39.99) {
				ergebnisse = "Starkes Übergewicht (Adipositas Grad II)";
			}
			if (this.bmi > 39.99) {
				ergebnisse = "Starkes Übergewicht (Adipositas Grad III)";
			}

		}

		return ergebnisse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGeschlescht() {
		return geschlescht;
	}

	public void setGeschlescht(char geschlescht) {
		this.geschlescht = geschlescht;
	}

}
