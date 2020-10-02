package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.AppCore;
import net.miginfocom.swing.MigLayout;

public class AboutFrame extends JDialog{
	
	private JPanel panel;
	
	private JLabel lbNDj1;
	private JLabel lbNDj2;
	private JLabel lbSS;
	private JLabel lbPDj;
	
	private JLabel lbNDj1I;
	private JLabel lbNDj2I;
	private JLabel lbSSI;
	private JLabel lbPDjI;
	
	private ImageIcon icon;
	
	public AboutFrame()
	{
		this.setSize(450, 700);
		this.setResizable(false);
		this.setTitle("About us");
		
		
		panel = new JPanel(new MigLayout());
		
		lbNDj1 = new JLabel("Nikola Djurovic (team leader), RN04/16");
		lbNDj2 = new JLabel("Nikola Djurovic, RN43/16");
		lbSS = new JLabel("Sofija Stanojevic, RN02/16");
		lbPDj = new JLabel("Petar Djordjevic, RN78/17");
		
		//lbPDjI = new JLabel("Resources/lmao.jpg");
		
		icon = new ImageIcon("Resources/PDj.jpg");
		lbPDjI = new JLabel(icon);
		
		icon = new ImageIcon("Resources/NDj1.jpg");
		lbNDj1I = new JLabel(icon);
		
		icon = new ImageIcon("Resources/NDj2.jpg");
		lbNDj2I = new JLabel(icon);
		
		icon = new ImageIcon("Resources/SS.jpg");
		lbSSI = new JLabel(icon);
		
		panel.add(lbNDj1I);
		panel.add(lbNDj1, "wrap");
		
		panel.add(lbNDj2I);
		panel.add(lbNDj2, "wrap");
		
		panel.add(lbSSI);
		panel.add(lbSS, "wrap");
		
		panel.add(lbPDjI);
		panel.add(lbPDj);
		
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(AppCore.getInstance().getMainFrame());
		this.setModal(true);
		this.setVisible(true);
	}
	
}
