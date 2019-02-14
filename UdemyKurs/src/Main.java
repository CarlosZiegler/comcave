import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n1;
		int n2;
		n1 = 89;
		n2 = 60;
		// operadores bitwise
		System.out.println(n1 & n2);
		
		Scanner sc= new Scanner(System.in);
		int mask=0b00100000;
		int n = sc.nextInt();
		if ((n & mask) !=0) {
			System.out.println("6th bit is true");
		} else {
			System.out.println("6th bit is false");
		}
		ArrayList a = new ArrayList();
	}

}
