package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import model.LogicalCircuitElement;
import view.EditELCView;
import view.EditTextElementDialog;
import view.LogicalCircuitPanel;
import view.LogicalCircuitPopupMenu;
import view.PagePanel;
import view.TextComponentPopupMenu;
import view.TextElementPanel;

public class LogicalCircuitMouseListener extends MouseAdapter{
	private LogicalCircuitPanel lcp;
	private PagePanel pp;
	public LogicalCircuitMouseListener(LogicalCircuitPanel lcp, PagePanel pp) {
		super();
		this.lcp = lcp;
		this.pp = pp;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e))
			new EditELCView(lcp);
			if(SwingUtilities.isRightMouseButton(e)){
				new LogicalCircuitPopupMenu(pp,lcp).show(e.getComponent(), e.getX(), e.getY());
			}
	}
	

}
