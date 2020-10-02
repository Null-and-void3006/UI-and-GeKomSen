package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.AppCore;

public class InitializeWorkspaceAction extends AbstractAction{
public InitializeWorkspaceAction() {
	putValue(NAME, "Confirm");
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		AppCore.getInstance().getCurrentDialog().setVisible(false);
		AppCore.getInstance().initWorkspace();
		
	}

}
