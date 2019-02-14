package multithreading;

public class Held extends Wesen implements Runnable 
{
	
	private int lebenspunkte;
	
	
	public Held(String name)
	{
		super(name);
		lebenspunkte=3000;
	}
	

	@Override
	public void run() 
	{
		while(lebenspunkte>0)
		{
			System.out.println("Ich bin der Held " + Thread.currentThread().getName());
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	
	
	
	
	
}
