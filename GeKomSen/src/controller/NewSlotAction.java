package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import view.InternalDocumentFrame;
import view.NewELCView;
import view.PagePanel;
import view.TextElementView;

public class NewSlotAction extends AbstractAction{
private PagePanel pp;
private InternalDocumentFrame idf;
private static final Object[] OPTIONS={"Text component","Logical Component","Cancel"};


public NewSlotAction(PagePanel pp,InternalDocumentFrame d) {
	super();
	this.idf=d;
	this.pp = pp;
	putValue(NAME, "Add Element");
}



@Override
public void actionPerformed(ActionEvent e) {
	int n=JOptionPane.showInternalOptionDialog(idf,
			"What kind of component would you like to add?",
			"Add new Element",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			OPTIONS,
			OPTIONS[1]
			);

	if(n==0){new TextElementView(pp,idf.getCurrentPage());}
	if(n==1){new NewELCView(pp,idf.getCurrentPage());}
	
}

}
