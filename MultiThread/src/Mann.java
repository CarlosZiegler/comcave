import java.util.*;
public class Mann implements Runnable{

	private Random zuffi;
	private String name;
	
	public Mann(String name) {
		super();
		this.name = name;
		zuffi = new Random();
	}

	@Override
	public void run() {
		
		while(true)
		{
			synchronized (Haushaltskasse.class) {
				int geldverdient = zuffi.nextInt(100)+1;
				System.out.println(name + " hat " + geldverdient + " Euro verdient.");
				Haushaltskasse.einzahl(geldverdient);
				System.out.println("In der Kasse siund nun : " + Haushaltskasse.getSaldo());
				
				if (Haushaltskasse.getSaldo()>200) {
					
					Haushaltskasse.class.notify();
					try {
						Haushaltskasse.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
