package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import app.AppCore;
import model.Moduo;
import model.Parametar;
import model.Softver;
import model.SoftverskaKompanija;
import view.FirstPanel;
import view.ModuoCreationPanel;
import view.SoftwareCreationPanel;

public class AddNodeAction extends AbstractAction {
	private static long i=0;

	private Locale lokal;
	private ResourceBundle rb;

	public AddNodeAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, "Add Node");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		Object target = AppCore.getInstance().getMainFrame().getPanelLeft().getJt().getSelectionPath().getLastPathComponent();
		if(target instanceof Softver){
			Moduo m= new Moduo(rb.getString("untitled")+i++);
			AppCore.getInstance().getMainFrame().addPanel(new ModuoCreationPanel(m));
			
			((Softver)target).addModul(m);
			
		}
		if(target instanceof Moduo){
			Parametar p= new Parametar(rb.getString("untitled")+i++);
			AppCore.getInstance().getMainFrame().addPanel(new FirstPanel(p));
			((Moduo)target).addParametar(p);
			
		}
		if(target instanceof SoftverskaKompanija){
			Softver s= new Softver(rb.getString("untitled")+i++);
			AppCore.getInstance().getMainFrame().addPanel(new SoftwareCreationPanel(s));
			((SoftverskaKompanija)target).addSoftware(s);
		}
		if(target instanceof Parametar){
			JOptionPane.showConfirmDialog(null, rb.getString("diffComp"));
			
		}
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame());
		
	}

}
