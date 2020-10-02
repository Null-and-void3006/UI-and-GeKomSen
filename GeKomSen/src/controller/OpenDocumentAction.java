package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.OpenDocumentDialog;

public class OpenDocumentAction extends AbstractAction{
public OpenDocumentAction() {
	putValue(NAME, "Open Document");
}
	@Override
	public void actionPerformed(ActionEvent e) {
		new OpenDocumentDialog();
		
	}

}
