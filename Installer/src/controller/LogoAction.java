package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import app.AppCore;

public class LogoAction extends AbstractAction{
	private Locale lokal;
	private ResourceBundle rb;
	
	private JFileChooser fch;
	
	public LogoAction()
	{
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);
		putValue(NAME, rb.getString("browse"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		lokal= new Locale("en","US");
		rb = ResourceBundle.getBundle("resources/MessageResources", lokal);

		fch = new JFileChooser();
		int returnVal = fch.showOpenDialog(AppCore.getInstance().getMainFrame().getFp());
		File file = null;
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			file = fch.getSelectedFile();
			System.out.println(rb.getString("success"));
		}
		else
		{
			System.out.println(rb.getString("cancel"));
		}
		
		AppCore.getInstance().getMainFrame().getFp().getLogoPan().setIcon(new ImageIcon(file.toString()));
		AppCore.getInstance().getMainFrame().getFp().getLogoPan().getTfBrowse().setText(file.getPath());
		System.out.println(file.getPath());
	}

}
