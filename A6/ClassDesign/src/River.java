/**
 * Created by kyle on 4/14/15.
 */
public class River {
    private double length;
    private double width;
    private double flowSpeed;

    /**
     * Default constructor, makes basic river
     */
    public River() {
        length = 100;
        width = 10;
        flowSpeed = 5.0;
    }

    /**
     * Full contructor
     *
     * @param length
     * @param width
     * @param flowSpeed
     */
    public River(double length, double width, double flowSpeed) {
        this.length = length;
        this.width = width;
        this.flowSpeed = flowSpeed;
    }

    /**
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     *
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     *
     * @return flowSpeed
     */
    public double getFlowSpeed() {
        return flowSpeed;
    }

    /**
     *
     * @param flowSpeed
     */
    public void setFlowSpeed(double flowSpeed) {
        this.flowSpeed = flowSpeed;
    }
}
