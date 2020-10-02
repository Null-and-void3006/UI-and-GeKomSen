package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import treeInfoModels.ElementInfoModel;
import view.ElementLogicalCircuitView;
import view.NewELCView;

public class NewElementDialogAction extends AbstractAction{
public NewElementDialogAction() {
	putValue(NAME, "Add new element");
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//new NewELCView();
		System.out.println("ERROR: FUNCTION DEPRICATED");
		
	}

}
