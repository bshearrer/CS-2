import java.util.ArrayList;

/**
 * Created by kyle on 4/14/15.
 */
public interface GeographicObject {

    /**
     *
     * @return area
     */
    public double area();

    /**
     *
     * @return boundaryLength
     */
    public double boundaryLength();

    /**
     *
     * @return neighbors
     */
    public ArrayList<GeographicObject> neighbors();
}
