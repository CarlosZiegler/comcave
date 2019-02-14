package folge;

public class Test {

	public static void main(String[] args) {

		Aufzaehlung aufzaehlung = new Aufzaehlung(10, 100);
		
		//aufzaehlung.initRandom();
		
		IFolge it = aufzaehlung.iterator();
		while (it.elementVorhanden()) {
			System.out.println(it.getNextElement());
		}

	}

}
