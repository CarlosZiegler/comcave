package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bmi.PersonBMI;

class TestPerson {

	PersonBMI person;

	/**
	 * Untergewicht Mann weniger als 20 / Frau weniger als 19
	 * 
	 * Normalgewicht Mann 20 - 24,9 / Frau 19 - 23,9
	 * 
	 * Übergewicht Mann 25 - 29,9 / Frau 24 - 29,9
	 * 
	 * Starkes Übergewicht (Adipositas Grad I) Mann 30 - 34,9 / Frau 30 - 34,9
	 * 
	 * Adipositas Grad II Mann 35 - 39,9 / Frau 35 - 39,9
	 * 
	 * Adipositas Grad III Mann 40 oder mehr / Frau 40 oder mehr
	 * 
	 */

	@BeforeEach
	void setUp() throws Exception {
		person = new PersonBMI();
	}

	@Test
	void testManUntergewicht() {
		person.setGeschlescht('M');
		person.setMass(59.0);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Untergewicht"));

	}

	@Test
	void testManNormalgewicht() {
		person.setGeschlescht('M');
		person.setMass(69.0);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Normalgewicht"));

	}

	@Test
	void testManGradI() {
		person.setGeschlescht('M');
		person.setMass(99.0);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Starkes Übergewicht (Adipositas Grad I)"));

	}

	@Test
	void testManGradII() {
		person.setGeschlescht('M');
		person.setMass(108.0);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Starkes Übergewicht (Adipositas Grad II)"));

	}

	@Test
	void testManGradIII() {
		person.setGeschlescht('M');
		person.setMass(125.0);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Starkes Übergewicht (Adipositas Grad III)"));

	}

	@Test
	void testFrauUntergewicht() {
		person.setGeschlescht('F');
		person.setMass(58);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Untergewicht"));

	}

	@Test
	void testFrauNormalgewicht() {
		person.setGeschlescht('F');
		person.setMass(59.0);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Normalgewicht"));

	}

	@Test
	void testFrauGradI() {
		person.setGeschlescht('F');
		person.setMass(99.0);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Starkes Übergewicht (Adipositas Grad I)"));

	}

	@Test
	void testFrauGradII() {
		person.setGeschlescht('F');
		person.setMass(108.0);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Starkes Übergewicht (Adipositas Grad II)"));

	}

	@Test
	void testFrauGradIII() {
		person.setGeschlescht('F');
		person.setMass(125.0);
		person.setHeight(175);
		person.berechnenBmi();
		person.setStatus(person.ergebnisseBMI());
		assertTrue(person.getStatus().equals("Starkes Übergewicht (Adipositas Grad III)"));

	}

}
