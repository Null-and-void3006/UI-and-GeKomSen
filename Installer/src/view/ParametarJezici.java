package view;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.AppCore;
import controller.ActionManager;
import model.Language;
import model.Parametar;
import net.miginfocom.swing.MigLayout;

public class ParametarJezici extends JPanel{
	
	private JLabel lbl1;
	private ArrayList<Language> languages = new ArrayList<>();
	private ArrayList<JCheckBox> boxes = new ArrayList<>();
	private JButton next;
	private JButton cancel;
	

	private Parametar p;
	public ParametarJezici(Parametar p){

		this.p=p;
		this.setLayout(new MigLayout());
		lbl1 = new JLabel(AppCore.getInstance().getRb().getString("lbChooseLang"));
		this.add(lbl1, "wrap");
		languages.add(new Language(AppCore.getInstance().getRb().getString("langEnglish")));
		languages.add(new Language(AppCore.getInstance().getRb().getString("langSerbLat")));
		languages.add(new Language(AppCore.getInstance().getRb().getString("langSerbCyr")));
		next= new JButton(AppCore.getInstance().getRb().getString("btNext"));
		cancel= new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		next.setAction(ActionManager.getInstance().getSaveParametarAction());
		cancel.setAction(ActionManager.getInstance().getCancelAction());
		
		
		for(Language l:languages){
			boxes.add(new JCheckBox(l.getName()));
			this.add(boxes.get(boxes.size()-1), "wrap");
		}
		this.add(next);
		this.add(cancel);
		
	}
	public String getJezik()
	{
		String s = "";
		int cnt=0;
		for(JCheckBox cb:boxes){
			if(cb.isSelected())
			{
				s+=languages.get(cnt).toString()+",";
			}
			cnt++;
		}
		return "Languages:"+s;
	}
	public void setParametar(String name) {
		p.setName(name);
		
	}
	
}
