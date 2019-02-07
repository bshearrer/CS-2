//Assignment 3 Sierpinski's Triangle
//By: Brandon Shearrer
//CS 2 Spring 2018

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class TPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		int height = getHeight();
		int width = getWidth();
        int side;
        if (height < width)
        {
            side = height;   
        }
        else
        {
            side = width;
        }
        drawTriangle(g, 0, 0, side);
	}

	public void drawTriangle(Graphics g, int x, int y, int side)
	{
        if(side == 1)
        {
            g.drawRect(x, y, 1, 1);
        } 
        else 
        {
            //calculate the middle tip of the inside triangle
            int xMid = x + (side / 4);
            int yMid = y;

            //calculate the left tip of the inside triangle
            int xLeft = x;
            int yLeft = y + (side / 2);

            //calculate the right tip of the inside triangle
            int xRight = x + (side / 2);
            int yRight = y + (side / 2);

            //call drawTriangle on the calculated points
            drawTriangle(g, xMid, yMid, side / 2);
            drawTriangle(g, xLeft, yLeft, side / 2);
            drawTriangle(g, xRight, yRight, side / 2);
        }
    }
}