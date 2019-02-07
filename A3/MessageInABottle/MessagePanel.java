//Brandon Shearrer
//CS 2 - Assignment 3
//Spring 2018

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class MessagePanel extends JPanel
{

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.drawLine(500,250,500,700);
		g.drawLine(800,250,800,700);
		g.drawLine(500,700,800,700);
		g.drawLine(800,250,700,250);
		g.drawLine(500,250,600,250);
		g.drawLine(600,250,625,200);
		g.drawLine(700,250,675,200);
		g.drawLine(675,200,675,150);
		g.drawLine(625,200,625,150);
		g.drawOval(625,145,50,10);
		
		String str = "Krabby Patty Formula";
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.drawString(str, 540, 450);
	}
}
