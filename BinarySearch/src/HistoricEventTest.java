import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link HistoricEvent} class.
 *
 * @author Tyler
 * @version Feb 26, 2016
 */
public class HistoricEventTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    private HistoricEvent       event;
    private HistoricEvent       event2;
    private HistoricEvent       event3;
    private HistoricEvent       event4;

    private static final String TITLE   = "CSE 017 Assignment";
    private static final String MESSAGE =
        "I went to class today, and I didn't even get a T-shirt.";

    // ~ Constructor ...........................................................


    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public HistoricEventTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * Starting conditions for all tests in this class.
     */
    public void setUp()
    {
        event = new HistoricEvent(2010, TITLE, MESSAGE);
        event2 = new HistoricEvent(2010, TITLE, MESSAGE);
        event3 = new HistoricEvent(2010, "DiffTitle", MESSAGE);
        event4 = new HistoricEvent(2008, TITLE, MESSAGE);
    }


    // ----------------------------------------------------------
    /**
     * Test the constructor and accessors.
     */
    public void testAccessors()
    {
        assertEquals(2010, event.getYear());
        assertEquals(TITLE, event.getTitle());
        assertEquals(MESSAGE, event.getDescription());
    }


    // ----------------------------------------------------------
    /**
     * Test toString() on the event created in setUp().
     */
    public void testToString()
    {
        assertEquals("[2010] " + TITLE + ": " + MESSAGE, event.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test toString() on an event with a null title.
     */
    public void testToString2()
    {
        event = new HistoricEvent(2010, MESSAGE);
        assertEquals("[2010] " + MESSAGE, event.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test toString() on an event with a null description.
     */
    public void testToString3()
    {
        event = new HistoricEvent(2010, TITLE, null);
        assertEquals("[2010] " + TITLE, event.toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests the compareTo() method by passing known values and asserting
     * the proper response is elicited.
     */
    public void testCompareTo()
    {
        assertEquals(0, event.compareTo(event2));
        assertEquals(-1, event.compareTo(event3));
        assertEquals(2, event.compareTo(event4));
    }
}
