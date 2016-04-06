
// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author eric
 * @version Jan 27, 2016
 */

public class Rectangle
{
    //Declare the fields private
    private int length;
    private int width;


    // ----------------------------------------------------------
    /**
     * Create a new Rectangle object.
     * No arguments constructor
     */
    public Rectangle() {
        this.length = 0;
        this.width = 0;

    }
    // ----------------------------------------------------------
    /**
     * Create a new Rectangle object.
     * @param length : initial length
     * @param width : initial width
     */
    public Rectangle(int length, int width)
    {
        this.length = length;
        this.width = width;

    }


    // ----------------------------------------------------------
    /**
     * Mutator or setter: set/change the value of length
     * Methods are declared public
     * @param length the new value of length
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    // ----------------------------------------------------------
    /**
     * Accessor or getter
     * @return the value of length
     */
    public int getLength() {
        return this.length;
    }


    // ----------------------------------------------------------
    /**
     * Mutator or setter: set/change the value of width
     * Methods are declared public
     * @param width : the new value of width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    // ----------------------------------------------------------
    /**
     * Accessor or getter
     * @return the value of width
     */
    public int getWidth() {
        return this.width;
    }

    // ----------------------------------------------------------
    /**
     * Method that computes and returns the perimeter of
     * a rectangle.
     * @return perimeter
     */
    public int getPerimeter()
    {
        return 2 * (this.length + this.width);
    }


    // ----------------------------------------------------------
    /**
     * Method that computes and returns the area of
     * a rectangle.
     * @return area
     */
    public int getArea()
    {
        return this.length * this.width;
    }


    @Override
    public String toString()
    {
        return "width=" + this.width + ", length=" + this.length;
    }


}
