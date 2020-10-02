package graphicsHandlers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawerAND extends JComponent{
	int x;
	int y;
	public DrawerAND(int x, int y) {
		System.out.println("DrawAND constructed");
		this.x = x;
		this.y = y;
		System.out.println(this.getPreferredSize());
		System.out.println(this.getSize());
	}
	
	@Override
	public void paintComponent(Graphics g){
		System.out.println("DrawAND painted");
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawLine(x, y, x, y-50);
		
		g.setColor(Color.BLACK);
		g.drawArc(x-35, y-50, 75, 50, -95, 190);
		
		g.setColor(Color.BLUE);
		g.drawLine(x-20, y-40, x, y-40);
		
		g.setColor(Color.BLUE);
		g.drawLine(x-20, y-10, x, y-10);
		
		g.setColor(Color.BLUE);
		g.drawLine(x+40, y-25, x+60, y-25);
		
	}
}
