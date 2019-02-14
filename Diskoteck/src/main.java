
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tuersteher a = new Tuersteher();
		Person carlos = new Person();
		carlos.setAlter(14);
		carlos.setGeschlecht('M');
		carlos.setName("Carlos");
		boolean resultado = a.checkEntry(carlos, 16);
		System.out.println(resultado);
	}

}
