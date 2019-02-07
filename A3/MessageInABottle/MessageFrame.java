//Brandon Shearrer
//CS 2 - Assignment 3
//Spring 2018

import javax.swing.*;
import java.awt.*;

public class MessageFrame extends JFrame
{
	public MessageFrame()
	{
		//Title of program
		setTitle("Message in a Bottle");

		//Set size of the JFrame
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width/2,screenSize.height/2);

		//Create JPanel
		MessagePanel panel = new MessagePanel();
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
