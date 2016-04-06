import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test cases for the SalariedEmployee class.
 *
 * @author Your name Tyler
 * @version (2016.02.08)
 */
public class SalariedEmployeeTest
    extends TestCase
{
    // ~ Fields ................................................................
    private SalariedEmployee john;
    private SalariedEmployee tim;

    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Sets up the test fixture. Called before every test case method.
     */
    public void setUp()
    {
        john = new SalariedEmployee("John", 400.00);
        tim = new SalariedEmployee("Tim", 600.00);
    }



    // ----------------------------------------------------------
    /**
     * Tests that the getters for name and pay rate are working for this
     * instance.
     */
    public void testGetNameAndPayRate()
    {
        assertEquals("John", john.getName());
        assertEquals(400.00, john.getPayRate(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests the weekly pay method for the Salaried Employee object
     */
    public void testWeeklyPay()
    {
        assertEquals(400.00, john.weeklyPay(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * Tests the meeting method
     */
    public void testMeeting()
    {
        assertEquals("Tim is joining John in a conference", john.meetWith(tim));
    }
}
