//Assignment 3 Sierpinski's Triangle
//By: Brandon Shearrer
//CS 2 Spring 2018

import javax.swing.*;
import java.awt.*;

public class TFrame extends JFrame
{
	public TFrame()
	{
		setTitle("Sierpinski's Triangle");

		//Set size of the JFrame
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width/2,screenSize.height/2);

		TPanel tPanel = new TPanel();
		add(tPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
}