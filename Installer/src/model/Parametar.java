package model;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import controller.FileController;
import view.JTreeModel;

public class Parametar extends DefaultMutableTreeNode {
	

	private String name;
	private Moduo parent=null;
	public Parametar(String name){
		this.name=name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public TreeNode getChildAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public void setParent(MutableTreeNode newParent) {
		parent=(Moduo) newParent;
	}
	@Override
	public TreeNode getParent() {
		return parent;
	}
	public void saveAll() {
		FileController.saveParametar(this);
	}


}
