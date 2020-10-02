package app;

import java.awt.EventQueue;

import javax.swing.JTree;

import fileHandling.FileSystemHandler;
import treeInfoModels.ElementInfoModel;
import view.ElementLogicalCircuitView;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				AppCore.getInstance();
				//new ElementLogicalCircuitView(new ElementInfoModel());
			}
		});
	}
	
}
