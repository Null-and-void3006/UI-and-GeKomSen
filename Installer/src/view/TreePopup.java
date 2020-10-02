package view;

import javax.swing.JPopupMenu;

import controller.ActionManager;

public class TreePopup extends JPopupMenu{
	public TreePopup() {
		this.add(ActionManager.getInstance().getAddNodeAction());
		this.add(ActionManager.getInstance().getDeleteNodeAction());
		this.add(ActionManager.getInstance().getEditNodeAction());
	}
}
