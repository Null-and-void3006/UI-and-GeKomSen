package graphicsHandlers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class DrawerOR extends JComponent{
	int x;
	int y;
	public DrawerOR(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawArc(x, y, 20, 50, -95, 190);
		
		g.setColor(Color.BLACK);
		g.drawArc(x-25, y, 80, 50, -95, 190);
		
		g.setColor(Color.BLUE);
		g.drawLine(x-5, y+10, x+18, y+10);
		
		g.setColor(Color.BLUE);
		g.drawLine(x-5, y+40, x+18, y+40);
		
		g.setColor(Color.BLUE);
		g.drawLine(x+55, y+25, x+78, y+25);
	}
}
