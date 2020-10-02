package controller;

import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.ExpandVetoException;

import app.AppCore;
import treeNodeModels.DocumentTreeModel;

public class TreeExpansionListener implements TreeWillExpandListener{

	@Override
	public void treeWillCollapse(TreeExpansionEvent arg0) throws ExpandVetoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void treeWillExpand(TreeExpansionEvent arg0) throws ExpandVetoException {
		if(AppCore.getInstance().getMainFrame().getTreePanel().getSelection() instanceof DocumentTreeModel){
			throw new ExpandVetoException(arg0);
		}
		
	}

}
