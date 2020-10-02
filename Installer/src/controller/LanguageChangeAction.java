package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import app.AppCore;

public class LanguageChangeAction extends AbstractAction {
	private String s;
	private ResourceBundle rb;
	public LanguageChangeAction(String s) {
		putValue(NAME, s);
		this.s=s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("*");
		if(s.compareTo("English US")==0){
			
		AppCore.getInstance().setLokal(new Locale("en","US"));
		}
		if(s.compareTo("Srpski Latinica")==0){
			System.out.println("+");
			
			AppCore.getInstance().setLokal(new Locale("sr","RS","lat"));
			}
		if(s.compareTo("Srpski \0106irilica")==0){
			
			AppCore.getInstance().setLokal(new Locale("sr","RS","cir"));
			}
		rb=ResourceBundle.getBundle("resources/MessageResources",AppCore.getInstance().getLokal());
		AppCore.getInstance().setRb(rb);
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame());
	}

}
