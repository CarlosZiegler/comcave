package testAuto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KontoTest {

	private Konto kto;
	
	@BeforeEach
	void setUp() throws Exception {
		kto = new Konto();
	}

	@Test
	void testEinzahlenSpezifiziert() throws IllegalAccessException {

		int saldoBevor=kto.getSaldo();
		kto.einzahlen(100);
		assertTrue(kto.getSaldo()==saldoBevor+100);
	} 
	
	

}
