package controller;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import view.InternalDocumentFrame;

public class InternalDocumentFrameListener extends InternalFrameAdapter{
private InternalDocumentFrame idf;
	
	public InternalDocumentFrameListener(InternalDocumentFrame f) {
		idf=f;
	}
	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		InternalDocumentFrame.frameClosed();
		idf.saveDocument();
		super.internalFrameClosed(e);
		
		
	}

}
