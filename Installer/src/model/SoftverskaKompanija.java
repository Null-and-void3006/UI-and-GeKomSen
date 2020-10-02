package model;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import view.JTreeModel;

public class SoftverskaKompanija extends DefaultMutableTreeNode {
	private ArrayList<Softver> softveri = new ArrayList<>();
	private String ime;
	private String opis;
	private ImageIcon logo;
	private String grad;
	private String adresa;
	private String kontaktTelefon;
	
	public SoftverskaKompanija(String ime, String opis, ImageIcon logo, String grad, String adresa,
			String kontaktTelefon) {
		super();
		this.ime = ime;
		this.opis = opis;
		this.logo = logo;
		this.grad = grad;
		this.adresa = adresa;
		this.kontaktTelefon = kontaktTelefon;
	}
	public SoftverskaKompanija() {
		this.ime="Untitled";
	}
	
	
	
	@Override
	public void remove(int childIndex) {
		softveri.remove(childIndex);
	}




	@Override
	public void remove(MutableTreeNode aChild) {
		softveri.remove(aChild);
	}
	
	



	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getOpis() {
		return opis;
	}



	public void setOpis(String opis) {
		this.opis = opis;
	}



	public ImageIcon getLogo() {
		return logo;
	}



	public void setLogo(ImageIcon logo) {
		this.logo = logo;
	}



	public String getGrad() {
		return grad;
	}



	public void setGrad(String grad) {
		this.grad = grad;
	}



	public String getAdresa() {
		return adresa;
	}



	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}



	public String getKontaktTelefon() {
		return kontaktTelefon;
	}



	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}



	public ArrayList<Softver> getSoftveri() {
		return softveri;
	}

	public void addSoftware(Softver sf){
		softveri.add(sf);
		sf.setParent(this);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return softveri.size();
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
		return softveri.get(index);
	}
	
	@Override
	public String toString() {
		return ime;
	}



	@Override
	public int getIndex(TreeNode aChild) {
		return softveri.indexOf(aChild);
	}
	
	
	
	
	
	
	

}
