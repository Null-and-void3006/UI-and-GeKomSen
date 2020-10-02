package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import view.EditTextElementDialog;
import view.PagePanel;
import view.TextComponentPopupMenu;
import view.TextElementPanel;

public class TextElementMouseListener extends MouseAdapter{
private TextElementPanel tep;
private PagePanel pp;

public TextElementMouseListener(PagePanel pp,TextElementPanel tep) {
	super();
	this.pp=pp;
	this.tep = tep;
}

@Override
public void mouseClicked(MouseEvent e) {
	if(SwingUtilities.isLeftMouseButton(e))
	new EditTextElementDialog(tep);
	if(SwingUtilities.isRightMouseButton(e)){
		new TextComponentPopupMenu(pp,tep).show(e.getComponent(), e.getX(), e.getY());
	}
}

}
