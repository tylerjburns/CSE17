import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class for EventFinder class
 *
 *  @author Tyler
 *  @version Feb 26, 2016
 */
public class EventFinderTest
    extends TestCase
{
    private HistoricEvent         event;
    private HistoricEvent         event2;
    private HistoricEvent         event3;
    private HistoricEvent         event4;
    private HistoricEvent         event5;
    private HistoricEvent         event6;
    private HistoricEvent         event7;
    private HistoricEvent[]       events;
    private EventFinder           eventFinder;

    private static final String TITLE   = "CSE 017 Assignment";
    private static final String MESSAGE =
        "I went to class today, and I didn't even get a T-shirt.";

    /**
     * Starting conditions for all tests in this class.
     */
    public void setUp()
    {
        event  = new HistoricEvent(2008, TITLE, MESSAGE);
        event2 = new HistoricEvent(2010, TITLE, MESSAGE);
        event3 = new HistoricEvent(2010, "DiffTitle", MESSAGE);
        event4 = new HistoricEvent(2012, TITLE, MESSAGE);
        event5 = new HistoricEvent(2015, TITLE, MESSAGE);
        event6 = new HistoricEvent(2018, TITLE, MESSAGE);
        event7 = new HistoricEvent(2000, TITLE, MESSAGE);
        events = new HistoricEvent[] { event, event2, event3, event4, event5 };
        eventFinder = new EventFinder();
    }


    // ----------------------------------------------------------
    /**
     * Tests the find() method using given values and asserting their responses
     */
    public void testFind()
    {
        assertEquals(0, eventFinder.find(event, events, 0, 4));
        assertEquals(1, eventFinder.find(event2, events, 0, 4));
        assertEquals(2, eventFinder.find(event3, events, 0, 4));
        assertEquals(3, eventFinder.find(event4, events, 0, 4));
        assertEquals(4, eventFinder.find(event5, events, 0, 4));
        assertEquals(5, eventFinder.find(event6, events, 0, 4));
        assertEquals(0, eventFinder.find(event7, events, 0, 4));
    }


    // ----------------------------------------------------------
    /**
     * Tests the wrapper method for the find() method
     */
    public void testFind2()
    {
        assertEquals(0, eventFinder.find(event, events));
    }
}