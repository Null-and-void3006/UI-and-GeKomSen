package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import app.AppCore;
import model.Softver;
import view.ModuoCreationPanel;
import view.SoftwareCreationPanel;

public class SaveSoftwareAction extends AbstractAction {
	private Softver s;
	public SaveSoftwareAction() {
		putValue(NAME, "Save");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		s=((SoftwareCreationPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getSoftware();
		s.setName(((SoftwareCreationPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).saveSoftwareName());
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
	}

}
