package graphicsHandlers;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class DrawerWIRE extends JComponent{

	private int x1, x2;
	private int y1, y2;
	
	public DrawerWIRE(int x, int y, int q, int w){
		this.x1 = x;
		this.y1 = y;
		this.x2 = q;
		this.y2 = w;
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawLine(x1, y1, x2, y2);
	}
}
