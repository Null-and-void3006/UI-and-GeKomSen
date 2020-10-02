package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.TextElementView;

public class SaveTextElementAction extends AbstractAction{

	private TextElementView txa;
	
	public SaveTextElementAction(TextElementView txa)
	{
		putValue(NAME, "Save");
		this.txa = txa;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		txa.saveElement();
	}

}
