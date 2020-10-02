package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.AppCore;

public class ConfirmDeleteNodeAction extends AbstractAction{
public ConfirmDeleteNodeAction() {
	putValue(NAME, "Confirm");
}
	@Override
	public void actionPerformed(ActionEvent e) {
		AppCore.getInstance().handleDelete();
		
	}

}
