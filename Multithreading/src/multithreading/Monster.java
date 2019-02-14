package multithreading;

public class Monster extends Thread 
{
	private int lebenspunkte;
	private String name;
	
	public Monster(String name)
	{
		super(name);
		this.name=name;
		lebenspunkte=10000;
	}
	
	@Override
	public void run()
	{
		bewegen();
	}
	
	
	
	public void bewegen()
	{
		while(lebenspunkte>0)
		{
			System.out.println("Ich bin das Monster " + Thread.currentThread().getName() + "  und ich bewege mich.....");
			fight();
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + " ist tot.");
	}
	
	public void fight()
	{
		lebenspunkte=lebenspunkte-1000;
	}
	
	
}
