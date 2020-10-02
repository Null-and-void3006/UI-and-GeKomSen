package view;

import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ActionManager;
import model.SoftverskaKompanija;
import net.miginfocom.swing.MigLayout;

public class SoftwareCompanyEditingPanel extends JPanel {
	private JLabel lbname;
	private JButton save;
	private JTextField tfName;
	
	private SoftverskaKompanija sk;
	private String name;
	public SoftwareCompanyEditingPanel(SoftverskaKompanija sk) {
		super(new MigLayout());
		this.sk=sk;
		lbname=new JLabel("Type in the name of your software company");
		tfName=new JTextField(30);
		save=new JButton("Save");
		save.setAction(ActionManager.getInstance().getSaveSoftwareCompanyAction());
		this.add(lbname,"wrap");
		this.add(tfName, "wrap");
		this.add(save,"wrap");
	}
	public SoftverskaKompanija getSk() {
		return sk;
	}
	public String getName() {
		return name;
	}
	public String getSoftwareCompanyName(){
		return tfName.getText();
	}

}
