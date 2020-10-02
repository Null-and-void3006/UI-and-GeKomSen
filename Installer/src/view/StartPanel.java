package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import app.AppCore;

public class StartPanel extends JPanel {



	private JLabel lbWelcome;
	public StartPanel() {


		lbWelcome= new JLabel(AppCore.getInstance().getRb().getString("lbWelcome"));
		this.add(lbWelcome);
		
	}

}
