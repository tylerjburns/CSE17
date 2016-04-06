import java.util.Arrays;

// -------------------------------------------------------------------------
/**
 * @author eric
 * @version Jan 2, 2016
 */

public class SuperArray
{
    private static final int INIT_SIZE = 10;
    private Object[]         arr;
    private int              size;


    // ----------------------------------------------------------
    /**
     * Create a new SuperArray object.
     */
    SuperArray()
    {
        arr = new Object[INIT_SIZE];
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Create a new SuperArray object.
     *
     * @param arr
     *            : object array
     */
    SuperArray(Object[] arr)
    {
        this.arr = arr;
        size = arr.length;
    }


    // ----------------------------------------------------------
    /**
     * Checks size of array and expands as necessary Then inserts the things we
     * just made room for
     *
     * @param anEntry
     *            : object variable
     */
    public void add(Object anEntry)
    {

        // Make sure there is room
        if (size >= this.arr.length)
        {
            reallocate();
        }

        // insert item
        this.arr[size] = anEntry;
        size++;
    }


    // ----------------------------------------------------------
    /**
     * iterates through the items to be added, creating room for them along the
     * way
     *
     * @param c
     *            : object array of items to be added
     */
    public void addAll(Object[] c)
    {

        for (int i = 0; i < c.length; i++)
        {
            add(c[i]);
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns value of the size variable
     *
     * @return : size variable
     */
    public int getSize()
    {
        return size;
    }


    /**
     * doubles the length of the array
     */
    private void reallocate()
    {
        int capacity = this.arr.length * 2;
        this.arr = Arrays.copyOf(this.arr, capacity);
    }

}
