//Assignment 5 MineSweeper
//By: Brandon Shearrer
//CS 2 Spring 2018

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter 
{
    Game game;
    JButton[][] buttons;
    MineSweeperPanel MineSweeperPanel;
    MineSweeperFrame MineSweeperFrame;


    public MouseHandler(Game game, JButton[][] buttons, MineSweeperPanel MineSweeperPanel, MineSweeperFrame MineSweeperFrame)
    {
        this.game = game;
        this.buttons = buttons;
        this.MineSweeperPanel = MineSweeperPanel;
        this.MineSweeperFrame = MineSweeperFrame;
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        super.mousePressed(e);
        JButton button = (JButton) e.getSource();

        String[] getParams = button.getToolTipText().split(", ");

        int row = Integer.parseInt(getParams[0]);
        int col = Integer.parseInt(getParams[1]);

        if(SwingUtilities.isLeftMouseButton(e))
        {
            if(game.gameBoard.tiles[row][col].getBombsAround() == 0)
            {
                game.clickTile(row, col);
                game.gameBoard.findBombsAround();
                game.gameBoard.clearSpacesAround(row, col);
                if(game.isLoser)
                {
                    MineSweeperFrame.showNew(false);
                }
            } 
            else 
            {
                game.clickTile(row, col);
                game.gameBoard.findBombsAround();
                if(game.isLoser)
                {
                    MineSweeperFrame.showNew(false);
                }
            }
        } 
        else if(SwingUtilities.isRightMouseButton(e))
        {
            game.flagTile(row, col);
            if(game.gameBoard.checkWinner())
            {
                MineSweeperFrame.showNew(true);
            }
        }

        MineSweeperPanel.repaint();

        System.out.println(row + ", " + col);
    }
}
