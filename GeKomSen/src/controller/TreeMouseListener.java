package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import app.AppCore;
import treeNodeModels.DocumentTreeModel;
import treeNodeModels.ElementTreeModel;
import treeNodeModels.PageTreeModel;
import treeNodeModels.SlotTreeModel;
import view.TreePopupMenu;


public class TreeMouseListener extends MouseAdapter{

	public TreeMouseListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(SwingUtilities.isRightMouseButton(e)){
			JTree tree = AppCore.getInstance().getMainFrame().getTreePanel().getJTree();
			int row  = tree.getRowForLocation(e.getX(), e.getY());
			tree.setSelectionRow(row);
			TreePath tp = AppCore.getInstance().getMainFrame().getTreePanel().getJTree().getSelectionPath();
			if(tp == null) {new TreePopupMenu().show(e.getComponent(), e.getX(), e.getY());return;}
			Object target = tp.getLastPathComponent();
			/*if(target instanceof PageTreeModel||
				target instanceof SlotTreeModel ||
				target instanceof ElementTreeModel)return;*/
		    new TreePopupMenu().show(e.getComponent(), e.getX(), e.getY());	
		}
		
		if(e.getClickCount()==2){
			if(AppCore.getInstance().getMainFrame().getTreePanel().getSelection() instanceof DocumentTreeModel){
				AppCore.getInstance().getMainFrame().addInternalFrame();
			}
		}
		
		
		
	}
	
}
