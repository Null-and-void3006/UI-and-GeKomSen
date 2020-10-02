package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import app.AppCore;
import controller.ActionManager;
import model.Parametar;
import net.miginfocom.swing.MigLayout;

public class PokPosInstal extends JPanel{
	
	private JCheckBox bla;
	private JButton next;
	private JButton cancel;

	
	private Parametar p;
	public PokPosInstal(Parametar p) {
		
		this.setLayout(new MigLayout());
		this.p=p;
		
		next= new JButton(AppCore.getInstance().getRb().getString("btNext"));
		cancel= new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		bla= new JCheckBox(AppCore.getInstance().getRb().getString("chkBoxPokPosInstal"));
		this.add(bla, "wrap");
		next.setAction(ActionManager.getInstance().getSaveParametarAction());
		cancel.setAction(ActionManager.getInstance().getCancelAction());
		this.add(next);
		this.add(cancel);
		
		this.setVisible(true);
	}
	
	public String getPok()
	{
		if(bla.isSelected()) return "Run after installation:"+"true";
		else return "Run after installation"+"false";
	}

	public void setParametar(String name) {
		this.p.setName(name);
	}

}
