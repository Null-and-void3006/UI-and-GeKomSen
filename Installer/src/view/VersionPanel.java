package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.AppCore;
import controller.ActionManager;
import model.Parametar;

public class VersionPanel extends JPanel{
	private JLabel lbVersion;
	private JTextField tfVersion;
	private String version;
	
	private JButton btNext;
	private JButton btCancel;
	
	private Parametar p;
	public VersionPanel(Parametar p)
	{
		this.p=p;
		lbVersion = new JLabel(AppCore.getInstance().getRb().getString("lbVersion"));
		tfVersion = new JTextField(20);
		version = "";
		btNext = new JButton(AppCore.getInstance().getRb().getString("btNext"));
		btCancel = new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		btNext.setAction(ActionManager.getInstance().getSaveParametarAction());
		btCancel.setAction(ActionManager.getInstance().getCancelAction());
		
		this.add(lbVersion);
		this.add(tfVersion);
		this.add(btNext);
		this.add(btCancel);
		
		this.setVisible(true);
	}

	public String getVersion() {
		return "Version:"+tfVersion.getText();
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setParametar(String version2) {
		this.p.setName(version2);
	}

}
