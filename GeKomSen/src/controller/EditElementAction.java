package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import app.AppCore;
import treeNodeModels.DocumentTreeModel;
import treeNodeModels.ElementTreeModel;
import view.EditELCView;
import view.ElementLogicalCircuitView;
import view.LogicalCircuitPanel;

public class EditElementAction extends AbstractAction{
	private LogicalCircuitPanel lcp;
	private EditELCView editd;
	public EditElementAction(LogicalCircuitPanel lcp, EditELCView d) {
		editd=d;
		this.lcp=lcp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		lcp.paintSelf();
		editd.validateEdit();
		AppCore.getInstance().closeCurrentDialog();
		//new EditELCView((ElementTreeModel) AppCore.getInstance().getMainFrame().getTreePanel().getSelection());
		
	}

}
