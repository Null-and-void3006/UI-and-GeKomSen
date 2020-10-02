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

public class ToUPanel extends JPanel{
	private JLabel lbToU;
	private JTextArea tfToU;
	private String tou;
	
	private JButton btNext;
	private JButton btCancel;
	

	private Parametar p;
	public ToUPanel(Parametar p)
	{
		this.p=p;
		lbToU = new JLabel(AppCore.getInstance().getRb().getString("lbToU"));
		tfToU = new JTextArea(30,20);
		tou = "";
		btNext = new JButton(AppCore.getInstance().getRb().getString("btNext"));
		btCancel = new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		btNext.setAction(ActionManager.getInstance().getSaveParametarAction());
		btCancel.setAction(ActionManager.getInstance().getCancelAction());
		
		
		this.add(lbToU);
		this.add(tfToU);
		this.add(btNext);
		this.add(btCancel);
		
		this.setVisible(true);
	}

	public String getTou() {
		return "Terms of use:"+tfToU.getText();
	}

	public void setTou(String tou) {
		this.tou = tou;
	}

	public void setParametar(String tou2) {
		this.p.setName(tou2);
	}

}
