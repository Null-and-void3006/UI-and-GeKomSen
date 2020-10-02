package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.InternalDocumentFrame;

public class DeletePageAction extends AbstractAction{
	private InternalDocumentFrame idf;
public DeletePageAction(InternalDocumentFrame d) {
	idf=d;
		putValue(NAME, "DeletePage");
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		idf.deletePage();
	}

}
