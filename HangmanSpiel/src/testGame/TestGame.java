package testGame;
import hangman.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGame {
	Player a;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testConstructorGame() {
		a = new Player("Jose");
		Game game001 = new Game(a);
		
		assertTrue(game001 != null);
		//System.out.println(game001.getWort().size());
	}
	@Test
	public void testHashmap() {
		a = new Player("Jose");
		Game game001 = new Game(a);
		assertTrue(game001.getWort().size()!=0);
		
	}
	
	public void testGetwort() {
		a = new Player("Jose");
		Game game001 = new Game(a);
		assertTrue(game001.getWort()!=null);
		
		
	}
	public void testGetwortSize() {
		a = new Player("Jose");
		Game game001 = new Game(a);
		assertTrue(game001.getWort().size() == 6);
		
		
	}
	
	

}
