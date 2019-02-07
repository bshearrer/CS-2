/**
 * Created by kyle on 4/14/15.
 */
public class BoundarySegments {
    private double lengthMeters;

    /**
     *
     * @param lengthMeters
     */
    public BoundarySegments(double lengthMeters) {
        this.lengthMeters = lengthMeters;
    }

    /*
    GETTERS AND SETTERS
     */

    /**
     *
     * @return lengthMeters
     */
    public double getLengthMeters() {
        return lengthMeters;
    }

    /**
     *
     * @param lengthMeters
     */
    public void setLengthMeters(double lengthMeters) {
        this.lengthMeters = lengthMeters;
    }

    /*
    EXTERNAL METHODS
     */

    /**
     *
     * @return all objects that use the boundary segment in its borders
     */
    public GeographicObject borderOf(){
        return null;
    }
}
