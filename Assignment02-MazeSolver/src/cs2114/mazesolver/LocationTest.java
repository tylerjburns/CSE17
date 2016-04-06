package cs2114.mazesolver;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The test case for the location class.
 *
 * @author Tyler
 * @version Mar 18, 2016
 */
public class LocationTest
    extends TestCase
{
    private Location a;
    private Location b;
    private int      x;


    // ----------------------------------------------------------
    /**
     * Setup method for test class of Location.java
     */
    public void setUp()
    {
        a = new Location(1, 2);
        b = new Location(2, 2);
        x = 0;
    }


    // ----------------------------------------------------------
    /**
     * Test the equals() method by comparing a with itself, a with b (another
     * location object, and a with x, an integer.
     */
    public void testEquals()
    {

        assertTrue(a.equals(a));
        assertFalse(b.equals(a));
        assertFalse(a.equals(x));
    }


    // ----------------------------------------------------------
    /**
     * Tests the toString() method by comparing a hardcoded output to the output
     * of the method itself.
     */
    public void testToString()
    {
        assertEquals("(1, 2)", a.toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests the x() method against hard code.
     */
    public void testX()
    {
        assertEquals(1, a.x());
    }


    // ----------------------------------------------------------
    /**
     * Tests the x() method against hard code.
     */
    public void testY()
    {
        assertEquals(2, a.y());
    }


    // ----------------------------------------------------------
    /**
     * Tests north() by comparing the method's output to a hard coded
     * expectation.
     */
    public void testNorth()
    {
        ILocation newLoc = a.north();
        assertEquals(1, newLoc.y());
        assertEquals(1, newLoc.x());
    }


    // ----------------------------------------------------------
    /**
     * Tests south() by comparing the method's output to a hard coded
     * expectation.
     */
    public void testSouth()
    {
        ILocation newLoc = a.south();
        assertEquals(3, newLoc.y());
        assertEquals(1, newLoc.x());
    }


    // ----------------------------------------------------------
    /**
     * Tests west() by comparing the method's output to a hard coded
     * expectation.
     */
    public void testWest()
    {
        ILocation newLoc = a.west();
        assertEquals(0, newLoc.x());
        assertEquals(2, newLoc.y());
    }


    // ----------------------------------------------------------
    /**
     * Tests east() by comparing the method's output to a hard coded
     * expectation.
     */
    public void testEast()
    {
        ILocation newLoc = a.east();
        assertEquals(2, newLoc.x());
        assertEquals(2, newLoc.y());
    }
}
