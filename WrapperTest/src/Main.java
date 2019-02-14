
public class Main {

	public static void main(String[] args) {
		int a = 8;
		int b = 36;
		
		Integer a1 = a;
		
		System.out.println(a1.compareTo(2));
		System.out.println(a1.toString(b));
		
		String userEingabeAlter = "35";
		
		int alter = Integer.parseInt(userEingabeAlter);
		if (alter > 18) {
			System.out.println("Alter mehr als 18");
		}
		
		String wert = "1515454";
		Number nummer = Integer.valueOf(Integer.parseInt(wert));
		System.out.println(nummer);
		
	}

}
