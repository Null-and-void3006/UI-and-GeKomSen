package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.SwingUtilities;

import app.AppCore;
import view.TreePopup;

public class TreeMouseListener extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {

	    if (SwingUtilities.isRightMouseButton(e)) {

	        int row = AppCore.getInstance().getMainFrame().getPanelLeft().getJt().getClosestRowForLocation(e.getX(), e.getY());
	        AppCore.getInstance().getMainFrame().getPanelLeft().getJt().setSelectionRow(row);
	        new TreePopup().show(e.getComponent(), e.getX(), e.getY());
	    }
	}
}
