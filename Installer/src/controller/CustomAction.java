package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import app.AppCore;

public class CustomAction extends AbstractAction{
	
	private String name, type, def, s;

	private Locale lokal;
	private ResourceBundle rb;
	
	public CustomAction()
	{
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);

		putValue(NAME, rb.getString("ok"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		 name = AppCore.getInstance().getMainFrame().getFp().getCustomPan().getTfName().getText();
		 type = AppCore.getInstance().getMainFrame().getFp().getCustomPan().getTfType().getText();
		 def = AppCore.getInstance().getMainFrame().getFp().getCustomPan().getTfDefault().getText();
		 
		 s = name +";"+ type +";"+def;
	}

}
