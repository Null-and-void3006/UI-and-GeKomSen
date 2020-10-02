package controller;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import app.AppCore;
import view.WorkspaceChangeDialog;

public class OpenWorkspaceAction extends AbstractAction {
	
	public OpenWorkspaceAction() {
		putValue(NAME, "Open Workspace");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new WorkspaceChangeDialog();
	}

}
