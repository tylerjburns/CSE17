
// -------------------------------------------------------------------------
/**
 * Tests the SuperArray class
 *
 * @author Varun
 * @version Feb 5, 2016
 */
public class SuperArrayTest
    extends student.TestCase
{

    private SuperArray suA;

    /**
     *  Sets up the SuperArray for the tests
     */
    public void setUp()
    {
        String[] a = { "a", "b", "c", "d" };
        suA = new SuperArray(a);
    }


    // ----------------------------------------------------------
    /**
     * Test {@link SuperArray#addAll(Object[])}.
     */
    public void testAddAll()
    {
        assertEquals(4, suA.getSize());
        String test = "testString";
        suA.add(test);
        assertEquals(5, suA.getSize());
    }

}
