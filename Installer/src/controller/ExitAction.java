package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import app.AppCore;

public class ExitAction extends AbstractAction {
	private Locale lokal;
	private ResourceBundle rb;

	public ExitAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, rb.getString("cancel"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		AppCore.getInstance().getMainFrame().dispose();
		
	}
	
}
