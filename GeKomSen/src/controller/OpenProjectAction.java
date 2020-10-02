package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.OpenProjectDialog;

public class OpenProjectAction extends AbstractAction{
	public OpenProjectAction() {
		putValue(NAME, "Open Project");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new OpenProjectDialog();
		
	}

}
