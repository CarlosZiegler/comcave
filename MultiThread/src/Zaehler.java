
public class Zaehler implements Runnable {

	int zaehler;

	@Override
	public void run() {

		while (zaehler <= 50) {
			synchronized (this) {
				// schreiboperation
				zaehler++;
				System.out.println(Thread.currentThread().getName() + " : " + zaehler);
				this.notify();
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {

				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void methodeA() {
		
		
	}

}
