package view;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import app.AppCore;
import controller.ActionManager;
import model.Parametar;
import net.miginfocom.swing.MigLayout;

public class DesktopShortcut extends JPanel{
	
	private JCheckBox chb;
	private JButton next;
	private JButton cancel;
	

	
	private Parametar p;
	public DesktopShortcut(Parametar p) {
		
		this.setLayout(new MigLayout());
		this.p=p;
		
		chb= new JCheckBox(AppCore.getInstance().getRb().getString("lbShortcut"));
		next= new JButton(AppCore.getInstance().getRb().getString("btNext"));
		cancel=new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		next.setAction(ActionManager.getInstance().getSaveParametarAction());
		cancel.setAction(ActionManager.getInstance().getCancelAction());
		this.add(next);
		this.add(cancel);
		this.add(chb, "wrap");
		
		
		this.setVisible(true);
	}
	public String getDesktop()
	{
		if(chb.isSelected())
		{
			return "DesktopShortcut:true";
		}
		else
		{
			return "DesktopShortcut:false";
		}
	}
	public void setParametar(String desktop) {
		p.setName(desktop);
	}
	public void updateComp(){
		chb.setText(AppCore.getInstance().getRb().getString("lbShortcut"));
		cancel.setText(AppCore.getInstance().getRb().getString("btCancel"));
		next.setText(AppCore.getInstance().getRb().getString("btNext"));
	}

}
