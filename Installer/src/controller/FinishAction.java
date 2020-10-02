package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.AppCore;
import model.Softver;
import model.SoftverskaKompanija;
import view.PreviewFrame;

public class FinishAction extends AbstractAction {
	public FinishAction() {
		putValue(NAME, "Finish");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SoftverskaKompanija sk=AppCore.getInstance().getRoot();
		for(Softver s:sk.getSoftveri()){
			new PreviewFrame(s);
		}
		AppCore.getInstance().getMainFrame().dispose();
	}

}
