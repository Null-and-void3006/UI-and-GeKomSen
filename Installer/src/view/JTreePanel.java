package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;

import controller.TreeMouseListener;
import model.SoftverskaKompanija;

public class JTreePanel extends JPanel{
	private JTree jt;
	
	public JTreePanel(SoftverskaKompanija sk){
		this.setLayout(new BorderLayout());
		jt = new JTree(sk);
		jt.addMouseListener(new TreeMouseListener());
		this.add(jt, BorderLayout.CENTER);
	}

	public JTree getJt() {
		return jt;
	}

}
