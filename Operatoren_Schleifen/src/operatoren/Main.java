package operatoren;

public class Main {

	public static void main(String[] args) 
	{
		
		//compound-operatoren
		//+=, -=, *=, /=
		int x=10;
		int y=12;
		x*=2+5; //alles was rechts vom = steht wird ZUERST berechnet!
		System.out.println(x);
		
		//**************************
		boolean wahrheit=false;
		if(wahrheit=false)
		{
			System.out.println("wahrheit = true");
		}
		else
		{
			System.out.println("wahrheit ist false");
		}
		
		//***********************
		String text="";
		int a=1;int b=2;int c=3;int d=4;int e=5;
		System.out.println(a + b + " " + text + a+b+c+(d+e));
		
		//************************
		int wert=2; int wertB=3;
		if((wertB==++wert) | (wert<wertB++))
		{
			System.out.println("wert=" + ++wert + " wertB=" + wertB++);
		}
		System.out.println(wertB);
		
		
		int erg=testIncr(20);
		
		//*********************************************************************
		
		/*	break und continue:
		 * 
		 * 		-> break: der aktuelle loop wird verlassen und es wird mit der ersten anweisung nach diesem loop
		 * 				  weiter gemacht
		 * 
		 * 		-> continue: die aktuelle iteration wird unterbrochen und mit der nächsten weiter gemacht
		 * 					 (wenn die schleifenbedingung noch erfüllt ist)
		 * 
		 * 		-> label: sprungmarken im code, welche aus schleifen heraus angesprungen werden können
		 * 
		 * 
		 */
		
		for(int i=0;i<7;i++)
		{
			if(i==5)
				break;
			System.out.println("ich loope....");
		}
		
		System.out.println("------------------------------------------------------");
		
		aussen:
			for(int blup=0;blup<5;blup++)
			{
				innen:
					for(int j=0;j<5;j++)
					{
						System.out.println("Ente");
						if(j>3)
							break aussen;
						continue innen;
					}
			System.out.println("aussen");
			}
		
		
		
		
		
		

	}
	
	public static int testIncr(int x)
	{
		return ++x;
	}
	
	
	
	
	
	

}
