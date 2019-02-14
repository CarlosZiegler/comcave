package omaBacktPlätzchen;

public class CookieJar
{
	private static int biscuits;
	private static boolean baked = false;
	
	public static void fillCookieJar(int newBiscuits)
	{
		biscuits += newBiscuits;
	}

	public static int getBiscuits() {
		return biscuits;
	}

	public static void setBiscuits(int biscuits) {
		CookieJar.biscuits = biscuits;
	}

	public static boolean isBaked() {
		return baked;
	}

	public static void setBaked(boolean baked) {
		CookieJar.baked = baked;
	}
}
