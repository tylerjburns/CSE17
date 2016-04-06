// -------------------------------------------------------------------------
/**
 * The composition class for the SuperArray class Creates a wrapper for
 * SuperArray
 *
 * @author Tyler
 * @version Feb 14, 2016
 */
public class CompArray
{
    private SuperArray s;
    private int        addCount;


    // ----------------------------------------------------------
    /**
     * Create a new CompArray object.
     */
    public CompArray()
    {
        SuperArray sca = new SuperArray();
        this.s = sca;
        this.addCount = 0;
    }


    // ----------------------------------------------------------
    /**
     * Create a new CompArray object.
     *
     * @param s
     *            : passes the SuperArray instance to be wrapped
     */
    public CompArray(SuperArray s)
    {
        this.s = s;
    }


    // ----------------------------------------------------------
    /**
     * Adds object o to s
     *
     * @param o
     *            : object to be added
     */
    public void add(Object o)
    {
        addCount++;
        s.add(o);
    }


    // ----------------------------------------------------------
    /**
     * Adds the c array to s
     *
     * @param c
     *            : array to be added to s
     */
    public void addAll(Object[] c)
    {
        addCount += c.length;
        s.addAll(c);
    }


    // ----------------------------------------------------------
    /**
     * returns addCount value
     *
     * @return : the int addCount
     */
    public int getAddCount()
    {
        return this.addCount;
    }


    // ----------------------------------------------------------
    /**
     * Returns size value of object passed
     *
     * @return : size value of object passed
     */
    public int getSize()
    {
        return s.getSize();
    }
}
