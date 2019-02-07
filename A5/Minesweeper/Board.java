//Assignment 5 MineSweeper
//By: Brandon Shearrer
//CS 2 Spring 2018

import java.io.Serializable;
import java.util.Random;

public class Board implements Serializable 
{
    private static long serialVersionUID = -5061264484551653426L;

    Tile[][] tiles;
    int bombs;
    int gameDifficulty;

    //difficulty constants
    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;
    public static final int MASTER = 4;

    /**
     * Creates a new board and places the bombs.
     */
    public Board(int gameDifficulty) 
    {
        makeBoard(gameDifficulty);
        this.placeBombs();
    }

    public int getBombs() 
    {
        return bombs;
    }

    public Tile[][] getTiles() 
    {
        return tiles;
    }

    public Tile getTile(int r, int c)
    {
        return tiles[r][c];
    }

    public void setFlag(int r, int c)
    {
        tiles[r][c].setFlag(true);
    }

    public void removeFlag(int r, int c)
    {
        tiles[r][c].setFlag(false);
    }

    public void setCover(int r, int c)
    {
        tiles[r][c].setCover(true);
    }

    public void removeCover(int r, int c)
    {
        tiles[r][c].setCover(false);
    }

    /**
     * Creates the game tiles consisting of a two dimensional array.
     * Also sets the class variables of number of bombs and debugging variables.
     */
    public void makeBoard(int difficulty)
    {
        switch(difficulty)
        {
            case EASY:
                tiles = new Tile[10][10];
                bombs = 5;
                gameDifficulty = EASY;
                break;
            case MEDIUM:
                tiles = new Tile[10][10];
                bombs = 15;
                gameDifficulty = MEDIUM;
                break;
            case HARD:
                tiles = new Tile[15][15];
                bombs = 25;
                gameDifficulty = HARD;
                break;
            case MASTER:
                tiles = new Tile[15][15];
                bombs = 50;
                gameDifficulty = MASTER;
                break;
            default:
                tiles = new Tile[10][10];
                bombs = 5;
                gameDifficulty = EASY;
                break;
        }
        for(int r = 0; r < tiles.length; r++)
        {
            for(int c = 0; c < tiles[r].length; c++)
            {
                tiles[r][c] = new Tile();
            }
        }
    }

    /*
    Prints the tiles to the command line. Used for the CLI version of the game.
    Currently this prints a new board each time, also not formatted very well.
    */
    public void printBoard()
    {
        for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[i].length; j++)
            {
                if (tiles[i][j].isBomb()) 
                {
                    System.out.print("B ");
                } 
                else if(tiles[i][j].isFlag())
                {
                    System.out.print("F ");
                } 
                else if(!tiles[i][j].isCover())
                {
                    System.out.print(tiles[i][j].getBombsAround() + " ");
                } 
                else 
                {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Places the desired number of bombs on random squares of the tiles.
     */
    public void placeBombs()
    {
        for(int i = 0; i < this.bombs; i++)
        {
            Random random = new Random();
            int r = random.nextInt(tiles.length);
            int c = random.nextInt(tiles[r].length);

            if(!tiles[r][c].isBomb())
            {
                tiles[r][c].setBomb(true);
            } 
            else 
            {
                i--;
            }
        }
    }

    /**
     * method that sets the bombs around to 0, probably not needed anymore
     */
    public void clearBombsAround()
    {
        for (int r = 0; r < this.tiles.length; r++)
        {
            for (int c = 0; c < this.tiles[r].length; c++)
            {
                this.tiles[r][c].setBombsAround(0);
            }
        }
    }

    /**
     * Loops through all the tiles of the board, then every tile adjacent to that tile counting the bombs.
     * Then sets the bombsAround attribute of the current tile to the count of the bomb.
     */
    public void findBombsAround()
    {
        clearBombsAround();

        //loop through all the tiles
        for(int row = 0; row < this.tiles.length; row++)
        {
            for(int col = 0; col < this.tiles[row].length; col++)
            {
                //if we find a bomb, mak the tiles around it
                if(!this.tiles[row][col].isBomb())
                {
                    int count = 0;

                    //loop through all the tiles adjacent to the bomb
                    for(int x = row - 1; x <= row + 1; x++)
                    {
                        for(int y = col - 1; y <= col + 1; y++)
                        {
                            if(x >= 0 && x < tiles.length && y >= 0 && y < tiles[row].length)
                            {
                                if(tiles[x][y].isBomb())
                                {
                                    count++;
                                }
                            }
                        }
                    }
                    tiles[row][col].setBombsAround(count);
                }
            }
        }
    }

    /**
     * Recursive method to clear all the spaces around the tile clicked
     */
    public void clearSpacesAround(int row, int col) 
    {
        //loop through adjacent tiles to the one passed in
        findBombsAround();
        if(tiles[row][col].getBombsAround() == 0)
        {
            for(int x = row - 1; x <= row + 1; x++)
            {
                for(int y = col - 1; y <= col + 1; y++)
                {
                    //make sure the adjacent tile is in the bounds of the game board
                    if(x >= 0 && x < tiles.length && y >= 0 && y < tiles[row].length)
                    {
                        //if the tile isn't a bomb and is covered, uncover the tile and make a recursive call
                        //this is important so we don't call the method on covered tiles, which makes this method much more likely to result in a StackOverflow
                        if(!tiles[x][y].isBomb() && tiles[x][y].isCover() && tiles[x][y].getBombsAround() == 0)
                        {
                            tiles[x][y].setCover(false);
                            clearSpacesAround(x, y);
                        } 
                        else if(!tiles[x][y].isBomb() && !tiles[x][y].isFlag())
                        {
                            tiles[x][y].setCover(false);
                        }
                    }
                }
            }
        }
    }

    /**
     * Checks if all the bombs are covered with flags, and if the number of flags is equal to the number of bombs on the board.
     *
     */
    public boolean checkWinner()
    {
        int flaggedBombs = 0;
        int flagCount = 0;

        for(int row = 0; row < this.tiles.length; row++) 
        {
            for(int col = 0; col < this.tiles[row].length; col++) 
            {
                if(tiles[row][col].isFlag())
                {
                    flagCount++;
                }

                if(tiles[row][col].isBomb() && tiles[row][col].isFlag())
                {
                    flaggedBombs++;
                }
            }
        }
        if(flaggedBombs == bombs && flagCount == bombs)
        {
            System.out.println("You Win!");
            return true;
        } 
        else 
        {
            return false;
        }
    }
}
