package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.security.auth.login.AppConfigurationEntry;
import javax.swing.AbstractAction;

import app.AppCore;

public class NextPanelAction extends AbstractAction{
	private Locale lokal;
	private ResourceBundle rb;
	
	public NextPanelAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, rb.getString("next"));
		putValue(SHORT_DESCRIPTION, rb.getString("skip"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AppCore.getInstance().getMainFrame().next();
		
	}

}
