package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.NewELCView;

public class AddLogicalElementAction extends AbstractAction{
private NewELCView elcv;


	public AddLogicalElementAction(NewELCView elcv) {
	super();
	this.elcv = elcv;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		elcv.saveElement();
		
	}

}
