package view;

import java.awt.Panel;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app.AppCore;
import controller.ActionManager;
import controller.FileController;
import model.Moduo;
import model.Parametar;
import model.Softver;
import net.miginfocom.swing.MigLayout;

public class PreviewFrame extends JFrame {
	private JPanel panel;
	


	public PreviewFrame(Softver current) {
		super();
		this.setSize(500, 500);


		panel=new JPanel(new MigLayout());
		this.add(panel);
		this.setTitle(current.toString());
		for(Moduo m:current.getModuli()){
			panel.add(new JLabel(m.toString()),"wrap");
			for(Parametar p:m.getParametri()){
				if(p.toString().contains("Author:")){
					panel.add(new JLabel(p.toString()),"wrap");
				}
				if(p.toString().contains("Custom:")){
					p.setName(p.toString().substring(7));
					JLabel lbCustom=new JLabel(p.toString().substring(0,p.toString().indexOf("|")));
					panel.add(lbCustom,"wrap");
					p.setName(p.toString().substring(p.toString().indexOf("|")+1));
					if(p.toString().contains("TextField")){
						p.setName(p.toString().substring(p.toString().indexOf("|")+1));
						JTextField tf=new JTextField(p.toString().length()+1);
						tf.setText(p.toString());
						panel.add(tf);
					}
					if(p.toString().contains("TextLabel")){
						p.setName(p.toString().substring(p.toString().indexOf("|")+1));
						JLabel lb=new JLabel(p.toString());
						panel.add(lb,"wrap");
					}
					if(p.toString().contains("TextArea")){
						p.setName(p.toString().substring(p.toString().indexOf("|")+1));
						JTextArea ta=new JTextArea(20,20);
						ta.setText(p.toString());
						ta.setEditable(false);
						panel.add(ta,"wrap");
					}
					if(p.toString().contains("CheckBox")){
						JCheckBox cb=new JCheckBox(p.toString().substring(0,p.toString().indexOf("|")));
						p.setName(p.toString().substring(p.toString().indexOf("|")+1));
						if(p.toString().compareTo("true")==0){
							cb.setSelected(true);
						}
						else{
							cb.setSelected(false);
						}
						panel.add(cb,"wrap");
						
					}
				}
				if(p.toString().contains("Logo:")){
					JLabel lbImage=new JLabel("");
					lbImage.setIcon(new ImageIcon(p.toString().substring(5)));
					panel.add(lbImage,"wrap");
				}
				if(p.toString().contains("Description:")){
					JTextArea desc=new JTextArea(20,20);
					desc.setText(p.toString().substring(12));
					desc.setEditable(false);
					panel.add(desc, "wrap");
				}
				if(p.toString().contains("DesktopShortcut:")){
					panel.add(new JCheckBox(AppCore.getInstance().getRb().getString("PFcreateshortcut")),"wrap");
				}
				if(p.toString().contains(AppCore.getInstance().getRb().getString("PFlnf"))){
					JComboBox<String> box=new JComboBox<>();
					
					panel.add(box,"wrap");
				}
				if(p.toString().contains("Languages:")){
					panel.add(new JLabel(AppCore.getInstance().getRb().getString("PFselectlang")),"wrap");
					JComboBox<String> lang=new JComboBox<>(); 
				}
				if(p.toString().contains("Run after installation:")){
					panel.add(new JCheckBox(AppCore.getInstance().getRb().getString("PFdoyouwish")),"wrap");
				}
				if(p.toString().contains("Terms of use:")){
					JTextArea tou=new JTextArea(20,20);
					tou.setText(p.toString().substring(13));
					tou.setEditable(false);
					panel.add(tou,"wrap");
				}
				if(p.toString().contains("Version:")){
					JTextField ver=new JTextField(p.toString().length()-8);
					ver.setText(p.toString().substring(9));
					ver.setEditable(false);
					panel.add(ver,"wrap");
				}
			}
		}
		this.setVisible(true);
	}

}
