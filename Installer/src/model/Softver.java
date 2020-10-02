package model;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;

import controller.FileController;
import view.JTreeModel;

public class Softver extends DefaultMutableTreeNode implements GetModel{
	private String name;
	private ArrayList<Moduo> moduli = new ArrayList<>();
	private SoftverskaKompanija sk=null;
	public Softver(String name) {
		this.name=name;
	}
	public void addModul(Moduo m){
		moduli.add(m);
		m.setParent(this);
	}
	
	@Override
	public void remove(int childIndex) {
		moduli.remove(childIndex);
	}
	@Override
	public void remove(MutableTreeNode aChild) {
		moduli.remove(aChild);
	}
	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return moduli.size();
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public TreeNode getChildAt(int index) {
		// TODO Auto-generated method stub
		return moduli.get(index);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public Object getInfoModel() {
		// TODO Auto-generated method stub
		return this;
	}
	@Override
	public void setInfoModel(Object obj) {
		// TODO Auto-generated method stub
		Softver a=(Softver)obj;
		this.name=a.name;
	}
	public ArrayList<Moduo> getModuli() {
		return moduli;
	}
	@Override
	public void setParent(MutableTreeNode newParent) {
		parent=newParent;
	}
	@Override
	public TreeNode getParent() {
		return parent;
	}
	@Override
	public int getIndex(TreeNode aChild) {
		return moduli.indexOf(aChild);
	}
	public void saveAll(){
		FileController.saveSoftware(this);
		for(Moduo m:moduli){
			m.saveAll();
		}
	}
	
}
