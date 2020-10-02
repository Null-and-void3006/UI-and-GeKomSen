package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import view.AboutFrame;

public class AboutAction extends AbstractAction{
	
	private Locale lokal;
	private ResourceBundle rb;

	public AboutAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);

		putValue(NAME, rb.getString("aboutUs"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new AboutFrame();
		
	}

}
