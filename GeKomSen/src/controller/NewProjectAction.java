package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.NewProjectDialog;

public class NewProjectAction extends AbstractAction{
	public NewProjectAction() {
		putValue(NAME, "New Project");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new NewProjectDialog();
		
	}

}
