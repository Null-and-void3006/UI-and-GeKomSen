package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.AppCore;

public class AddProjectFromDialogAction extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AppCore.getInstance().addNewProject();
		
	}

}
