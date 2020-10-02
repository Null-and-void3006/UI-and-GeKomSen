package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import app.AppCore;
import controller.ActionManager;
import model.Moduo;
import model.Parametar;
import model.SoftverskaKompanija;
import net.miginfocom.swing.MigLayout;

public class MainFrame extends JFrame {
	
	private JSplitPane splitPane;
	private JTreePanel panelLeft;
	private JPanel panelRight;
	private FirstPanel fp;
	private StartPanel sp;
	private LastPanel lp;
	private SoftwareCompanyEditingPanel sep;
	
	
	
	private JPanel panel;
	private MainMenuBar mb;
	
	private ImageIcon icon;
	
	private int currPanel = 0;
	
	private ArrayList<JPanel> paneli = new ArrayList<>();
	
	public MainFrame(SoftverskaKompanija sk) {
		
		super("Installer 203.6");
		this.setSize(800, 600);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		fp= new FirstPanel(new Parametar(""));
		sp=new StartPanel();
		lp=new LastPanel();
		sep=new SoftwareCompanyEditingPanel(sk);
		
		paneli.add(sp);
		paneli.add(sep);
		paneli.add(lp);
		
		panelLeft = new JTreePanel(sk);
		panelRight = new RightPanel(paneli.get(currPanel)).disableBack();
		mb = new MainMenuBar();
		
		
//		ResourceBundle rBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources.MessageResources", lokal);
//		rBundle.getString();
		
		this.setJMenuBar(mb);
		//new SecondSpecFrame();
		
		
		icon = new ImageIcon("Resources/icon.jpg");
		this.setIconImage(icon.getImage());
		
		panel = new JPanel(new BorderLayout());
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft, panelRight);
		splitPane.setDividerLocation(250);
		//splitPane.setEnabled(false);
		panel.add(splitPane, BorderLayout.CENTER);
		
		this.setContentPane(panel);
		
	}
	


	public JTreePanel getPanelLeft() {
		return panelLeft;
	}

	public FirstPanel getFp() {
		return fp;
	}

	public void next(){
		int a = splitPane.getDividerLocation();
		currPanel++;
		if(currPanel==paneli.size()-1)
			splitPane.setRightComponent(new RightPanel(paneli.get(currPanel)).disableNext());
		else splitPane.setRightComponent(new RightPanel(paneli.get(currPanel)));
		
		splitPane.setDividerLocation(a);
		
	}
	
	public void previous(){
		int a = splitPane.getDividerLocation();
		currPanel--;
		if(currPanel==0)
			splitPane.setRightComponent(new RightPanel(paneli.get(currPanel)).disableBack());
		else splitPane.setRightComponent(new RightPanel(paneli.get(currPanel)));
		
		splitPane.setDividerLocation(a);
		
	}
	public JPanel getCurrentPanel(){
		return paneli.get(currPanel);
	}
	public void addPanel(JPanel jp){
		paneli.add(lp);
		paneli.set(paneli.size()-2, jp);
		while(currPanel!=paneli.size()-2){
			this.next();
		}
	}
	public void disposeOfPanel(JPanel jp){
		if(paneli.get(currPanel)==jp){
		paneli.remove(jp);
		currPanel--;
		splitPane.setRightComponent(new RightPanel(paneli.get(currPanel)));
		}
		paneli.remove(jp);
	}
	public void updateAll(){
		
	}
	public void removePanel(){
		this.previous();
		paneli.remove(currPanel+1);
	}

}
