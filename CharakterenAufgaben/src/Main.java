
public class Main {

	public static void main(String[] args) {

		Charackter car = new Charackter();
		System.out.println("Name: " + car.getName());
		System.out.println("Rasse: " + car.getRasse());
		System.out.println("Id: " + car.getId());
		System.out.println("Geschlecht: " + car.getGeschlechte());
		System.out.println("Spezielgabe: " + car.getSpezielleGabe());
		System.out.println("Waffe: " + car.getWaffe());

		Game game1 = new Game();
		game1.setCharakterAnzahl();
		game1.getCharakterAnzahl();

		for (int i = 0; i < game1.getCharakterAnzahl().length; i++) {
			Charackter charakter = game1.getCharakterAnzahl()[i];
			System.out.println(charakter.getName() + " " + charakter.getId());

		}
		
		game1.setCharakterStadt();
		
		game1.lesenGame();
	}

}
