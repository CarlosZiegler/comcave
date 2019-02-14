package testAuto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AutoTest {

	@Test
	void testSchadeKlasseGruen() {
		
		Auto auto = new Auto(75);
		assertTrue(auto.berechnungSchadstoffKlasse().equals("Gruen"));
		
	}
	@Test
	void testSchadeKlasseGelb() {
		
		Auto auto = new Auto(76);
		assertTrue(auto.berechnungSchadstoffKlasse().equals("Gelb"));
		
	} 
	@Test
	void testSchadeKlasseBlau() {
		
		Auto auto = new Auto(101);
		assertTrue(auto.berechnungSchadstoffKlasse().equals("Blau"));
		
	}
	@Test
	void testSchadeKlasseRot() {
		
		Auto auto = new Auto(150);
		assertTrue(auto.berechnungSchadstoffKlasse().equals("Rot"));
		
	}

}
