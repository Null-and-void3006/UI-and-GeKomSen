package view;


import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.AppCore;
import controller.ActionManager;

public class ExitDialog extends JDialog {
	private JLabel text;
	private JButton yes;
	private JButton no;
	private JPanel panel;
	
	private Locale lokal;
	private ResourceBundle rb;
	
	public ExitDialog(){

		lokal= new Locale("en", "US");
		rb = ResourceBundle.getBundle("gui.MessageResources.MessageResources.MessageResources", lokal);
		
		this.setTitle(rb.getString("titleExit"));
		this.setLocationRelativeTo(AppCore.getInstance().getMainFrame());
		this.setSize(400, 400);
		text=new JLabel(rb.getString("lbSure"));
		yes=new JButton(rb.getString("btYes"));
		yes.setAction(ActionManager.getInstance().getExitAction());
		no=new JButton(rb.getString("btNo"));
		panel=new JPanel();
		panel.add(text);
		panel.add(yes);
		panel.add(no);
		this.add(panel);
	}
}
