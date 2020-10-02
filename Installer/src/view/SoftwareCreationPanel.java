package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import app.AppCore;
import controller.ActionManager;
import model.Softver;
import net.miginfocom.swing.MigLayout;

public class SoftwareCreationPanel extends JPanel {
	private JTextField tfSoftwareName;
	private JLabel lbSoftwareName;
	private JButton save;
	private JButton delete;

	
	private String value;
	private Softver s;

	public SoftwareCreationPanel(Softver s) {
		super(new MigLayout());

		value="";
		this.s=s;
		tfSoftwareName= new JTextField(30);
		tfSoftwareName.setText(value);
		lbSoftwareName= new JLabel(AppCore.getInstance().getRb().getString("lbSoftwareName"));
		save= new JButton(AppCore.getInstance().getRb().getString("save"));
		save.setAction(ActionManager.getInstance().getSaveSoftwareAction());
		delete= new JButton(AppCore.getInstance().getRb().getString("delete"));
		delete.setAction(ActionManager.getInstance().getCancelSoftwareAction());
		this.add(lbSoftwareName, "wrap");
		this.add(tfSoftwareName,"wrap");
		this.add(save, "wrap");
		this.add(delete, "wrap");
	}

	public Softver getSoftware() {
		return s;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String saveSoftwareName(){
		return tfSoftwareName.getText();
	}
	public void cancel(){
		AppCore.getInstance().getRoot().getSoftveri().remove(this.s);
		AppCore.getInstance().getMainFrame().disposeOfPanel(this);
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		System.out.println("*");
	}

}
