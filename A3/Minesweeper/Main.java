//Brandon Shearrer
//CS 2 - Assignment 3
//Spring 2018

public class Main implements Runnable
{
	GUI gui = new GUI();
	
	public static void main(String[] args) 
	{
		new Thread(new Main()).start();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			gui.repaint();
			if(gui.resetter == false)
			{
				gui.CheckVictory();
				//System.out.println("Victory: " + gui.win + ", Defeat: " + gui.loss);
			}
		}
	}

}