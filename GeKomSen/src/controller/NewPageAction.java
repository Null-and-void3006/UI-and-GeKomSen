package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.InternalDocumentFrame;

public class NewPageAction extends AbstractAction{
private InternalDocumentFrame idf;

	
	public NewPageAction(InternalDocumentFrame idf) {
	super();
	putValue(NAME, "Add Page");
	this.idf = idf;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		idf.addPage();
		
	}

}
