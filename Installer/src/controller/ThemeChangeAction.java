package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import app.AppCore;

public class ThemeChangeAction extends AbstractAction {
	private Locale lokal;
	private ResourceBundle rb;
	private String s;
	public ThemeChangeAction(String s) {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, s);
		putValue(SHORT_DESCRIPTION, rb.getString("change")+s);
		this.s=s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LookAndFeelInfo a[]=UIManager.getInstalledLookAndFeels();
		for(int i=0;i<a.length;i++){
			if(a[i].getClassName().contains(s)){
				
				try {
					UIManager.setLookAndFeel(a[i].getClassName());
					SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame());
					return;
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
