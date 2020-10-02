package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

import app.AppCore;
import view.AboutDialog;

public class CloseDialogAction extends AbstractAction{

	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AppCore.getInstance().closeCurrentDialog();
		
	}

}
