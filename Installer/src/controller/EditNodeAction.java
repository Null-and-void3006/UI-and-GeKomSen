package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import app.AppCore;
import model.Moduo;
import model.Parametar;
import model.Softver;
import view.SoftwareCreationPanel;

public class EditNodeAction extends AbstractAction{
	private Locale lokal;
	private ResourceBundle rb;
	
	int i;
	 public EditNodeAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);

		putValue(NAME, rb.getString("editNode"));
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object target = AppCore.getInstance().getMainFrame().getPanelLeft().getJt().getSelectionPath().getLastPathComponent();
		if(target instanceof Softver)
		{
			Softver s = (Softver)target;
			SoftwareCreationPanel sp=new SoftwareCreationPanel(s);
			sp.setValue(s.toString());
			AppCore.getInstance().getMainFrame().addPanel(sp);
		}
		if(target instanceof Moduo)
		{
			
		}
		if(target instanceof Parametar)
		{
			
		}
	}

}
