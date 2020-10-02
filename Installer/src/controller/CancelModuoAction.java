package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import app.AppCore;
import view.ModuoCreationPanel;

public class CancelModuoAction extends AbstractAction {
	private Locale lokal;
	private ResourceBundle rb;

	public CancelModuoAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, rb.getString("cancel"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((ModuoCreationPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).cancel();
		
	}

}
