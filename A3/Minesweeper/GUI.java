//Brandon Shearrer
//CS 2 - Assignment 3
//Spring 2018

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends JFrame
{
	public int spacing = 1; 
	public int neighs = 0;
	public int mx = -100;
	public int my = -100;
	public int smileyX = 605;
	public int smileyY = 5;
	public int smileyCenterX = smileyX + 35;
	public int smileyCenterY = smileyY + 35;
	public int vicMesX = 800;
	public int vicMesY = -50;
	public int flagX = 445;
	public int flagY = 5;
	public int flagCenterX = flagX + 35;
	public int flagCenterY = flagY + 35;
	
	public boolean smile = true;
	public boolean win = false;
	public boolean loss = false;
	public boolean resetter = false;
	public boolean flag = false;
	
	String vicMes = "Nothing Yet!";
	
	Date startDate = new Date();
	Date endDate;
	
	Random rand = new Random();
	
	int[][] mines = new int[16][9];
	int[][] neighbours = new int[16][9];
	boolean[][] revealed = new boolean[16][9];
	boolean[][] flagged = new boolean[16][9];
	 
	public GUI()
	{	
		this.setTitle("Minesweeper - Brandon Shearrer");
		this.setSize(1286, 829);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				// Get random number between 0 - 99
				// if less than 20 it will have mines inside
				// about 1/5 will have mines if < 20 is set 
				if (rand.nextInt(100) < 20)
				{
					mines[i][j] = 1;
				}
				else
				{
					mines[i][j] = 0;
				}
				revealed[i][j] = false;
			}
		}
		
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				neighs = 0;
				for(int m = 0; m< 16; m++)
				{
					for (int n = 0; n < 9; n++)
					{
						if(!(m==i && n ==j))
						if(isN(i,j,m,n) == true)
						{
							neighs++;
						}
					}
					neighbours[i][j] = neighs;
				}
			}
		}
		
		GameBoard board = new GameBoard();
		this.setContentPane(board);
		
		Move move = new Move();
		this.addMouseMotionListener(move);
		
		Click click = new Click();
		this.addMouseListener(click);
		
	}
	
	public class GameBoard extends JPanel
	{
		public void paintComponent(Graphics g) 
		{
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, 1280, 800);
		
			for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 9; j++) {
					g.setColor(Color.GRAY);

					if (revealed[i][j] == true)
					{
						g.setColor(Color.WHITE);
						if (mines[i][j] == 1)
						{
							g.setColor(Color.RED);
						}
					}
					if (mx >= (spacing+i*80) && mx < (spacing+i*80+80-2*spacing) && my >= (spacing+j*80+80+26) && my < (spacing+j*80+80+80-2*spacing))
					{
						g.setColor(Color.LIGHT_GRAY);
					}
					g.fillRect(spacing+i*80, spacing+j*80+80, 80 - 2*spacing, 80 - 2*spacing);
					if (revealed[i][j] == true)
					{
						g.setColor(Color.BLACK);
						if (mines [i][j] == 0 && neighbours[i][j] != 0)
						{
							if(neighbours[i][j] == 1)
							{
								g.setColor(Color.BLUE);
							}
							else if(neighbours[i][j] == 2)
							{
								g.setColor(Color.GREEN);
							}
							else if(neighbours[i][j] == 3)
							{
								g.setColor(Color.RED);
							}
							else if(neighbours[i][j] == 4)
							{
								g.setColor(new Color(0,0,128));
							}
							else if(neighbours[i][j] == 5)
							{
								g.setColor(new Color(178,34,34));
							}
							else if(neighbours[i][j] == 6)
							{
								g.setColor(new Color(72,209,204));
							}
							else if(neighbours[i][j] == 8)
							{
								g.setColor(Color.darkGray);
							}
							g.setFont(new Font("Times New Roman", Font.BOLD, 40));
							g.drawString(Integer.toString(neighbours[i][j]), i*80+27, j*80+80+55);
							
							//Victory Message Painting
							if (win == true)
							{
								g.setColor(Color.GREEN);
								vicMes = "You Win";
							}
							else if (loss == true) {
								g.setColor(Color.RED);
								vicMes = "You Lose";
							}
							
							if (win == true || loss == true)
							{
								vicMesY = -50 + (int)(new Date().getTime() - endDate.getTime()) / 10;
								if (vicMesY > 70) {
									vicMesY = 70;
								}
								g.setFont(new Font("Tahoma", Font.PLAIN, 70));
								g.drawString(vicMes, vicMesX, vicMesY);
							}
							
						}
						else if (mines [i][j] == 1)
						{
							
							g.fillRect(i*80+10+20 , j*80+80+20, 20, 40);
							g.fillRect(i*80+20, j*80+80+10+20, 40, 20);
							g.fillRect(i*80+5+20, j*80+80+5+20, 30, 30);
							g.fillRect(i*80+35, j*80+80+10, 10,20);
							
						}
					}
					
					//flags painting
					if(flagged[i][j] == true)
					{
						g.setColor(Color.BLACK);
						g.fillRect(i*80+32+5, j*80+80+15+5, 5, 40);
						g.fillRect(i*80+20+5, j*80+80+50+5, 30, 10);
						g.setColor(Color.RED);
						g.fillRect(i*80+16+5, j*80+80+15+5, 20, 15);
						g.setColor(Color.BLACK);
						g.drawRect(i*80+16+5, j*80+80+15+5, 20, 15);
						g.drawRect(i*80+17+5, j*80+80+16+5, 18, 13);
					}
				}
			}
			
			//creating smiley for game reset
			g.setColor(Color.yellow);
			g.fillOval(smileyX, smileyY, 70, 70);
			g.setColor(Color.black);
			g.fillOval(smileyX+45, smileyY+20, 10, 10);
			g.fillOval(smileyX+15, smileyY+20, 10, 10);
			if(smile == true)
			{
				g.fillRect(smileyX+20, smileyY+50, 30, 5);
				g.fillRect(smileyX+15, smileyY+45, 5, 10);
				g.fillRect(smileyX+50, smileyY+45, 5, 10);
			}
			else
			{
				g.fillRect(smileyX+20, smileyY+45, 30, 5);
				g.fillRect(smileyX+17, smileyY+45, 5, 10);
				g.fillRect(smileyX+48, smileyY+45, 5, 10);
			}
			
			//flag painting
			g.setColor(Color.BLACK);
			g.fillRect(flagX+32, flagY+15, 5, 40);
			g.fillRect(flagX+20, flagY+50, 30, 10);
			g.setColor(Color.RED);
			g.fillRect(flagX+15, flagY+15, 20, 15);
			g.setColor(Color.BLACK);
			g.drawRect(flagX+15, flagY+15, 20, 15);
			g.drawRect(flagX+16, flagY+16, 18, 13);
			
			if(flag == true)
			{
				g.setColor(Color.RED);
			}
			
			g.drawOval(flagX, flagY, 70, 70);
			g.drawOval(flagX+1, flagY+1, 68, 68);
			g.drawOval(flagX+2, flagY+2, 66, 66);
			
		}
	}
	
	public class Move implements MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent arg0) {
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			//System.out.println("The Mouse Moved!");
			mx = e.getX();
			my = e.getY();
			//System.out.println("X: " + mx + "\nY: " + my);
		}
		
	}
	
	public class Click implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			mx = e.getX();
			my = e.getY();
			
			if(inBoxX() != -1 && inBoxY() != -1)
			{
				System.out.println("The mouse is in the [" + inBoxX() + "," + inBoxY() + "]\nNumber of mines neighboring: " + neighbours[inBoxX()][inBoxY()]);		
				if (flag == true && revealed[inBoxX()][inBoxY()] == false)
				{
					if(flagged[inBoxX()][inBoxY()] == false)
					{
						flagged[inBoxX()][inBoxY()] = true;
					}
					else
					{
						flagged[inBoxX()][inBoxY()] = false;
					}
				}
				else
				{
					if (flagged[inBoxX()][inBoxY()] == false)
					{
						revealed[inBoxX()][inBoxY()] = true;
					}
				}
			}
			else
			{
				System.out.println("Mouse click outside of boxes!");
			}
			
			if(inSmiley() == true)
			{
				resetGame();
				System.out.println("The mouse is inside the smiley!");
			}
			if(inFlag() == true)
			{
				if(flag == false)
				{
					flag = true;
					System.out.println("InFlag = True");
				}
				else
				{
					flag = false;
					System.out.println("InFlag = False");
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
			
		}
	}
	
	public void CheckVictory()
	{
		if(loss == false) 
		{
			for(int i = 0; i < 16; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					if (revealed[i][j] == true && mines[i][j] == 1)
					{
						loss = true;
						smile = false;
						endDate = new Date();
					}
				}
			}
		}
		if (totalRevealed() >= 144 - totalMines() && win == false)
		{
			win = true;
			endDate = new Date();
		}
	}
	
	public int totalMines()
	{
		int total = 0;
		
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if (mines[i][j] == 1)
				{
					total++;
				}
			}
		}
		return total;
	}
	
	public int totalRevealed()
	{
		int total = 0;
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(revealed[i][j] == true)
				{
					total++;
				}
			}
		} 	
		return total;
	}
	
	
	public void resetGame()
	{
		resetter = true;
		smile = true;
		win = false;
		loss = false;
		startDate = new Date();
		vicMesY = -50;
		vicMes = "Nothing Yet!";
		flag = false;
		
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (rand.nextInt(100) < 20)
				{
					mines[i][j] = 1;
				}
				else
				{
					mines[i][j] = 0;
				}
				revealed[i][j] = false;
				flagged[i][j] = false;
			}
		}
		
		for (int i = 0; i < 16; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				neighs = 0;
				for(int m = 0; m< 16; m++)
				{
					for (int n = 0; n < 9; n++)
					{
						if(!(m==i && n ==j))
						if(isN(i,j,m,n) == true)
						{
							neighs++;
						}
					}
					neighbours[i][j] = neighs;
				}
			}
		}
		resetter = false;
	}
	
	public boolean inSmiley()
	{
		int diff = (int)Math.sqrt(Math.abs(mx-smileyCenterX)*Math.abs(mx-smileyCenterX)+Math.abs(my-smileyCenterY)*Math.abs(my-smileyCenterY));
		if(diff<35)
		{
			return true;
		}
		return false;
	}
	
	public boolean inFlag()
	{
		int diff = (int)Math.sqrt(Math.abs(mx-flagCenterX)*Math.abs(mx-flagCenterX)+Math.abs(my-flagCenterY)*Math.abs(my-flagCenterY));
		if(diff<35)
		{
			return true;
		}
		return false;
	}
	
	public int inBoxX()
	{
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 9; j++) {
				if (mx >= (spacing+i*80) && mx < (spacing+i*80+80-2*spacing) && my >= (spacing+j*80+80+26) && my < (spacing+j*80+80+80-2*spacing))
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	public int inBoxY()
	{
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 9; j++) {
				if (mx >= (spacing+i*80) && mx < (spacing+i*80+80-2*spacing) && my >= (spacing+j*80+80+26) && my < (spacing+j*80+80+80-2*spacing))
				{
					return j;
				}
			}
		}
		return -1;
	}
	
	public boolean isN(int mX, int mY, int cX, int cY)
	{
		if(mX - cX < 2 && mX - cX > -2 && mY - cY < 2 && mY - cY > -2 && mines[cX][cY] == 1)
		{
			return true;
		}
		return false;
	}
}
