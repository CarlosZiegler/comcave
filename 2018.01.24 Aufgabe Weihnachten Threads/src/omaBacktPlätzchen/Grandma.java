package omaBacktPlätzchen;

public class Grandma implements Runnable
{
	private String name;
	private static final int NEWBISCUITS=36;
		
	public Grandma(String name)
	{
		this.name = name;
	}

	@Override
	public void run()
	{
		while(true)
		{
			synchronized (CookieJar.class)
			{
				CookieJar.fillCookieJar(NEWBISCUITS);
				System.out.println("Granny" + name + " bakes " + NEWBISCUITS + " new cookies.\tIn the cookie jar are " + CookieJar.getBiscuits() + " biscuits.");
				
				// Sobald mehr als 100 Kekse gebacken sind, macht Oma pause und bietet sie diese ihren vier Enkelkindern an.
				if(CookieJar.getBiscuits()>100)
				{
					CookieJar.setBaked(true);
					CookieJar.class.notifyAll();
					
					try
					{
						CookieJar.class.wait();
					}
					catch(InterruptedException e)
					{
						// ToDo Exception Logs
						e.printStackTrace();
					}
				}
			}
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				// ToDo Exception Logs
				e.printStackTrace();
			}
		}
	}
}
