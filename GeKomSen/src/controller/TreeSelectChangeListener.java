package controller;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import app.AppCore;
import treeNodeModels.TreeNodeOverrides;

public class TreeSelectChangeListener implements TreeSelectionListener{

	private JTree myTree;
	
	public TreeSelectChangeListener(JTree tt) {
		myTree=tt;
	}
	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		AppCore.getInstance().getMainFrame().getTreePanel().setSelection((TreeNodeOverrides) myTree.getLastSelectedPathComponent());
		
	}

}
