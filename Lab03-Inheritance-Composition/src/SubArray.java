// -------------------------------------------------------------------------
/**
 * Creates a subarray under the super class of SuperArray
 *
 * @author Tyler
 * @version Feb 14, 2016
 */
public class SubArray
    extends SuperArray
{
    private int addCount;


    // ----------------------------------------------------------
    /**
     * Create a new SubArray object.
     */
    SubArray()
    {
        addCount = 0;
    }


    // ----------------------------------------------------------
    /**
     * getter for addCount field
     *
     * @return addCount value
     */
    public int getAddCount()
    {
        return this.addCount;
    }


    /**
     * add method increments addCount and calls super method add()
     *
     * @param anEntry
     *            : the object to be added to the array
     */
    public void add(Object anEntry)
    {
        this.addCount += 1;
        super.add(anEntry);
    }


    /**
     * addAll method increments addCount according to c length and calls super
     * method addAll()
     *
     * @param c
     *            : the array to be added to the subarray
     */
    public void addAll(Object[] c)
    {
        this.addCount += c.length;
        super.addAll(c);
    }

}
