package commands;

import view.ElementLogicalCircuitView;

public class ElcvRedo implements ELCVCommand{

	@Override
	public void execute(ElementLogicalCircuitView elcv) {
		elcv.redo();
		
	}

}
