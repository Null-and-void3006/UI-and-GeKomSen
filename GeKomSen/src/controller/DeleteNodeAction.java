package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import app.AppCore;
import treeNodeModels.TreeNodeOverrides;
import view.RemoveFromJTreeDialog;

public class DeleteNodeAction extends AbstractAction{

	
	public DeleteNodeAction() {
		putValue(NAME, "Remove");
		putValue(SHORT_DESCRIPTION, "Remove node from tree");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object target = AppCore.getInstance().getMainFrame().getTreePanel().getJTree().getLastSelectedPathComponent();
		if(target==null)return;
		if(target instanceof TreeNodeOverrides){
			
			new RemoveFromJTreeDialog((TreeNodeOverrides) target).setVisible(true);
			
			/*((TreeNodeOverrides)((TreeNodeOverrides) target).getParent()).remove((MutableTreeNode)target);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getJTree());*/
		}
		
	}

}
