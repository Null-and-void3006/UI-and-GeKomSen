package controller;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

import model.FileSource;

public class FileBrowseAction extends AbstractAction{
private FileSource src;
	public FileBrowseAction(FileSource src, String additionalInfo, String shortDesc) {
		this.src=src;
		putValue(NAME, "Browse "+ additionalInfo);
		putValue(SHORT_DESCRIPTION, shortDesc);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(null);
		//fc.setAcceptAllFileFilterUsed(false);
		fc.setApproveButtonText("File, I choose you");
		fc.showOpenDialog(null);
		File f = fc.getSelectedFile();
		src.setPath(f==null?null:f.getAbsolutePath());
	}
}