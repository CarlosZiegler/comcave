import java.util.ArrayList;
import java.util.Random;

public class EnkelKindern implements Runnable {
	private Random keks;
	private String name;
	private int id;

	public EnkelKindern(String name, int id) {
		super();
		this.name = name;
		this.id = id;
		keks = new Random();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		while (true) {

			synchronized (EinzahlKeks.class) {
				if (EinzahlKeks.getEinzahlKeks() < 20) {
					EinzahlKeks.class.notify();
					try {
						EinzahlKeks.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				int essenKeks = keks.nextInt((20 - 5) + 1) + 5;
				if (EinzahlKeks.getListFull() == null)
					EinzahlKeks.setFull(new ArrayList<Boolean>(4));

				if (EinzahlKeks.getListFull().get(this.id) == false) {
					if (EinzahlKeks.getEinzahlKeks() >= essenKeks) {
						System.out.println(name + " hat " + essenKeks + " gerade gegessen");
						if (essenKeks >= 18) {
							EinzahlKeks.setKinderFull(id);
							System.out.printf("------------------------------------------------------\n");
						}
						EinzahlKeks.setEinzahlKeks(EinzahlKeks.getEinzahlKeks() - essenKeks);
						System.out.println("Es gibt noch : " + EinzahlKeks.getEinzahlKeks() + " keks");

					}
				}

			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
