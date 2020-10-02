package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import commands.ELCVCommand;
import view.ElementLogicalCircuitView;

public class UndoRedoAction extends AbstractAction{
private ElementLogicalCircuitView elcv;
private ELCVCommand command;

	public UndoRedoAction(ElementLogicalCircuitView elcv, ELCVCommand command, String s) {
	super();
	this.elcv = elcv;
	this.command=command;
	putValue(NAME, s);
}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		command.execute(elcv);
		
	}

}
