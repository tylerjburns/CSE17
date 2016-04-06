
// -------------------------------------------------------------------------
/**
 * Test class for the SubArray subclass. Tests methods in SubArray
 *
 * @author Tyler
 * @version Feb 14, 2016
 */
public class SubArrayTest
    extends student.TestCase
{
    private SubArray sa;
    private String[] a = { "a", "b", "c", "d" };
    private String   b = "element";

    /**
     *  Sets up the SubArray for the tests
     */
    public void setUp()
    {
        sa = new SubArray();
    }

    // ----------------------------------------------------------


    // ----------------------------------------------------------
    /**
     * Tests the add all method by adding an array to the subarray
     */
    public void testAddAll()
    {
        sa.addAll(a);
        assertEquals(4, sa.getSize());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter for addCount
     */
    public void testGetAddCount()
    {
        sa.addAll(a);
        assertEquals(8, sa.getAddCount());
    }


    // ----------------------------------------------------------
    /**
     * Tests the add method by adding a single element to the subarray
     */
    public void testAdd()
    {
        sa.add(b);
        assertEquals(1, sa.getSize());
    }

}
