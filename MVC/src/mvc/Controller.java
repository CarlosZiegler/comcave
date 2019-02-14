package mvc;

import java.awt.event.*;

//vermittelt zwischen view und model....
public class Controller 
{
	//attribute
	private View view;
	private Model model;
	private MyListener listener;
	
	
	
	public Controller()
	{
		view=new View();
		model=new Model(this);
		listener=new MyListener();
		vermittleListener();
	}
	
	//innere klasse
	private class MyListener extends WindowAdapter implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getActionCommand().equals("Verbinden"))
			{
				model.dbConnect(view.getEingabe());
			}
		}
	}
	
	//methode, welche den eigenen listener an die view übergibt
	private void vermittleListener()
	{
		view.setzeActionListener(listener);
	}
	
	//meldungen vom model werden weitergeleitet an die view(statuszeile)
	public void vermittleMeldungAnView(String meldung)
	{
		view.setStatusMeldung(meldung);
	}
	
	public void vermittleDatenAnView(String[] spalten, Object[][] daten)
	{
		view.fillTabelle(spalten, daten);
	}
	
}
