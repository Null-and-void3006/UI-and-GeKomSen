package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import app.AppCore;
import model.Moduo;
import model.Parametar;
import view.AutorPanel;
import view.CustomParametri;
import view.DescriptionPanel;
import view.DesktopShortcut;
import view.FirstPanel;
import view.LogoPanel;
import view.LookAndFeelParametar;
import view.NamePanel;
import view.ParametarJezici;
import view.PokPosInstal;
import view.ToUPanel;
import view.VersionPanel;

public class SaveParametarAction extends AbstractAction {
	private Locale lokal;
	private ResourceBundle rb;
	public SaveParametarAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, rb.getString("save"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof AutorPanel){
			AutorPanel x = ((AutorPanel)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getAutor());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
			
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof CustomParametri){
			CustomParametri x = ((CustomParametri)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getValue());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof DescriptionPanel){
			DescriptionPanel x = ((DescriptionPanel)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getDesc());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof DesktopShortcut){
			DesktopShortcut x = ((DesktopShortcut)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getDesktop());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof LogoPanel){
			LogoPanel x = ((LogoPanel)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			//AppCore.getInstance().getDummy().getSoftveri().get(0).getModuli().get(0).getParametri().add(new Parametar(x.));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof LookAndFeelParametar){
			LookAndFeelParametar x = ((LookAndFeelParametar)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getIme());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
			
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof NamePanel){
			NamePanel x = ((NamePanel)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getName());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof ParametarJezici){
			ParametarJezici x = ((ParametarJezici)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getJezik());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof PokPosInstal){
			PokPosInstal x = ((PokPosInstal)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getPok());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof ToUPanel){
			ToUPanel x = ((ToUPanel)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getTou());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel() instanceof VersionPanel){
			VersionPanel x = ((VersionPanel)((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCpanel());
			x.setParametar(x.getVersion());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getPanelLeft().getJt());
		}

	}

}
