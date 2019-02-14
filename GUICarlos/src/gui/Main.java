package gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame {

	WindowAdapter close = new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			// super.windowClosed(e);
			setVisible(false);
			dispose();
			System.exit(0);
		}

	};
	
	
	

	public Main() {
		super("CalculatorDemo");
		setSize(400, 500);
		setLocation(250, 250);
		addWindowListener(close);
		setVisible(true);
		
		
		
	}

	public static void main(String[] args) {

		new Main();
	}

}
