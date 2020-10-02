package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.PageDisplayPane;
import view.PagePanel;
import view.TextElementPanel;

public class DeleteTextComponentAction extends AbstractAction{
	private PagePanel pp;
	private TextElementPanel tep;
public DeleteTextComponentAction(PagePanel pp, TextElementPanel tep) {
	this.pp=pp;
	this.tep=tep;
	this.putValue(NAME, "Delete");
}
	@Override
	public void actionPerformed(ActionEvent e) {
		pp.remove(tep);
		pp.getPtm().remove(tep.getStm());
		pp.revalidate();
		pp.repaint();	
	}

}
