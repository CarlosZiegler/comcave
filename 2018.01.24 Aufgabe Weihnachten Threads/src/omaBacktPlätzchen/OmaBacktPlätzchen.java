package omaBacktPlätzchen;

public class OmaBacktPlätzchen
{
	public static void main(String[] args)
	{		
		Grandma oma = new Grandma("Oma");
		Thread t = new Thread(oma);
		t.setPriority(10);
		t.start();
		//new Thread(new Grandma("Oma"), "Oma").start();
		
		new Thread(new Grandchild("Janine"), "Janine").start();
		new Thread(new Grandchild("Hans  "), "Hans").start();
		new Thread(new Grandchild("Linda "), "Linda").start();
		new Thread(new Grandchild("Kevin "), "Kevin").start();
	}
}
