package view;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.Image;
import model.InstallerSpec;
import model.Language;

public class SecondSpecFrame extends JPanel{
	private JLabel lbLan;
	private JLabel lbDefLoc;
	private JLabel lbOS;
	private JLabel lbFun;
	
	private JTextField tfDefLoc;
	
	private ArrayList<Language> listLan1 = new ArrayList<>();
	private ArrayList<Language> listLan2 = new ArrayList<>();
	
	private JList<Language> lvLan1;
	private JList<Language> lvLan2;
	
	private JCheckBox chbWin;
	private JCheckBox chbMac;
	private JCheckBox chbLin;
	private JCheckBox chbFun1;
	private JCheckBox chbFun2;
	
	private JButton btBack;
	private JButton btFin;
	private JButton btCancel;
	private JButton btPic;
	private JButton btAddLan;
	private JButton btAddAllLan;
	
	private ImageIcon icon;
	
	private SpringLayout sp;
	
	public SecondSpecFrame()
	{
		super();
		
		lbLan = new JLabel("Choose language");
		lbDefLoc = new JLabel("Default location");
		lbOS = new JLabel("Choose operating system");
		lbFun = new JLabel("Choose function");
		
		tfDefLoc = new JTextField();
		
		chbWin = new JCheckBox();
		chbMac = new JCheckBox();
		chbLin = new JCheckBox();
		chbFun1 = new JCheckBox();
		chbFun2 = new JCheckBox();
		
		btPic = new JButton("Choose Picture");
		btBack = new JButton("Back");
		btFin = new JButton("Finish");
		btCancel = new JButton("Cancel");
		btAddLan = new JButton("->");
		btAddAllLan = new JButton("->>");
		
		sp = new SpringLayout();
		
		this.setLayout(sp);
		
		chbWin.setText("Windows");
		chbMac.setText("Mac");
		chbLin.setText("Linux");
		
		icon = new ImageIcon("Resources/icon.jpg");
		//this.setIconImage(icon.getImage());
		
		this.add(lbLan);
		
		sp.putConstraint(sp.WEST, lbLan, 10, sp.WEST, this);
		sp.putConstraint(sp.NORTH, lbLan, 10, sp.NORTH, this);
		
		
		//this.pack();
		this.setVisible(true);
	}
}
