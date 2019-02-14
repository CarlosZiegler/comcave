
public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//public static int z1;
		
		Mann man1 = new Mann("Peter"); 
		Frau frau1 = new Frau("Maria");
		Thread a = new Thread(man1);
		Thread b = new Thread(frau1);
		a.start();
		b.start();
		/*
		
		Zaehler z = new Zaehler();
		Thread t1 = new Thread(z,"T1");
		Thread t2 = new Thread(z,"T2");
		t1.start();
		t2.start();*/
	}

	private synchronized static int getZahl() {
		return 1;

	}
	
	/*public void veschchtelteBloecke() {
		
		
		synchronized (Main.class) {
			
			synchronized (z1) {
				
			}
		}
		
	}
	
public void veschchtelteDeadLock() {
		
		
		synchronized (z1) {
			
			synchronized (Main.class) {
				
			}
		}
		
	}
	*/
	
}
