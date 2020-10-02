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

public class CustomParametri extends JPanel {
	private JLabel lbName;
	private JLabel lbType;
	private JLabel lbDefault;
	
	private JTextField tfName;
	private JTextField tfType;
	private JTextField tfDefault;
	
	private JButton btHelp;
	private JButton btOk;
	
	private Parametar p;
	
	

	public CustomParametri(Parametar p)
	{
		

		this.setLayout(new MigLayout());
		this.p=p;
		lbName = new JLabel(AppCore.getInstance().getRb().getString("customLbName"));
		lbType = new JLabel(AppCore.getInstance().getRb().getString("customLbType"));
		lbDefault = new JLabel(AppCore.getInstance().getRb().getString("customLbDefault"));
		
		tfName = new JTextField(30);
		tfType = new JTextField(30);
		tfDefault = new JTextField(30);
		
		btHelp = new JButton(AppCore.getInstance().getRb().getString("help"));
		btOk = new JButton(AppCore.getInstance().getRb().getString("ok"));
		btOk.setAction(ActionManager.getInstance().getSaveParametarAction());
		
		this.add(lbName, "wrap");
		this.add(tfName, "wrap");
		this.add(lbType, "wrap");
		this.add(tfType, "wrap");
		this.add(btHelp, "wrap");
		this.add(lbDefault, "wrap");
		this.add(tfDefault, "wrap");
		this.add(btOk, "wrap");
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfType() {
		return tfType;
	}

	public JTextField getTfDefault() {
		return tfDefault;
	}
	public String getValue(){
		return "Custom:"+tfName.getText()+"|"+tfType.getText()+"|"+tfDefault.getText();
	}
	public void updateComp(){
		lbName.setText(AppCore.getInstance().getRb().getString("customLbName"));
		lbType.setText(AppCore.getInstance().getRb().getString("customLbType"));
		lbDefault.setText(AppCore.getInstance().getRb().getString("customLbDefault"));
		btHelp.setText(AppCore.getInstance().getRb().getString("help"));
		btOk.setText(AppCore.getInstance().getRb().getString("ok"));
	}
	public void setParametar(String s){
		this.p.setName(s);
	}
}
