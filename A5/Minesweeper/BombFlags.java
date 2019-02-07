//Assignment 5 MineSweeper
//By: Brandon Shearrer
//CS 2 Spring 2018

import java.io.Serializable;

public class BombFlags implements Serializable 
{
    private static long serialVersionUID = -5061264484551653426L;

    private boolean bomb = false;
    private boolean cover = true;
    private boolean flag = false;
    private int bombsAround = 0;

    public BombFlags()
    {
        bomb = false;
        cover = true;
        flag = false;
    }

    public boolean isBomb()
    {
        return bomb;
    }

    public void setBomb(boolean bombed)
    {
        this.bomb = bombed;
    }

    public int getBombsAround() 
    {
        return bombsAround;
    }

    public void setBombsAround(int bombsAround) 
    {
        this.bombsAround = bombsAround;
    }

    public boolean isCover()
    {
        return this.cover;
    }

    public void setCover(boolean covered)
    {
        this.cover = covered;
    }

    public boolean isFlag() 
    {
        return this.flag;
    }

    public void setFlag(boolean flag) 
    {
        this.flag = flag;
    }
}
