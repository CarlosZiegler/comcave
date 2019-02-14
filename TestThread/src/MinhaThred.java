
public class MinhaThred extends Thread {

	private String nome;
	private int tempo;

	public MinhaThred(String nome, int tempo) {
		super();
		this.nome = nome;
		this.tempo = tempo;
		start();
	}

	@Override
	public void run() {

		System.out.println("Executando a Thread");

		try {
			for (int i = 0; i < 6; i++) {
				System.out.println(nome + " contador " + i+ " Nome Thread =>"+Thread.currentThread());
				Thread.sleep(this.tempo);
				
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Terminou execucao -> "+this.nome);

	}
}
