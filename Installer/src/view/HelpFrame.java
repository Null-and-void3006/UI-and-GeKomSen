package view;

import java.awt.Dimension;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import app.AppCore;
import net.miginfocom.swing.MigLayout;

public class HelpFrame extends JDialog {
	
	private JPanel panel;
	private JLabel lbHelp;
	private JTextArea tfHelp;
	
	public HelpFrame() {

		this.setPreferredSize(new Dimension(670, 350));
		this.setResizable(false);
		this.setTitle("Help - Univerzalni Instalator");
		
		panel = new JPanel(new MigLayout());
		tfHelp = new JTextArea(20,20);
		tfHelp.setText(AppCore.getInstance().getRb().getString("helphelp"));
		tfHelp.setEditable(false);
		
		panel.add(tfHelp);

		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(AppCore.getInstance().getMainFrame());
		this.setModal(true);
		this.setVisible(true);
	}

}