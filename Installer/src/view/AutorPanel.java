package view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.AppCore;
import controller.ActionManager;
import model.Parametar;
import net.miginfocom.swing.MigLayout;

public class AutorPanel extends JPanel{
	private JLabel lbAutor;
	private JTextField tfAutor;
	private String autor;
	
	
	
	private JButton btNext;
	private JButton btCancel;
	
	private Parametar p;
	public AutorPanel(Parametar p)
	{
		this.setLayout(new MigLayout());
		this.p=p;
		

		lbAutor = new JLabel(AppCore.getInstance().getRb().getString("lbAuthor"));
		tfAutor = new JTextField(50);
		autor = "";
		btNext = new JButton(AppCore.getInstance().getRb().getString("btNext"));
		btCancel = new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		btNext.setAction(ActionManager.getInstance().getSaveParametarAction());
		btCancel.setAction(ActionManager.getInstance().getCancelAction());
		
		this.add(lbAutor,"wrap");
		this.add(tfAutor,"wrap");
		this.add(btNext,"wrap");
		this.add(btCancel,"wrap");
		
		this.setVisible(true);
	}

	public String getAutor() {
		return "Author:"+tfAutor.getText();
	}

	public Parametar getParametar() {
		return p;
	}

	public void setParametar(String p) {
		this.p.setName(p);
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void updateComp(){
		lbAutor.setText(AppCore.getInstance().getRb().getString("lbAuthor"));
		btNext.setText(AppCore.getInstance().getRb().getString("btNext"));
		btCancel.setText(AppCore.getInstance().getRb().getString("btCancel"));
	}
}
