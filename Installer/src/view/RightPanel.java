package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.AppCore;
import controller.ActionManager;

public class RightPanel extends JPanel{
	
	private JPanel southPanel;
	private JButton btBack;
	private JButton btNext;
	private JButton btCancel;
	private JButton btPreview;

	
	public RightPanel(JPanel content) {
		this.setLayout(new BorderLayout());


		
		btBack = new JButton(AppCore.getInstance().getRb().getString("btBack"));
		btBack.setAction(ActionManager.getInstance().getPreviousPanelAction());
		btNext = new JButton(AppCore.getInstance().getRb().getString("btNext"));
		btNext.setAction(ActionManager.getInstance().getNextPanelAction());
		btCancel = new JButton(AppCore.getInstance().getRb().getString("btCancel"));
		btCancel.setAction(ActionManager.getInstance().getExitAction());
		btPreview= new JButton(AppCore.getInstance().getRb().getString("preview"));
		btPreview.setAction(ActionManager.getInstance().getPreviewAction());
		
		southPanel = new JPanel(new FlowLayout());
		
		southPanel.add(btBack);
		southPanel.add(btNext);
		southPanel.add(btCancel);
		southPanel.add(btPreview);
		
		this.add(content, BorderLayout.CENTER);
		
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	
	public RightPanel disableBack(){
		btBack.setEnabled(false);
		btNext.setEnabled(true);
		return this;
	}
	
	public RightPanel disableNext(){
		btNext.setEnabled(false);
		btBack.setEnabled(true);
		return this;
	}

}
