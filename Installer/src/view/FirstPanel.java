package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import app.AppCore;
import controller.ActionManager;
import model.Parametar;
import net.miginfocom.swing.MigLayout;

public class FirstPanel extends JPanel{
	private JComboBox<Parametar> cbpar;
	private JLabel lbpar;
	private JButton btSelect;
	private JPanel cpanel = null;
	
	private LogoPanel logoPan;

	
	private Parametar par;
	public FirstPanel(Parametar p) {
		
		this.setLayout(new MigLayout());
		par=p;
		lbpar= new JLabel(AppCore.getInstance().getRb().getString("lbParam"));
		cbpar= new JComboBox<>();
		btSelect= new JButton(AppCore.getInstance().getRb().getString("btSelect"));
		
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramSoftName")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramAutor")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramDesc")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramLogo")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramVersion")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramToU")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramLNF")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramLang")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramShortcut")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramRunAftIns")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramCustom")));
		
		btSelect.setAction(ActionManager.getInstance().getParametarSelectAction());
		
		this.add(lbpar, "wrap");
		this.add(cbpar,"wrap");
		this.add(btSelect,"wrap");
		
		
		

		
	}
	public Parametar getPar() {
		return par;
	}
	public void setPar(Parametar par) {
		this.par = par;
	}
	public CustomParametri getCustomPan(){
		//TODO: Use manual casting to turn the current panel from a JPanel to a CustomParametri class
		//example: (CustomParametri)appcore.getinstance.getmainframe.getcurrentpanel
		return null;
	}
	
	public void addParametarPanel(JPanel panel){
		if(cpanel!=null){
			this.remove(cpanel);
		}
		cpanel=panel;
		this.add(panel,"wrap");
		System.out.println("000");
		SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame());
	}

	public void cancelSelection(){
		
		AppCore.getInstance().getMainFrame().removePanel();
	}


	public LogoPanel getLogoPan() {
		return logoPan;
	}

	public void setLogoPan(LogoPanel logoPan) {
		this.logoPan = logoPan;
	}

	public JPanel getCpanel() {
		return cpanel;
	}

	public JComboBox<Parametar> getCbpar() {
		return cbpar;
	}
	public void updateComp(){
		cbpar.removeAllItems();
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramSoftName")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramAutor")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramDesc")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramLogo")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramVersion")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramToU")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramLNF")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramLang")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramShortcut")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramRunAftIns")));
		cbpar.addItem(new Parametar(AppCore.getInstance().getRb().getString("paramCustom")));
	}

}
