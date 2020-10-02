package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import app.AppCore;
import model.Softver;
import view.PreviewFrame;

public class PreviewAction extends AbstractAction {
	private Locale lokal;
	private ResourceBundle rb;

	public PreviewAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, rb.getString("preview"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		Object target = AppCore.getInstance().getMainFrame().getPanelLeft().getJt().getSelectionPath().getLastPathComponent();
		if(target instanceof Softver){
			new PreviewFrame((Softver)target);
		}
		else{
			JOptionPane.showConfirmDialog(null, rb.getString("please"));
		}
	}

}
