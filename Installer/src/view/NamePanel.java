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
import net.miginfocom.swing.MigLayout;

public class NamePanel extends JPanel{

	private JLabel lbName;
	private JTextField tfName;
	private String name;
	
	private JButton btNext;
	private JButton btCancel;
	


	private Parametar p;
	public NamePanel(Parametar p)
	{
		super(new MigLayout());
		this.p=p;

		lbName = new JLabel(AppCore.getInstance().getRb().getString("lbName"));
		tfName = new JTextField(30);
		name = "";
		btNext = new JButton(AppCore.getInstance().getRb().getString("btNext"));
		btCancel = new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		btNext.setAction(ActionManager.getInstance().getSaveParametarAction());
		btCancel.setAction(ActionManager.getInstance().getCancelAction());
		this.add(lbName);
		this.add(tfName, "wrap");
		this.add(btNext);
		this.add(btCancel, "wrap");
		
	}

	public String getName() {
		return "Software Name:"+tfName.getText();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParametar(String name2) {
		p.setName(name2);
		
	}
}
