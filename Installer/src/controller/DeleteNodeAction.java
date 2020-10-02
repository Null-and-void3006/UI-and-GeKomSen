package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import app.AppCore;
import model.Moduo;
import model.Parametar;
import model.Softver;

public class DeleteNodeAction extends AbstractAction {

	private Locale lokal;
	private ResourceBundle rb;

	public DeleteNodeAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);

		putValue(NAME, rb.getString("deleteNode"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object target = AppCore.getInstance().getMainFrame().getPanelLeft().getJt().getSelectionPath().getLastPathComponent();
		if(target instanceof Softver){
			Softver s= (Softver) target;
			System.out.println(s.toString());
			AppCore.getInstance().getRoot().remove(s);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		}
		if(target instanceof Parametar){
			Parametar p= (Parametar)target;
			((Moduo)p.getParent()).remove(p);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());

		}
		if(target instanceof Moduo){
			Moduo m= (Moduo)target;
			((Softver)m.getParent()).remove(m);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());

		}
		
	}

}
