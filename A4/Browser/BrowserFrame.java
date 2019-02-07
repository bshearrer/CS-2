//Brandon Shearrer
//CS 2 - Assignment 4
//Spring 2018

//Class for creating the Frame of the Browser
import javax.swing.*;
import java.awt.*;

public class BrowserFrame extends JFrame 
{
    public final String TITLE = "Brandon's Browser";
    public final int HEIGHT = 900;
    public final int WIDTH = 600;
    public String enteredURL = "";

    Container container;

    BrowserFrame()
    {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BrowserPanel browserPanel = new BrowserPanel();
        browserPanel.setFrame(this);

        container = getContentPane();
        container.add(browserPanel);

        setVisible(true);
    }
}
