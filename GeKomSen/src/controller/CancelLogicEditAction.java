package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.EditELCView;

public class CancelLogicEditAction extends AbstractAction{
private EditELCView eelcv;

public CancelLogicEditAction(EditELCView eelcv) {
	super();
	this.eelcv = eelcv;
}

@Override
public void actionPerformed(ActionEvent e) {
	eelcv.cancelEdit();
	
}
}
