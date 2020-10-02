package graphicsHandlers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JComponent;

public class DrawerBlank extends JComponent{
	private Dimension d;
	private Point p;
	
	public DrawerBlank(Dimension d, Point p) {
		this.d=d;
		this.p=p;
	}
	public void drawComponent(Graphics g){
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.drawRect(p.x, p.y, d.width, d.height);
	}
}
