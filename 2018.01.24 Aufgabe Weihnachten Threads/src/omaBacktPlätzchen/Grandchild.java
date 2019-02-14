package omaBacktPlätzchen;

import java.util.Random;

public class Grandchild implements Runnable
{
	private String name;
	private Random r;

	public Grandchild(String name)
	{
		this.name = name;
		r = new Random();
	}
		
	@Override
	public void run()
	{
		while(true)
		{
			synchronized (CookieJar.class)
			{
				if(CookieJar.isBaked())
				{
					int eatBiscuits = r.nextInt(15)+5;
					if(CookieJar.getBiscuits()<=eatBiscuits)
					{
						eatBiscuits = CookieJar.getBiscuits();
					}
					CookieJar.setBiscuits(CookieJar.getBiscuits()-eatBiscuits);
					System.out.println("Grandchild " + name + " eats " + eatBiscuits + ".\tIn the cookie jar are " + CookieJar.getBiscuits() + " biscuits.");
					
					// Wenn eins der Kinder mehr als 18 Kekse auf einmal gegessen hat, 
					// dann darf dieses keine weiteren Kekse mehr essen, bis die Oma eine weitere neue Ladung gebacken hat.
					if(eatBiscuits>=18)
					{
						waitForNewCookies();
					}
					// Sobald weniger als 20 Kekse da sind, wird die Oma zum weiteren Backen benachrichtigt und die Enkelkinder warten.
					if(CookieJar.getBiscuits()<=20)
					{
						CookieJar.class.notifyAll();
						CookieJar.setBaked(false);
						waitForNewCookies();
					}
				}
					
			}
			
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				//ToDo Exception Logs
				e.printStackTrace();
			}
		}
	}
	
	private static void waitForNewCookies()
	{		
		try
		{
			CookieJar.class.wait();
		}
		catch(InterruptedException e)
		{
			//ToDo Exception Logs
			e.printStackTrace();
		}
	}
}
