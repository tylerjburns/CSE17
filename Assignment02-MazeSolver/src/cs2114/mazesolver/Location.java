package cs2114.mazesolver;

// -------------------------------------------------------------------------
/**
 * This class represents the location of any given cell and holds all of the
 * parameters for its location.
 *
 * @author Tyler
 * @version Mar 18, 2016
 */
public class Location
    implements ILocation
{
    private int x;
    private int y;


    // ----------------------------------------------------------
    /**
     * Create a new Location object.
     *
     * @param x
     *            is the x coordinate
     * @param y
     *            is the y coordinate
     */
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    // ----------------------------------------------------------
    /**
     * Determine if the locations are equal.
     *
     * @param a is the object passed to the method
     * @return the boolean indicating the outcome
     */
    public boolean equals(Object a)
    {
        return a instanceof Location
            && (((Location)a).x() == this.x && ((Location)a).y() == this.y());
    }


    // ----------------------------------------------------------
    /**
     * Writes the location parameter values to a string and returns them
     *
     * @return the parameter values
     */
    public String toString()
    {
        return "(" + this.x() + ", " + this.y() + ")";
    }


    // ----------------------------------------------------------
    /**
     * Gets the x-coordinate of the location.
     *
     * @return the x-coordinate of the location
     */
    @Override
    public int x()
    {
        return this.x;
    }


    // ----------------------------------------------------------
    /**
     * Gets the y-coordinate of the location.
     *
     * @return the y-coordinate of the location
     */
    @Override
    public int y()
    {
        return this.y;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Gets a new location that represents the (x, y) coordinates one cell north
     * of this location.
     * </p>
     * <p>
     * This method should not perform any bounds checking, because locations are
     * simply (x, y) pairs. If {@code north()} is called on a location
     * representing (0, 0), then the result should be (0, -1).
     * </p>
     *
     * @return a new location representing the (x, y) coordinates one cell north
     *         of this location
     */
    @Override
    public ILocation north()
    {
        Location next = new Location(x, y - 1);
        return next;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Gets a new location that represents the (x, y) coordinates one cell south
     * of this location.
     * </p>
     * <p>
     * This method should not perform any bounds checking, because locations are
     * simply (x, y) pairs.
     * </p>
     *
     * @return a new location representing the (x, y) coordinates one cell south
     *         of this location
     */
    @Override
    public ILocation south()
    {
        Location next = new Location(x, y + 1);
        return next;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Gets a new location that represents the (x, y) coordinates one cell west
     * of this location.
     * </p>
     * <p>
     * This method should not perform any bounds checking, because locations are
     * simply (x, y) pairs. If {@code west()} is called on a location
     * representing (0, 0), then the result should be (-1, 0).
     * </p>
     *
     * @return a new location representing the (x, y) coordinates one cell west
     *         of this location
     */
    @Override
    public ILocation west()
    {
        Location next = new Location(x - 1, y);
        return next;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Gets a new location that represents the (x, y) coordinates one cell east
     * of this location.
     * </p>
     * <p>
     * This method should not perform any bounds checking, because locations are
     * simply (x, y) pairs.
     * </p>
     *
     * @return a new location representing the (x, y) coordinates one cell east
     *         of this location
     */
    @Override
    public ILocation east()
    {
        Location next = new Location(x + 1, y);
        return next;
    }

}
