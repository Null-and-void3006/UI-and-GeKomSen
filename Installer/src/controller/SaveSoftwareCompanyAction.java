package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import app.AppCore;
import model.SoftverskaKompanija;
import view.ModuoCreationPanel;
import view.SoftwareCompanyEditingPanel;
import view.SoftwareCreationPanel;

public class SaveSoftwareCompanyAction extends AbstractAction {
	private SoftverskaKompanija sk;
	public SaveSoftwareCompanyAction() {
		putValue(NAME, "Save");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sk=((SoftwareCompanyEditingPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getSk();
		sk.setIme(((SoftwareCompanyEditingPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getSoftwareCompanyName());
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
	}

}
