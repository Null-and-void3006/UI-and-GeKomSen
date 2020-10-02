package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import app.AppCore;
import model.Moduo;
import view.ModuoCreationPanel;

public class SaveModuoAction extends AbstractAction {
	private Locale lokal;
	private ResourceBundle rb;
	private Moduo m;
	public SaveModuoAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, rb.getString("save"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m=((ModuoCreationPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getModuo();
		m.setName(((ModuoCreationPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).saveModuoName());
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
	}

}
