package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ActionManager;
import net.miginfocom.swing.MigLayout;

public class LastPanel extends JPanel {
	private JLabel lbFinish;
	private JButton btFinish;
	public LastPanel() {
		super(new MigLayout());
		lbFinish=new JLabel("Done");
		btFinish=new JButton("Finish");
		btFinish.setAction(ActionManager.getInstance().getFinishAction());
		this.add(lbFinish,"wrap");
		this.add(btFinish, "wrap");
	}

}
