
public class Main {

	public static void main(String[] args) {

		Oma o = new Oma("Maria");
		Thread o1 = new Thread(o);
		EnkelKindern j = new EnkelKindern("Janine",0);
		Thread e1 = new Thread(j);
		EnkelKindern h = new EnkelKindern("Hans",1);
		Thread e2 = new Thread(h);
		EnkelKindern l = new EnkelKindern("Linda",2);
		Thread e3 = new Thread(l);
		EnkelKindern k = new EnkelKindern("Kevin",3);
		Thread e4 = new Thread(k);
		
		o1.start();
		e1.start();
		e2.start();
		e3.start();
		e4.start();

	}

}
