package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app.AppCore;
import controller.ActionManager;
import model.Parametar;

public class DescriptionPanel extends JPanel{
	private JLabel lbDesc;
	private JTextArea tfDesc;
	private String desc;
	

	
	private JButton btNext;
	private JButton btCancel;
	
	private Parametar p;
	public DescriptionPanel(Parametar p)
	{
		
		this.p=p;
		
		lbDesc = new JLabel(AppCore.getInstance().getRb().getString("lbDesc"));
		tfDesc = new JTextArea(20,20);
		desc = "";
		btNext = new JButton(AppCore.getInstance().getRb().getString("btNext"));
		btCancel = new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		btNext.setAction(ActionManager.getInstance().getSaveParametarAction());
		btCancel.setAction(ActionManager.getInstance().getCancelAction());
		
		this.add(lbDesc);
		this.add(tfDesc);
		this.add(btNext);
		this.add(btCancel);
		
		this.setVisible(true);
	}

	public String getDesc() {
		return "Description:"+tfDesc.getText();
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setParametar(String desc2) {
		p.setName(desc2);
		
	}
	public void updateComp(){
		lbDesc.setText(AppCore.getInstance().getRb().getString("lbDesc"));
		btCancel.setText(AppCore.getInstance().getRb().getString("btCancel"));
		btNext.setText(AppCore.getInstance().getRb().getString("btNext"));
	}

}
