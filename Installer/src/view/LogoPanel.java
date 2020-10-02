package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.AppCore;
import controller.ActionManager;
import controller.FileBrowseAction;
import model.FileSource;
import model.Parametar;
import net.miginfocom.swing.MigLayout;

public class LogoPanel extends JPanel implements FileSource{
	private JLabel lbBrowse;
	private JLabel lbLogo;
	private JLabel lbImage;
	
	private JTextField tfBrowse;
	
	private JButton btBrowse;
	private JButton next;
	private JButton cancel;
	
	private ImageIcon icon;

	
	private Parametar p;
	public LogoPanel(Parametar p)
	{

		this.setLayout(new MigLayout());
		this.p=p;
		lbBrowse = new JLabel(AppCore.getInstance().getRb().getString("lbBrowse"));
		tfBrowse = new JTextField(30);
		lbImage=new JLabel("");
		
		btBrowse = new JButton(AppCore.getInstance().getRb().getString("btBrowse"));
		btBrowse.setAction(new FileBrowseAction(this, "", "find your file"));
		next= new JButton(AppCore.getInstance().getRb().getString("btNext"));
		cancel= new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		
		cancel.setAction(ActionManager.getInstance().getCancelAction());
		next.setAction(ActionManager.getInstance().getSaveParametarAction());
		
		icon = new ImageIcon();
		
		lbLogo = new JLabel(icon);
		
		
		this.add(lbBrowse, "wrap");
		this.add(tfBrowse, "wrap");
		this.add(btBrowse, "wrap");
		this.add(next, "wrap");
		this.add(cancel, "wrap");
		this.add(lbImage,"wrap");
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public JTextField getTfBrowse() {
		return tfBrowse;
	}
	public void updateComp(){
		lbBrowse.setText(AppCore.getInstance().getRb().getString("lbBrowse"));
		cancel.setText(AppCore.getInstance().getRb().getString("btCancel"));
		next.setText(AppCore.getInstance().getRb().getString("btNext"));
	}

	@Override
	public void setPath(String s) {
		tfBrowse.setText(s);
		lbImage.setIcon(new ImageIcon(s));
		p.setName("Logo:"+s);
	}
}
