package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import app.AppCore;

public class PreviousPanelAction extends AbstractAction{
	private Locale lokal;
	private ResourceBundle rb;
	
	public PreviousPanelAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, rb.getString("previous"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AppCore.getInstance().getMainFrame().previous();
		
	}

}
