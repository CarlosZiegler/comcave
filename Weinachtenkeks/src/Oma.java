import java.util.ArrayList;
import java.util.Random;

public class Oma implements Runnable {
	private Random backenKeks;
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Oma(String name) {
		super();
		this.name = name;
		backenKeks = new Random();
		if (EinzahlKeks.getListFull() == null)
			EinzahlKeks.setFull(new ArrayList<>());
			EinzahlKeks.setAllesnichtFull();
	}
	
	
	@Override
	public void run() {
		backen100();
		backen();

	}
	public void backen100() {
		
		while (!EinzahlKeks.isIs100()) {
			int backen = backenKeks.nextInt(50) +30;
			System.out.println("Oma " + name + " hat " + backen + " gebaken !!!!!!!!!!!!!!!!!!!!!!!!!!!");
			EinzahlKeks.saldoKeks(backen);
			System.out.println("Es gibt noch: " + EinzahlKeks.getEinzahlKeks() + " keks");
		}
		
		
	}
	public void backen() {
		

		while (true) {

			synchronized (EinzahlKeks.class) {
				if (EinzahlKeks.getEinzahlKeks() < 20 && EinzahlKeks.getEinzahlKeks()<100 ) {
					int backen = backenKeks.nextInt(50) +30;
					System.out.println("Oma " + name + " hat " + backen + " gebaken !!!!!!!!!!!!!!!!!!!!!!!!!!!");
					EinzahlKeks.saldoKeks(backen);
					System.out.println("Es gibt noch: " + EinzahlKeks.getEinzahlKeks() + " keks");
					EinzahlKeks.setAllesnichtFull();
					
					if (EinzahlKeks.getEinzahlKeks() > 100) {
						EinzahlKeks.class.notifyAll();
						try {
							EinzahlKeks.class.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

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
