package wrapper;
import java.util.*;
/*
 * 	WRAPPERKLASSEN:
 * 
 * 		-> Wrapper kapseln einen primitiven Wert in einem Objekt
 * 
 * 		-> Zu jedem primitiven Typ gibt es eine korrespondierende Wrapperklasse:
 * 
 * 			int -> Integer
 * 			double -> Double
 * 			boolean -> Boolean
 * 			char -> Character
 * 			float -> Float
 * 
 * 		-> Diejenigen Wrapperklassen, welche Zahlen kapseln haben die gemeinsame Superklasse "Number"
 * 
 * 
 * 		-> ALLE Wrapperklassen sind Immutable!!!
 * 
 * 
 * 		
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class Main {
	
	
	private static Object[] oArr=new Object[20];
	

	public static void main(String[] args) 
	{
		int a=12;int b=13;int c=14;
		Zahl za=new Zahl(a);
		Zahl zb=new Zahl(b);
		Zahl zc=new Zahl(c);
		
		
		ArrayList<Zahl> intListe;
		
		Integer i1=new Integer(a);
		Integer i2=new Integer(b);
		Integer i3=new Integer(c);
		
		ArrayList<Integer> intListewrapper;
		
		//Integer iTest=new Integer("blabla");
		Integer iZeichen=new Integer("23"); //können auch zeichenketten direkt in die entsprechende zahl konvertieren

		//die parse-Methoden(static) -> Konvertieren eine Zeichenkette in den entsprechenden primitiven Wert
		String userEingabeAlter="35";
		int alter=Integer.parseInt(userEingabeAlter); //konvertierung kann NumberFormatException werfen
		if(alter>18)
		{
			
		}
		
		//die valueOf-Methoden -> konvertieren eine Zeichenkette und liefern ein Wrapper-Objekt
		int zahl=345;
		String wert="9897878";
		Number nummer=Integer.valueOf(Integer.parseInt(wert));
		
		
		//**********************************************************************************
		int i=10;
		int j=12;
		
		Integer wi=new Integer(i);
		oArr[0]=wi;
		
		oArr[1]=j;//Hier wird IMPLIZIT der primitive Wert von j in einem Wrapper-Objekt vom Typ Integer verpackt,
				  //dann nach Object gecastet und schliesslich dem Array-Slot zugewiesen!!!!
		
		
		Object objekt=(Object)j; //wieso kann man einen primitiven Wert direkt in einen komplexen casten?
		
		//AUTOBOXING / AUTO-UNBOXING
	
		
		
		
		
		Integer erg=addieren(12, 12);
		
		
		erg++; //hierfür wird intern autounboxing und dann autoboxing betrieben!
		
		
		if(erg==30)
		{
			
		}
		
		long l1=2323;
		short s=2233;
		int x=2424;
		
		WrapperTestMethoden.acceptInt(l1);
		//Widening geht vor Autoboxing!
		//Autoboxing geht vor Shortening!
		
		x=s;
		s=(short)l1;
		
		
		
	}
	
	
	public int addiereWrapper(Number n1, Number n2)
	{
		return 0;
	}
	
	private static int addieren(Integer i1, Integer i2)
	{
		return i1+i2;
	}
	
	

}
