package mvc;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.*;



public class View extends JFrame 
{
	private ActionListener action;
	private JTextField eingabe;
	private JTable tabelle;
	
	//konstruktor
	public View()
	{
		super("DB-Connector");
		setLayout(new BorderLayout());
		eingabe=new JTextField(50);
		ArrayList<JComponent> komponenten=new ArrayList<JComponent>();
		
		komponenten.add(new JLabel("Datenbankname: "));
		komponenten.add(eingabe);
		JButton verbinden=new JButton("Verbinden");
		//default-button setzen
		getRootPane().setDefaultButton(verbinden);
		
		komponenten.add(verbinden);
		JPanel pnlTemp=buildPanel(komponenten, new FlowLayout(FlowLayout.CENTER), true);
		//fertiges panel in die gui schrauben
		attachPanel(pnlTemp, BorderLayout.NORTH);
		komponenten.clear();
		//****JTABLE
		String[] spalten={"Vorname","Name", "Beruf", "KundenNr" };
		tabelle=new JTable(40, 4);
		
		
		JScrollPane scp=new JScrollPane(tabelle);
		//tabelle soll auch wenn sie leer ist den ganzen container räumlich ausfüllen:
		tabelle.setFillsViewportHeight(true);
		komponenten.add(scp);
		pnlTemp=buildPanel(komponenten, new FlowLayout(FlowLayout.CENTER), true);
		attachPanel(pnlTemp, BorderLayout.CENTER);
		
		JLabel lblStatus=new JLabel(" ");
		komponenten.clear();
		komponenten.add(lblStatus);
		pnlTemp=buildPanel(komponenten, new FlowLayout(FlowLayout.CENTER), true);
		attachPanel(pnlTemp, BorderLayout.SOUTH);
		
		setSize(200, 200);
		setLocation(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		
		
		
		
	}
	
	//methode, welche fertige JPanels zusammenschraubt mit den übergebenen Komponenten
	//und dem übergebenen Layout
	private JPanel buildPanel(ArrayList<JComponent> comps, LayoutManager l, boolean rahmen)
	{
		JPanel pnlTemp=new JPanel();
		//rahmen setzen?
		if(rahmen)
		{
			pnlTemp.setBorder(BorderFactory.createEtchedBorder());
		}
		//dem panel den übergebenen layoutmanager verpassen
		pnlTemp.setLayout(l);
		//alle komponenten aus der list ins panel übernehmen
		Iterator<JComponent> it=comps.iterator();
		while(it.hasNext())
		{
			pnlTemp.add(it.next());
		}
		
		return pnlTemp;
	}
	
	private void attachPanel(JPanel panel, Object constraint)
	{
		getContentPane().add(panel, constraint);
	}
	
	
	//nimmt einen actionlistener vom controller an und setzt ihn 
	public void setzeActionListener(ActionListener a)
	{
		action=a;
		JPanel pnlTemp=(JPanel)getContentPane().getComponent(0);
		JButton btnTemp=(JButton)pnlTemp.getComponent(2);
		btnTemp.addActionListener(a);
		
		
	}
	
	//nimmt eine statusmeldung entgegen und gibt sie in der statuszeile aus
	public void setStatusMeldung(String meldung)
	{
		JPanel pnlTemp=(JPanel)getContentPane().getComponent(2);
		JLabel lblTemp=(JLabel)pnlTemp.getComponent(0);
		lblTemp.setText(meldung);
	}
	
	//liefert den aktuellen textinhalt des eingafeldes
	public String getEingabe()
	{
		return eingabe.getText();
	}
	
	public void fillTabelle(String[] spalten, Object[][] daten)
	{
		
		DefaultTableModel model=new DefaultTableModel(spalten, 0);
		for(int i=0;i<daten.length;i++)
		{
			model.addRow(daten[i]);
			
		}
		tabelle.setModel(model);
		
	}
	
}
