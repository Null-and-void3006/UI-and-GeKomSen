package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.NewDocumentDialog;

public class NewDocumentAction extends AbstractAction{
	public NewDocumentAction() {
		putValue(NAME, "New Document");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new NewDocumentDialog();
		
	}

}
