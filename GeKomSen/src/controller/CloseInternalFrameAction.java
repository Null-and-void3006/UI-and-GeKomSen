package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.InternalDocumentFrame;

public class CloseInternalFrameAction extends AbstractAction{
private InternalDocumentFrame idf;

public CloseInternalFrameAction(InternalDocumentFrame idf) {
	putValue(NAME, "Close");
	this.idf = idf;
}

@Override
public void actionPerformed(ActionEvent arg0) {
	idf.dispose();
	
}

}
