// -------------------------------------------------------------------------
/**
 * Tests the wrapper class for SuperArray
 *
 * @author Tyler
 * @version Feb 14, 2016
 */
public class CompArrayTest
    extends student.TestCase
{
    private CompArray ca;
    private String[]  a = { "a", "b", "c", "d" };
    private String    b = "element";

    /**
     *  Sets up the CompArray for the tests
     */
    public void setUp()
    {
        ca = new CompArray();
        SuperArray x = new SuperArray();
        CompArray y = new CompArray(x);
    }


    /**
     * Tests the add all method by adding an array to the subarray
     */
    public void testAddAll()
    {
        ca.addAll(a);
        assertEquals(4, ca.getSize());
    }


    /**
     * Tests the getter for addCount
     */
    public void testGetAddCount()
    {
        ca.addAll(a);
        assertEquals(4, ca.getAddCount());
    }


    /**
     * Tests the add method by adding a single element to the subarray
     */
    public void testAdd()
    {
        ca.add(b);
        assertEquals(1, ca.getSize());
    }
}
