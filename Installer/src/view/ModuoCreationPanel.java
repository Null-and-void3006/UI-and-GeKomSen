package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.AppCore;
import controller.ActionManager;
import model.Moduo;
import net.miginfocom.swing.MigLayout;

public class ModuoCreationPanel extends JPanel {
	public Moduo getModuo() {
		return m;
	}
	private JTextField tfModuoName;
	private JLabel lbModuoName;
	private JButton save;
	private JButton delete;
	private Moduo m;


	public ModuoCreationPanel(Moduo m) {
		super(new MigLayout());
		this.m=m;
		tfModuoName= new JTextField(30);
		lbModuoName= new JLabel(AppCore.getInstance().getRb().getString("lbModuoName"));
		save= new JButton(AppCore.getInstance().getRb().getString("save"));
		delete= new JButton(AppCore.getInstance().getRb().getString("delete"));
		save.setAction(ActionManager.getInstance().getSaveModuoAction());
		delete.setAction(ActionManager.getInstance().getCancelModuoAction());
		this.add(lbModuoName, "wrap");
		this.add(tfModuoName,"wrap");
		this.add(save, "wrap");
		this.add(delete, "wrap");
		
	}
	public void cancel(){
		int i;
		i=AppCore.getInstance().getRoot().getSoftveri().indexOf(this.m);
		AppCore.getInstance().getRoot().getSoftveri().get(AppCore.getInstance().getRoot().getSoftveri().indexOf(m.getParent())).remove(m);
		AppCore.getInstance().getMainFrame().disposeOfPanel(this);
	}
	public String saveModuoName(){
		return tfModuoName.getText();
	}
}
