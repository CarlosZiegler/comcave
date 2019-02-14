package gui2;
import java.awt.*;
import java.awt.event.*;

/*
 *  LayoutManager
 *  -------------
 *  
 *  -> Instanzen von Layout-Klassen, welche jeweils auf ihre spezifische Art und Weise Komponenten auf
 *     Containern anordnen und automatisch(implizit) skalieren
 *     
 *     
 *  -> Es gibt in AWT/Swing eine Reihe von "Standard"-Layoutmanagern
 *  
 *  -> Worauf kann man LayoutManager anwenden?
 *  
 *  	-> Alles, was Container ist -> Frame, Panel, Dialog...
 *  
 *  
 *  -> FlowLayout:
 *  
 *  	-> Komponenten werden einfach in Einfügereihenfolge von links nach rechts eingefügt
 *  
 *  	-> Standardausrichtung ist CENTER, ansonsten optional LEFT, RIGHT
 * 
 * 
 * 	-> GridLayout:
 * 
 * 		-> Komponenten werden in einem "Gitter"(ZeilenxSpalten) von links nach rechts in die Zellen
 * 		   eingefügt
 * 
 * 		-> Die Komponenten füllen die gesamte Zelle aus
 * 
 * 		-> new GridLayout(int zeilen, int spalten)
 * 
 * 		-> new GridLayout(int zeilen, int spalten, int hor_abst, int vert_abst)
 * 
 * 
 * 	-> BorderLayout:
 * 
 * 		-> Container wird virtuell aufgeteilt:
 * 
 * 			-> Ein North-Bereich -> Im obersten Bereich komplett von links nach rechts
 * 
 * 
 * 			-> Ein South-Bereich -> Im untersten Bereich komplett von links nach rechts
 * 
 * 
 * 			-> Ein East -> Rechter Teil zwischen North und South
 * 
 * 
 * 			-> Ein West -> Linker Teil zwischen North und South
 * 
 * 
 * 			-> Ein Center -> Die Mitte zwischen alle den anderen Bereichen
 * 
 * 
 * 
 * 	-> GridBagLayout 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class Hauptfenster extends Frame
{

	public Hauptfenster()
	{
		super("Hauptfenster");
		setSize(500, 500);
		setLocation(200, 200);
		//fensterschliesser:
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		//layout des fensters
		setLayout(new BorderLayout());
		
		//panel 1
		Panel pnlLabelButton=new Panel();
		//auf diesem panel soll ein FlowLayout liegen:
		pnlLabelButton.setLayout(new FlowLayout());
		Label lblBestaetigen=new Label("Bitte mit OK bestaetigen: ");
		Button btnOK=new Button("OK");
		//label und button ins panel einfügen
		pnlLabelButton.add(lblBestaetigen);
		pnlLabelButton.add(btnOK);
		//dieses panel ins fenster im norden des borderlayouts einfügen:
		add(pnlLabelButton, BorderLayout.NORTH);
		
		//panel 2
		Panel pnlMenueButtons=new Panel();
		pnlMenueButtons.setLayout(new GridLayout(2, 2));
		pnlMenueButtons.add(new Button("Speichern"));
		pnlMenueButtons.add(new Button("Abbrechen"));
		pnlMenueButtons.add(new Button("Beenden"));
		pnlMenueButtons.add(new Button("Öffnen"));
		//panel 2 im süden des borderlayouts des fensters einfügen:
		add(pnlMenueButtons, BorderLayout.SOUTH);
		
		setVisible(true);
		
		
		pack();
		
		
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Hauptfenster();

	}

}
