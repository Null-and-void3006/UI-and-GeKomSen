package commands;

import view.ElementLogicalCircuitView;

public class ElcvUndo implements ELCVCommand{

	@Override
	public void execute(ElementLogicalCircuitView elcv) {
		elcv.undo();
		
	}

}
