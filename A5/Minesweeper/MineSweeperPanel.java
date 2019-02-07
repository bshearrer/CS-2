//Assignment 5 MineSweeper
//By: Brandon Shearrer
//CS 2 Spring 2018

import javax.swing.*;
import java.awt.*;

public class MineSweeperPanel extends JPanel 
{
    JButton buttons[][];
    Game game;
    MineSweeperFrame MineSweeperFrame;

    MineSweeperPanel(Game game, MineSweeperFrame MineSweeperFrame)
    {
        this.game = game;
        this.MineSweeperFrame = MineSweeperFrame;

        buttons = new JButton[game.gameBoard.tiles.length][game.gameBoard.tiles.length];
        setLayout(new GridLayout(game.gameBoard.tiles.length, game.gameBoard.tiles.length));

        for(int i = 0; i < game.gameBoard.tiles.length; i++)
        {
            for(int j = 0; j < game.gameBoard.tiles.length; j++)
            {
                JButton button;
                if(!game.gameBoard.tiles[i][j].isCover())
                {
                    button = new JButton("" + game.gameBoard.tiles[i][j].getBombsAround());
                } 
                else if(game.gameBoard.tiles[i][j].isFlag())
                {
                    button = new JButton("FLAG");
                    repaint();
                } 
                else 
                {
                    button = new JButton("");
                    button.setBackground(Color.YELLOW);
                    button.setForeground(Color.LIGHT_GRAY);
                }

                button.setToolTipText(i + ", " + j);

                button.addMouseListener(new MouseHandler(game, buttons, this, MineSweeperFrame));

                buttons[i][j] = button;
            }
        }
        for(JButton[] buttonRow : buttons)
        {
            for(JButton buttonCol : buttonRow)
            {
                add(buttonCol);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        for (int i = 0; i < game.gameBoard.tiles.length; i++) 
        {
            for (int j = 0; j < game.gameBoard.tiles.length; j++) 
            {
                //Flags have to be red and print an F
                //Covered Spaces are black
                //uncovered spaces are white unless they have a bombs around > 0

                //flag is highest precidence
                if(game.gameBoard.tiles[i][j].isFlag())
                {
                    buttons[i][j].setText("F");
                    buttons[i][j].setBackground(Color.RED);
                    buttons[i][j].setForeground(Color.WHITE);
                }
                //check if it's covered
                else if(!game.gameBoard.tiles[i][j].isCover())
                {
                    game.gameBoard.findBombsAround();

                    if(game.gameBoard.tiles[i][j].getBombsAround() > 0)
                    {
                        buttons[i][j].setText("" + game.gameBoard.tiles[i][j].getBombsAround());
                        buttons[i][j].setForeground(Color.WHITE);
                        buttons[i][j].setBackground(Color.CYAN);
                    } 
                    else 
                    {
                        buttons[i][j].setText("" + game.gameBoard.tiles[i][j].getBombsAround());
                        buttons[i][j].setForeground(Color.LIGHT_GRAY);
                        buttons[i][j].setBackground(Color.LIGHT_GRAY);
                    }
                }
                //if it's covered, keep it black

                else if(game.gameBoard.tiles[i][j].isCover())
                {
                    buttons[i][j].setBackground(Color.DARK_GRAY);
                    buttons[i][j].setText("");
                }
            }
        }
    }
}
