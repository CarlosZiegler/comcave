package testAuto;

import javax.sql.rowset.spi.TransactionalWriter;

public class Konto {

	private int saldo;

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	//geld abgeben :
	// -> man kann nur so viel abheben, dass das saldo noch 0 ist,Und mans kan Keine betrage <=0 abheben
	// -> bei diesen verstoßen soll ieine IllegalArgumentExceptuio geworfen werden
	public void einzahlen(int betrag) throws IllegalAccessException {
		if(betrag>100000) {
			
			throw new IllegalAccessException("Betrag darf nicht mehr aus 10000 sein !");
			
		}
		
		this.saldo+=betrag;
	}
	
	//geld einzahlen;
	//-> man kann pro einzahlung maximal 10.000 eizahlung
	
	
	
	
}
