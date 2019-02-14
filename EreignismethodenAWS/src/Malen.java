import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Malen extends Frame {

	// hier werden alle bereit gezeichneten rechtneten gespeichent
	private ArrayList<Rectangle> alleRechtecke;
	// das aktuel gezeichnete recheck hier gespeichert
	private Rectangle aktRechecke;
	private MouseListener mListener;

	public Malen() {

		super("MalenMitZahlen");
		alleRechtecke = new ArrayList<Rectangle>();
		aktRechecke = new Rectangle(0, 0, 0, 0);
		// listener für maus registrieren
		addWindowListener(new FensterSchliesser());
		addMouseListener(new MyMausListener());
		addMouseMotionListener(new MyMouseMotionListener());
		
		
		
		
		

		// dimension und position des fensters
		setSize(450, 450);
		setLocation(200, 350);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		// hier ird gemalt...
		// alle bisher gespeichet rechtecke neu zeichnen
		Rectangle temp;
		Iterator<Rectangle> it = alleRechtecke.iterator();
		while (it.hasNext()) {
			temp = (Rectangle) it.next();
			g.drawRect(temp.x, temp.y, temp.width, temp.height);
		}

		// hier wir das aktuelll gemalt recheck ausgegeben:
		if (aktRechecke.x > 0 || aktRechecke.y > 0) {
			g.drawRect(aktRechecke.x, aktRechecke.y, aktRechecke.width, aktRechecke.height);
		}

	}

	/*
	 * Innere klassen Events
	 */
	private class FensterSchliesser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			dispose();
			System.exit(0);

		}

	}
	
	private class MyMausListener extends MouseAdapter{

		
		@Override
		public void mousePressed(MouseEvent e) {
			aktRechecke = new Rectangle(e.getX(),e.getY(),0,0);
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			if (aktRechecke.width>0 && aktRechecke.height>0) {
				//gemaltes rechteck in der arrayList ablegen
				alleRechtecke.add(aktRechecke);
			}
			
		}

	
		
		
		
		
		
		
		
		
		
		
	}
	
	private class MyMouseMotionListener extends MouseMotionAdapter{
		
		@Override
		public void mouseDragged(MouseEvent e) {
			
			//aktuell mauspos Speichern
			int x = e.getX();
			int y = e.getY();
			if (x>aktRechecke.x && y > aktRechecke.y) {
				
				aktRechecke.width = (int)(x-aktRechecke.getX());
				aktRechecke.height = (int)(y-aktRechecke.getY());
				repaint();
			}
			
			
			
			
		}
		
	}
	
	
	
	

	public static void main(String[] args) {

		new Malen();

	}

}
