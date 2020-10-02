package view;

import java.util.ResourceBundle;
import java.util.Locale;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.plaf.ActionMapUIResource;

import app.AppCore;
import controller.ActionManager;
import controller.LanguageChangeAction;
import controller.ThemeChangeAction;

public class MainMenuBar extends JMenuBar{
	
	private JMenu help;
	private JMenu file;
	private JMenu edit;
	private JMenu lafs;
	private JMenu lang;
	
	public MainMenuBar() {
		lafs=new JMenu(AppCore.getInstance().getRb().getString("lafs"));
		lang=new JMenu("Languages");
		lang.add(new LanguageChangeAction("English US"));
		lang.add(new LanguageChangeAction("Srpski Latinica"));
		lang.add(new LanguageChangeAction("Srpski \0106irilica"));
		lafs.add(new ThemeChangeAction("Metal"));
		lafs.add(new ThemeChangeAction("Nimbus"));
		lafs.add(new ThemeChangeAction("Motif"));
		lafs.add(new ThemeChangeAction("Windows"));
		lafs.add(new ThemeChangeAction("WindowsClassic"));

		help = new JMenu(AppCore.getInstance().getRb().getString("menuHelp"));
		file = new JMenu(AppCore.getInstance().getRb().getString("menuFile"));
		edit = new JMenu(AppCore.getInstance().getRb().getString("menuEdit"));
		
		help.add(ActionManager.getInstance().getAboutAction());
		help.add(ActionManager.getInstance().getHelpAction());
		edit.add(lang);
		edit.add(lafs);
		
		this.add(file);
		this.add(edit);
		this.add(help);
	}
	public void updateComp(){
		
	}

}
