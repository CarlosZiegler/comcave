
public class Haushaltskasse {
 private static int saldo;

public static int getSaldo() {
	return saldo;
}

public static void setSaldo(int saldo) {
	Haushaltskasse.saldo = saldo;
}



public static void einzahl(int geldverdient) {
	saldo+=geldverdient;// TODO Auto-generated method stub
	
}

 
 
}
