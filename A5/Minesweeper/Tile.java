import java.io.Serializable;

/**
 * Created by kyle on 2/15/15.
 *
 * The basic tile object used to create the board.
 */
public class Tile implements Serializable 
{
    private static long serialVersionUID = -5061264484551653426L;

    private boolean bomb = false;
    private boolean cover = true;
    private boolean flag = false;
    private int bombsAround = 0;

    public Tile()
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

    public int getBombsAround() 
    {
        return bombsAround;
    }

    public void setBombsAround(int bombsAround) 
    {
        this.bombsAround = bombsAround;
    }
}
