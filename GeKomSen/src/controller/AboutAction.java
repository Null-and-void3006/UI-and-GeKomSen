package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import app.AppCore;
import view.AboutDialog;

public class AboutAction extends AbstractAction{
	
	public AboutAction() {

		putValue(NAME, "About us");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		AppCore.getInstance().seeAbout();
		
	}
}
