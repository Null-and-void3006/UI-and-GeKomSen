package graphicsHandlers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

import org.w3c.dom.css.Rect;

public class DrawerStart extends JComponent {
	private static int br=0;
	private int height;
	private int width;
	private Rectangle start;
	private Rectangle result;
	private int id;
	public DrawerStart(int height, int width) {
		br++;
		id=br;
		this.height=height;
		this.width=width;
		start= new Rectangle(0, 0, 10, height);
		this.setBackground(Color.RED);
		result= new Rectangle(width-25, 0, width, height);
		

	}
	
	@Override
	public void paintComponent(Graphics g){
		System.out.println("Painted self. My name is: "+id);
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.RED);
			g2.fill(start);
		g2.setColor(Color.BLUE);
			g2.fill(result);
	}

}
