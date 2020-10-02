package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ParametarPanel extends JPanel{

	private JLabel lb1;
	private JComboBox<String> parametri;
	
	public ParametarPanel()
	{
		lb1 = new JLabel("Izaberite parametar");
		parametri = new JComboBox<>();
		
		parametri.addItem("Naziv softvera");
		parametri.addItem("Opis softvera");
		parametri.addItem("Autor");
		parametri.addItem("Logo");
		parametri.addItem("Verzija");
		parametri.addItem("Uslovi koriscenja");
		parametri.addItem("Tema");
		parametri.addItem("Podrzani jezici");
		parametri.addItem("Desktop precica");
		parametri.addItem("Pokretanje posle instalacije");
		parametri.addItem("Custom");
		
		this.add(lb1);
		this.add(parametri);
		
		this.setVisible(true);
	}
}
