
public class MinhaThreadRunnable implements Runnable{

	
	private String nome;
	private int tempo;
	
	
	
	
	
	public MinhaThreadRunnable(String name, int tempo) {
		super();
		this.nome = name;
		this.tempo = tempo;
		//Thread t = new Thread(this);
		//t.start();
	}





	@Override
	public void run() {
		for (int i = 0; i <6; i++) {
			System.out.println(nome + " contador "+i);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(nome + "Terminou a execucao da :" + Thread.currentThread().getName());
		
	}

}
