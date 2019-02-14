package immutable;

public class Test {

	public static void main(String[] args) 
	{
		
		char[] cArr= {'W', 'o', 'r', 't'};
		int zahl=20;
		
		
		Immutable immu=new Immutable(zahl, cArr);
		
		System.out.println(immu.getZahl());
		System.out.println(immu.getZeichenkette());
		
		//änderungen:
		zahl=30;
		cArr[0]='X';
		
		System.out.println(immu.getZahl());
		System.out.println(immu.getZeichenkette());
		
		
		char[] zeichenArr=immu.getZeichenkette();
		zeichenArr[1]='G';
		System.out.println(immu.getZeichenkette());
		
		
		
		
		
		
		

	}

}
