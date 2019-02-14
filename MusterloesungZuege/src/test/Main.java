package test;

import zuege.*;

public class Main {

	public static void main(String[] args) {
		
		
		Zuglinie s1=new Zuglinie("S1");
		Haltepunkt h1=new Haltepunkt("2", "04:12");
		h1.setBahnhof(new Bahnhof("Dortmund Scharnhorst"));
		
		s1.addHaltepunkt(h1);
		
		

	}

}
