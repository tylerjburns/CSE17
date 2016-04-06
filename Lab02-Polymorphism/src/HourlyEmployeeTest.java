import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test cases for the HourlyEmployee class.
 *
 * @author Your name Tyler
 * @version (2016.02.08)
 */
public class HourlyEmployeeTest
    extends TestCase
{
    // ~ Fields ................................................................
    private HourlyEmployee ben;
    private HourlyEmployee max;

    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Sets up the test fixture. Called before every test case method.
     */
    public void setUp()
    {
        ben = new HourlyEmployee("Ben", 8.00);
        max = new HourlyEmployee("Max", 5.00);
    }



    // ----------------------------------------------------------
    /**
     * Asserts that the name and pay rate are set correctly
     */
    public void testGetNameAndPayRate()
    {
        assertEquals("Ben", ben.getName());
        assertEquals(8.00, ben.getPayRate(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Asserts that the weekly pay is set correctly
     */
    public void testWeeklyPay()
    {
        assertEquals(320.00, ben.weeklyPay(), 0.01);
    }


    /**
     * Tests the meeting method
     */
    public void testMeeting()
    {
        assertEquals("Ben is meeting with Max", ben.meetWith(max));
    }
}
