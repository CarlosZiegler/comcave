import java.util.*;
public class Frau implements Runnable {

	private Random zuffi;
	private String name;
	public Frau( String name) {
		super();
		this.name = name;
		zuffi = new Random();
	}
	
	@Override
	public void run() {
		while(true)
		{
			synchronized (Haushaltskasse.class) {
				if (Haushaltskasse.getSaldo()<50) {
					Haushaltskasse.class.notify();
					try {
						Haushaltskasse.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				int ausgaben = zuffi.nextInt(50)+1;
				System.out.println(name + " gibt " + ausgaben +" Euro aus");
				Haushaltskasse.setSaldo(Haushaltskasse.getSaldo()-ausgaben);
				System.out.println("In der Kasse sind nun : " + Haushaltskasse.getSaldo() +  " Euro");
				
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
}
