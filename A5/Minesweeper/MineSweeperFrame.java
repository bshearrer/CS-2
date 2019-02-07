//Assignment 5 MineSweeper
//By: Brandon Shearrer
//CS 2 Spring 2018

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweeperFrame extends JFrame 
{
    private static long serialVersionUID = -5061264484551653426L;

    public final String TITLE = "Minesweeper - Brandon Shearrer";
    public final int HEIGHT = 800;
    public final int WIDTH = 800;

    public ScorePanel scorePanel;
    public MineSweeperPanel MineSweeperPanel;
    public Game game;
    public Container container;
    public Container mainContainer;

    //Select the difficulty constants
    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;
    //Select the file operations constants
    public static final int NEW = 99;
    public static final int SAVE = 100;
    public static final int LOAD = 101;
    public static final int QUIT = 102;

    MineSweeperFrame()
    {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        container = getContentPane();
        container.setLayout(new BorderLayout());


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image im = toolkit.getImage("smiley.jpg");
        im = im.getScaledInstance(20, 20, 0);

        ImageIcon imageIcon = new ImageIcon(im);

        Object[] setValue = {"EASY", "MEDIUM", "HARD",};

        int difficlty = JOptionPane.showOptionDialog(null, "Select a difficulty", "Minesweeper", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, imageIcon, setValue, setValue[1]);

        switch (difficlty)
        {
            case 0:
                game = new Game(EASY);
                break;
            case 1:
                game = new Game(MEDIUM);
                break;
            case 2:
                game = new Game(HARD);
                break;
            default:
                game = new Game(EASY);
                break;
        }

        scorePanel = new ScorePanel(game);
        MineSweeperPanel = new MineSweeperPanel(game, this);

        container.add(getMenu(), BorderLayout.NORTH);

        mainContainer = new Container();
        mainContainer.setLayout(new BorderLayout());

        mainContainer.add(scorePanel, BorderLayout.NORTH);
        mainContainer.add(MineSweeperPanel, BorderLayout.CENTER);

        container.add(mainContainer);

        setVisible(true);
    }

    public void showNew(boolean won)
    {
        game.isLoser = false;
        game.isWinner = false;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image im = toolkit.getImage("smiley.jpg");
        im = im.getScaledInstance(20, 20, 0);

        ImageIcon imageIcon = new ImageIcon(im);

        Object[] setValue = {"EASY", "MEDIUM", "HARD"};

        String message = "";
        String title = "";
        if(won)
        {
            title = "Winner!";
            message = "You win! Select a difficulty to start a new game.";
        } 
        else if(!won)
        {
            title = "Loser!";
            message = "Select a difficulty to start a new game.";
        } 
        else 
        {
            title = "New Game";
            message = "Select a difficulty to start a new game.";
        }

        int difficlty = JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, imageIcon, setValue, setValue[1]);

        switch (difficlty)
        {
            case EASY:
                game.newGame(EASY);
                System.out.print("Easy");
                break;
            case MEDIUM:
                game.newGame(MEDIUM);
                System.out.print("Medium");
                break;
            case HARD:
                game.newGame(HARD);
                System.out.print("Hard");
                break;
            default:
                game.newGame(EASY);
                break;
        }
        refreshGame();
    }

    public void newGame(int difficulty)
    {
        switch (difficulty)
        {
            case EASY:
                game.newGame(EASY);
                break;
            case MEDIUM:
                game.newGame(MEDIUM);
                break;
            case HARD:
                game.newGame(HARD);
                break;
            default:
                game.newGame(EASY);
                break;
        }
        refreshGame();
    }

    private JMenuBar getMenu()
    {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem newGame = new JMenuItem("New");
        JMenuItem saveGame = new JMenuItem("Save");
        JMenuItem loadGame = new JMenuItem("Load");
        JMenuItem quitGame = new JMenuItem("Quit");

        newGame.addActionListener(new MenuListener(NEW));
        saveGame.addActionListener(new MenuListener(SAVE));
        loadGame.addActionListener(new MenuListener(LOAD));
        quitGame.addActionListener(new MenuListener(QUIT));

        fileMenu.add(newGame);
        fileMenu.add(saveGame);
        fileMenu.add(loadGame);
        fileMenu.add(quitGame);

        jMenuBar.add(fileMenu);

        return jMenuBar;
    }

    private class MenuListener implements ActionListener 
    {
        int action;

        MenuListener(int action)
        {
            this.action = action;
        }

        public void actionPerformed(ActionEvent e) 
        {
            switch (action)
            {
                case NEW:
                    showNew(false);
                    break;
                case SAVE:
                    fileOptions(SAVE);
                    break;
                case LOAD:
                    fileOptions(LOAD);
                    break;
                case QUIT:
                    System.out.println("Quit");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public void fileOptions(int action)
    {
        if(action == SAVE)
        {
            String filePath = "";
            JFileChooser jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                filePath = jFileChooser.getSelectedFile().getPath();
                game.saveGame(filePath);
                refreshGame();
            } 
            else 
            {
                System.out.println("Save canceled");
            }
        } 
        else if(action == LOAD)
        {
            String filePath = "";
            JFileChooser jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                filePath = jFileChooser.getSelectedFile().getPath();
                game.loadGame(filePath);
                refreshGame();
            } 
            else 
            {
                System.out.println("Load canceled");
            }
        }
        else if(action == QUIT)
        {
            System.exit(0);
        }
    }

    public void refreshGame()
    {
        mainContainer.remove(scorePanel);
        mainContainer.remove(MineSweeperPanel);

        scorePanel = new ScorePanel(game);
        scorePanel.game = this.game;
        scorePanel.paintComponent(getGraphics());

        MineSweeperPanel = new MineSweeperPanel(game, this);
        MineSweeperPanel.game = this.game;
        MineSweeperPanel.paintComponent(getGraphics());

        mainContainer.add(scorePanel, BorderLayout.NORTH);
        mainContainer.add(MineSweeperPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
