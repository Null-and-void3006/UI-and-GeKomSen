package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.EditTextElementDialog;

public class EditTextAction extends AbstractAction{
private EditTextElementDialog eted;

public EditTextAction(EditTextElementDialog eted) {
	super();
	this.putValue(NAME, "Save");
	this.eted = eted;
}

@Override
public void actionPerformed(ActionEvent e) {
	eted.saveElement();
	
}

}
