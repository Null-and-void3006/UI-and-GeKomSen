package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import view.HelpFrame;

public class HelpAction extends AbstractAction {
	
	private Locale lokal;
	private ResourceBundle rb;

	public HelpAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);

		putValue(NAME, rb.getString("help"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new HelpFrame();
		
	}

}
