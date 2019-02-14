package malegut;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

/**
 * 
 * 
 * 
 *         Malprogramm:
 * 
 *         mousePressed -> Linie 
		   mousePressed+ALT -> Keis 
		   mousePressed+STRG -> Rechteck 
		   mousePressed+SHIFT -> Dreieck 
		   Entf -> Letzte gemalte Form entfernen 
		   Enter -> Als png speichern
		   
		  
 */




public class Malen extends Frame 
{
	// hier werden die gemalten formen gehalten:
	
	ArrayList<Object> formen;
	Rectangle aktuellesRechteck;
	Circle aktuellerKreis;
	Line aktuelleLinie;
	Triangle aktuellesDreieck;
	//dieses objekt wird genutzt, um das animierte vorzuzeichnen und dann komplett auszugeben
	private Image img;
	//hier soll das Graphics-Objekt des Bildes(Image) gehalten werden
	private Graphics graph;
	
	

	int tmpX; // tmp zum speichern des startpunktes des rechtecks
	int tmpY; // -> zum aufziehen in alle richtungen

	public Malen() 
	{
		super("Malprogramm");
		formen = new ArrayList<Object>();
		aktuellesRechteck = new Rectangle(0, 0, 0, 0);
		aktuellerKreis = new Circle(0, 0, 0);
		aktuelleLinie = new Line(0, 0, 0, 0);
		aktuellesDreieck = new Triangle(0, 0, 0, 0);
		// listener registrieren(innere klassen)
		addMouseListener(new MyMausListener());
		addMouseMotionListener(new MyMausMotionListener());
		addWindowListener(new MyWindowListener());
		addKeyListener(new MyKeyListener());
		// grösse und position des Frames
		setSize(400, 400);
		setLocation(200, 300);
		setVisible(true);

	}

	@Override
    public void update(Graphics g)
    {
		//init des doppelpuffers in form eines "offscreen-images"
		//createImage ist eine methode der superklasse Component und dient der doppelpufferung
		if(img==null)
		{
		    img=createImage(this.getSize().width, this.getSize().height);
		    graph=img.getGraphics();
		    
		}
		//bildschirm im hintergrund löschen
		graph.setColor(getBackground());
		graph.fillRect(0, 0, this.getSize().width, this.getSize().height);
		//zeichnen der eigentlichen ausgabe auf der "gelöschten" fläche
		graph.setColor(getForeground());
		//an die paint wird das graphics des images übergeben....diese zeichnet also auf dem image vor
		paint(graph);
		//offscreen auf den bildschirm kopieren
		g.drawImage(img, 0, 0, this);
	
    }
	
	
	
	
	@Override
	public void paint(Graphics g) 
	{
		
		// zuerst alle bisherigen formen aus der Liste malen:
		// formen werden anhand des typen unterschieden und gezeichnet
		Iterator<Object> it = formen.iterator();
		while (it.hasNext()) 
		{
			Object form = it.next();
			if (form instanceof Rectangle) 
			{
				Rectangle rect = (Rectangle) form;
				g.drawRect(rect.x, rect.y, rect.width, rect.height);
			}
			if (form instanceof Circle) 
			{
				Circle cir = (Circle) form;
				g.drawOval(cir.x, cir.y, cir.durchmesser, cir.durchmesser);
			}
			if (form instanceof Line) 
			{
				Line linie = (Line) form;
				g.drawLine(linie.x1, linie.y1, linie.x2, linie.y2);
			}
			if (form instanceof Triangle) 
			{
				Triangle dreick = (Triangle) form;
				g.drawPolygon(dreick.xPoints, dreick.yPoints, 3);
			}

		}

		// das aktuell gemalte rechteck ausgeben:
		if (aktuellesRechteck.x > 0 || aktuellesRechteck.y > 0) 
		{
			g.drawRect(aktuellesRechteck.x, aktuellesRechteck.y,
					aktuellesRechteck.width, aktuellesRechteck.height);
		}
		// den aktuell gemalten kreis ausgeben:
		if (aktuellerKreis.durchmesser > 0) 
		{
			g.drawOval(aktuellerKreis.x, aktuellerKreis.y,
					aktuellerKreis.durchmesser, aktuellerKreis.durchmesser);
		}
		// die aktuell gemalte linie ausgeben:
		if (aktuelleLinie.x1 != aktuelleLinie.x2
				|| aktuelleLinie.y1 != aktuelleLinie.y2) 
		{
			g.drawLine(aktuelleLinie.x1, aktuelleLinie.y1, aktuelleLinie.x2,
					aktuelleLinie.y2);
		}
		// das aktuell gemalte dreick ausgeben
		if (aktuellesDreieck.x1 > 0 || aktuellesDreieck.y1 > 0) 
		{
			g.drawPolygon(aktuellesDreieck.xPoints, aktuellesDreieck.yPoints, 3);
		}

	}

	class MyMausListener extends MouseAdapter 
	{
		@Override
		public void mousePressed(MouseEvent e) 
		{
			if (e.isControlDown()) {
				// sobald maustaste+strg gedrückt wurde, wird das momentan
				// gezeichnete rechteck
				// auf der variablen "aktuellesRechteck" abgelegt und gehalten

				aktuellesRechteck = new Rectangle(e.getX(), e.getY(), 0, 0);
				tmpX = e.getX();
				tmpY = e.getY();

			}
			// sobald maustaste+alt gedrückt wird
			else if (e.isAltDown()) 
			{

				aktuellerKreis = new Circle(e.getX(), e.getY(), 0);
			}
			// sobald maustaste+shift gedrückt wird
			else if (e.isShiftDown()) 
			{
				aktuellesDreieck = new Triangle(e.getX(), e.getY(), 0, 0);
			}
			// wenn nur die maustaste gedrückt wird
			else 
			{
				aktuelleLinie = new Line(e.getX(), e.getY(), 0, 0);
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) 
		{

			// prüfen, ob auch wirklich ein rechteck gezogen wurde
			if (aktuellesRechteck.width > 0 && aktuellesRechteck.height > 0) 
			{

				// fertiges rechteck in der list ablegen
				formen.add(aktuellesRechteck);
				// erzeugen eines neuen leeren objects um nicht mehrfach das
				// selbe
				// objekt(oder nicht gezeichnete) in der liste zu speichen
				// wichtig zum löschen des letzten elements aus der liste
				// analog die anderen fälle siehe Kreis, Linie, Dreieck
				aktuellesRechteck = new Rectangle(0, 0, 0, 0);
			}
			// prüfen, ob auch wirklich ein Kreis gezogen wurde
			else if (aktuellerKreis.durchmesser > 0) 
			{
				formen.add(aktuellerKreis);
				aktuellerKreis = new Circle(0, 0, 0);

			}
			// prüfen, ob der endpunkt sich vom zielpunkt unterscheidet
			else if (aktuelleLinie.x1 != aktuelleLinie.x2
					|| aktuelleLinie.y1 != aktuelleLinie.y2) 
			{
				formen.add(aktuelleLinie);
				aktuelleLinie = new Line(0, 0, 0, 0);
			}
			// prüfen, ob auch wirklich ein dreick gezogen wurde
			else if (aktuellesDreieck.x1 > 0 || aktuellesDreieck.y1 > 0) 
			{
				formen.add(aktuellesDreieck);
				aktuellesDreieck = new Triangle(0, 0, 0, 0);
			}

		}
	}

	class MyMausMotionListener extends MouseMotionAdapter 
	{
		@Override
		public void mouseDragged(MouseEvent e) 
		{

			if (e.isControlDown()) 
			{
				// zwischenpseichern von aktuellem x und y
				int x = e.getX();
				int y = e.getY();

				if (x > tmpX) 
				{
					if (x > aktuellesRechteck.x) 
					{
						aktuellesRechteck.width = (int) (x - aktuellesRechteck
								.getX());

						// neuzeichnen anfordern
						repaint();
					}
				} 
				else 
				{
					aktuellesRechteck.x = x;
					aktuellesRechteck.width = tmpX - x;
					repaint(); // neuzeichnen
				}
				if (y > tmpY) 
				{
					if (y > aktuellesRechteck.y) 
					{
						aktuellesRechteck.height = (int) (y - aktuellesRechteck
								.getY());
						repaint(); // neuzeichen
					}
				} 
				else 
				{
					aktuellesRechteck.y = e.getY();
					aktuellesRechteck.height = tmpY - aktuellesRechteck.y;
					repaint(); // neuzeichen
				}

				if (x < aktuellesRechteck.x) 
				{
					// drehen des rechtecks x-position
					// -> startpunkt neu setzen und zielpunkt aus dem
					// zwischengespeicherten
					// startpunkt und dem neun startpunkt berechnen, diesen
					// abstand als
					// weite nehmen --> analog Y-Wert
					aktuellesRechteck.x = x;
					aktuellesRechteck.width = tmpX - x;
					repaint(); // neuzeichnen
				}
				if (y < aktuellesRechteck.y) 
				{
					aktuellesRechteck.y = e.getY();
					aktuellesRechteck.height = tmpY - aktuellesRechteck.y;
					repaint(); // neuzeichen
				}
			} 
			else if (e.isAltDown()) 
			{
				// zwischenpseichern von aktuellem x und y
				int x = e.getX();
				int y = e.getY();

				if (x > aktuellerKreis.x && y > aktuellerKreis.y) 
				{

					// durchmesser bestimmen anhand der weit enferntesten
					// koordinaten
					// position wenn x weiter x-abstand, y analog
					if (x >= y) 
					{
						aktuellerKreis.durchmesser = x - aktuellerKreis.x;
					} 
					else 
					{
						aktuellerKreis.durchmesser = y - aktuellerKreis.y;
					}
					repaint();// neuzeichnen
				}

			} 
			else if (e.isShiftDown()) 
			{
				if (aktuellesDreieck.x1 > 0 || aktuellesDreieck.y1 > 0) 
				{
					aktuellesDreieck.x2 = e.getX();
					aktuellesDreieck.y2 = e.getY();
					// die methode setPoints() errechnet aus den erfassten
					// Punkten(start und zeil) drei Punkte um das dreick um das
					// dreick zu zeichnen (polygon), siehe Klasse Triangle
					aktuellesDreieck.setPoints(aktuellesDreieck.x1,
							aktuellesDreieck.y1, aktuellesDreieck.x2,
							aktuellesDreieck.y2);
					repaint();
				}

			} 
			else 
			{
				if (aktuelleLinie.x1 != aktuelleLinie.x2
						|| aktuelleLinie.y1 != aktuelleLinie.y2) 
				{

					aktuelleLinie.x2 = e.getX();
					aktuelleLinie.y2 = e.getY();
					repaint();
				}
			}

		}

	}

	class MyWindowListener extends WindowAdapter 
	{

		@Override
		public void windowClosing(WindowEvent e) 
		{
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	class MyKeyListener extends KeyAdapter 
	{
		private int bildIndex;

		// Beim drücken von del wird das letzte object in der Liste der gemalten
		// Formen gelöscht
		@Override
		public void keyPressed(KeyEvent e) 
		{
			// prüfen, ob gedrückte taste del ist
			if (e.getKeyCode() == KeyEvent.VK_DELETE) 
			{
				if (!formen.isEmpty()) 
				{
					formen.remove(formen.size() - 1);
					repaint();
				}

			}
			//wenn ENTER gedrückt, dann gemalte Inhalte als PNG exportieren
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				BufferedImage bild=new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
				Graphics gr=bild.createGraphics();
				gr.setColor(Color.BLACK);
				paint(gr);
				
				try {
					ImageIO.write(bild, "png", new File("savedImages/zeichnung" + bildIndex++ + ".png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}
	
	
	
	

	public static void main(String[] args) 
	{
		new Malen();
	}
}


