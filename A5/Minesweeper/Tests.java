/**
 * Created by kyle on 2/26/15.
 *
 * Test class with default constructor that runs all tests and prints the results.
 *
 */
public class Tests 
{

    public Tests()
    {
        System.out.println("Game can be won: " + winTest());
        System.out.println("Game can be lost: " + loseTest());
        System.out.println("Game can only be won with the correct amount of flags: " + flagTest());
    }

    private boolean winTest()
    {
        Game game = new Game(0);
        //clear all the bombs
        for(int i = 0; i < game.gameBoard.tiles.length; i++)
        {
            for(int j = 0; j < game.gameBoard.tiles[i].length; j++)
            {
                game.clearBomb(i, j);
            }
        }

        //place and flag all of the bombs
        game.testBomb(0, 0);
        game.testBomb(0, 1);
        game.testBomb(0, 2);
        game.testBomb(0, 3);
        game.testBomb(0, 4);

        game.flagTile(0, 0);
        game.flagTile(0, 1);
        game.flagTile(0, 2);
        game.flagTile(0, 3);
        game.flagTile(0, 4);

        return game.isWinner;
    }

    private boolean loseTest()
    {
        Game game = new Game(0);

        game.testBomb(0, 0);
        game.clickTile(0, 0);

        return game.isLoser;
    }

    private boolean flagTest()
    {
        Game game = new Game(0);
        //clear all the bombs
        for(int i = 0; i < game.gameBoard.tiles.length; i++)
        {
            for(int j = 0; j < game.gameBoard.tiles[i].length; j++)
            {
                game.clearBomb(i, j);
            }
        }

        //place and flag all of the bombs
        game.testBomb(0, 0);
        game.testBomb(0, 1);
        game.testBomb(0, 2);
        game.testBomb(0, 3);
        game.testBomb(0, 4);

        game.flagTile(0, 0);
        game.flagTile(0, 1);
        game.flagTile(0, 2);
        game.flagTile(0, 3);
        game.flagTile(0, 4);
        game.flagTile(0, 5);

        return !game.isWinner;
    }
}
