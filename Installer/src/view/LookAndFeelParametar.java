package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.AppCore;
import controller.ActionManager;
import model.Parametar;

public class LookAndFeelParametar extends JPanel{
	private String ime;
	private JLabel lbl1;
	private JButton next;
	private JButton cancel;
	private JComboBox<String> LnF;

	
	private Parametar p;
	public LookAndFeelParametar(Parametar p){

		this.p=p;
		lbl1 = new JLabel(AppCore.getInstance().getRb().getString("lbLNF"));
		next = new JButton(AppCore.getInstance().getRb().getString("btNext"));
		cancel = new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		next.setAction(ActionManager.getInstance().getSaveParametarAction());
		cancel.setAction(ActionManager.getInstance().getCancelAction());
		LnF=new JComboBox<>();
		LnF.addItem("Metal");
		LnF.addItem("Nimbus");
		LnF.addItem("Motif");
		LnF.addItem("Windows");
		LnF.addItem("Windows Classic");
		this.add(lbl1);
		this.add(LnF,"wrap");
		this.add(next);
		this.add(cancel);
		this.setVisible(true);
	}
	
	public String getIme(){
		return "Look&Feel:"+LnF.getSelectedItem();
	}
	
	public void setIme(String s){
		ime = s;
	}

	public void setParametar(String name) {
		// TODO Auto-generated method stub
		
	} 
	public void updateComp(){
		lbl1.setText(AppCore.getInstance().getRb().getString("lbLNF"));
		cancel.setText(AppCore.getInstance().getRb().getString("btCancel"));
		next.setText(AppCore.getInstance().getRb().getString("btNext"));
	}
	
	
	
}
