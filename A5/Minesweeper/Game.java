//Assignment 5 MineSweeper
//By: Brandon Shearrer
//CS 2 Spring 2018

import java.io.*;

public class Game implements Serializable 
{
    //used to ensure that we can load the serialized object
    private static long serialVersionUID = -5061264484551653426L;

    Board gameBoard;
    int movesTaken = 0;
    int bombsRemaining = 0;
    boolean isWinner = false;
    boolean isLoser = false;

    /**
     * Creates the game object used to play, and places the bombs
     */
    public Game(int difficulty)
    {
        this.gameBoard = makeGameBoard(difficulty);
    }

    /**
     * Creates a new game board for the same game object. This is so we can use the same object for multiple sessions.
     */
    public void newGame(int difficulty)
    {
        this.gameBoard = makeGameBoard(difficulty);
        this.calculateBombsRemaining();
        this.movesTaken = 0;
    }

    /**
     * Serializes the game object and saves it to a file.
     */
    public void saveGame(String filePath) 
    {
        try 
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
            outputStream.writeObject(this);
            outputStream.flush();
            outputStream.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * Reads a game object that was previously serialized.
     */
    public void loadGame(String filePath)
    {
        Game temp = null;
        try 
        {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File(filePath)));
            temp = (Game) inputStream.readObject();
            this.gameBoard = temp.gameBoard;
            this.movesTaken = temp.movesTaken;
            this.bombsRemaining = temp.bombsRemaining;
        } 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Places or removes a flag from the tile at the coordinates passed in.
     */
    public void flagTile(int r, int c)
    {
        if(gameBoard.tiles[r][c].isFlag())
        {
            gameBoard.removeFlag(r, c);
        } 
        else if(!gameBoard.tiles[r][c].isFlag())
        {
            gameBoard.setFlag(r, c);
        }
        moveTaken();
    }

    /**
     * Clears an empty tile, or ends the game a bomb is clicked.
     */
    public void clickTile(int r, int c)
    {
        if(gameBoard.tiles[r][c].isBomb())
        {
            System.out.println("Game Over");
            isLoser = true;
        } 
        else if(gameBoard.tiles[r][c].isCover())
        {
            this.gameBoard.removeCover(r, c);
            this.gameBoard.clearSpacesAround(r, c);
        }
        moveTaken();
    }

    /**
     * Creates a bomb at the specified coordinates for testing purposes.
     */
    public void testBomb(int r, int c)
    {
        this.gameBoard.tiles[r][c].setBomb(true);
    }

    /**
     * Clears a bomb from the specified coordinates for testing purposes.
     */
    public void clearBomb(int r, int c)
    {
        this.gameBoard.tiles[r][c].setBomb(false);
    }

    /**
     * Incitements the moves taken counter, calculates the bombs remaining, and tests for a winner. Great for testing after moves.
     */
    public void moveTaken()
    {
        //this.gameBoard.findBombsAround();
        this.movesTaken++;
        calculateBombsRemaining();
        isWinner = gameBoard.checkWinner();
        //printGame();
    }

    /**
     * Used to print the board to the command line.
     */
    public void printGame()
    {
        System.out.println("Move: " + this.movesTaken + "\n-------------------");
        gameBoard.printBoard();
        System.out.println();
    }

    /**
     * Makes a new Game object with the specified difficulty.
     */
    public Board makeGameBoard(int difficulty)
    {
        return new Board(difficulty);
    }

    /**
     * Calculates the number of bombs not yet covered with a flag.
     */
    public void calculateBombsRemaining()
    {
        int temp = 0;
        for(int row = 0; row < this.gameBoard.tiles.length; row++) 
        {
            for (int col = 0; col < this.gameBoard.tiles[row].length; col++) 
            {
                if(this.gameBoard.tiles[row][col].isBomb() && this.gameBoard.tiles[row][col].isFlag())
                {
                    temp++;
                }
            }
        }
        bombsRemaining = gameBoard.bombs - temp;
    }
}
