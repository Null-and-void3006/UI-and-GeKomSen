package model;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import controller.FileController;
import view.JTreeModel;

public class Moduo extends DefaultMutableTreeNode {
	private String name;
	private Softver parent = null;
	private ArrayList<Parametar> parametri = new ArrayList<>();
	public Moduo(String name) {
		this.name=name;
	}
	public void addParametar(Parametar p){
		p.setParent(this);
		parametri.add(p);
	}
	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return parametri.size();
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public TreeNode getChildAt(int index) {
		// TODO Auto-generated method stub
		return parametri.get(index);
	}
	
	
	
	@Override
	public int getIndex(TreeNode aChild) {
		return parametri.indexOf(aChild);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	public ArrayList<Parametar> getParametri() {
		return parametri;
	}
	@Override
	public void setParent(MutableTreeNode newParent) {
		parent = (Softver) newParent;
	}
	@Override
	public TreeNode getParent() {
		return parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void remove(int childIndex) {
		parametri.remove(childIndex);
	}
	@Override
	public void remove(MutableTreeNode aChild) {
		parametri.remove(aChild);
	}
	public void saveAll() {
		FileController.saveModuo(this);
		for(Parametar p:parametri){
			p.saveAll();
		}
	}
	
	
}
