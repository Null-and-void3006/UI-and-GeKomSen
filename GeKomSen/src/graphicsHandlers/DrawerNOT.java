package graphicsHandlers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawerNOT extends JComponent{
	int x;
	int y;
	public DrawerNOT(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawLine(x, y, x, y+50);
		
		g.setColor(Color.BLACK);
		g.drawLine(x, y, x+30, y+25);
		
		g.setColor(Color.BLACK);
		g.drawLine(x, y+50, x+30, y+25);
		
		g.setColor(Color.BLACK);
		g.drawArc(x+31, y+23, 5, 5, 0, 360);
		
		g.setColor(Color.BLUE);
		g.drawLine(x-20, y+25, x, y+25);
		
		g.setColor(Color.BLUE);
		g.drawLine(x+38, y+25, x+50, y+25);
		
	}
}
