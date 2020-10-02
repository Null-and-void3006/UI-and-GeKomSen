package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.LogicalCircuitPanel;
import view.PagePanel;

public class DeleteLogicalCircuitAction extends AbstractAction{
	private PagePanel pp;
	private LogicalCircuitPanel lcp;
	
	public DeleteLogicalCircuitAction(PagePanel pp, LogicalCircuitPanel lcp) {
		super();
		this.pp = pp;
		this.lcp = lcp;
		this.putValue(NAME, "Delete");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pp.remove(lcp);
		pp.getPtm().remove(lcp.getStm());
		pp.revalidate();
		pp.repaint();	
		
	}

}
