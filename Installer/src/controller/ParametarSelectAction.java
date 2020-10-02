package controller;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import app.AppCore;
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

public class ParametarSelectAction extends AbstractAction {
	private Locale lokal;
	private ResourceBundle rb;

	public ParametarSelectAction() {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);

		putValue(NAME, rb.getString("add"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString());
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramSoftName"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new NamePanel(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
			
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramAutor"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new AutorPanel(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramDesc"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new DescriptionPanel(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramLogo"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new LogoPanel(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramVersion"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new VersionPanel(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramToU"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new ToUPanel(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramLNF"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new LookAndFeelParametar(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramLang"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new ParametarJezici(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramRunAftIns"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new PokPosInstal(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramShortcut"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new DesktopShortcut(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}
		if(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getCbpar().getSelectedItem().toString().equals(AppCore.getInstance().getRb().getString("paramCustom"))){
			((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).addParametarPanel(new CustomParametri(((FirstPanel)AppCore.getInstance().getMainFrame().getCurrentPanel()).getPar()));
		}

	}

}
