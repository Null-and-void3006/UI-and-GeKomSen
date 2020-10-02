package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.AppCore;

public class CloseAllDocumentsAction extends AbstractAction{
	public CloseAllDocumentsAction() {
		putValue(NAME, "Close All Documents");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AppCore.getInstance().getMainFrame().closeInternals();
		
	}

}
