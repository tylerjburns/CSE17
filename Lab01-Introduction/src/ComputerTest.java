import student.*;

// -------------------------------------------------------------------------
/**
 *  Unit tests for the {@link Computer} class.
 *
 *  @author  Tyler
 *  @version 2016.01.30
 */
public class ComputerTest
    extends student.TestCase
{
    //~ Instance/static fields ...............................................
    private Computer comp;


    //~ Constructor ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ComputerTest object.
     */
    public ComputerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /* Insert your own setup code here */
        comp = new Computer("AMD", 8, 3.6);
    }


    // ----------------------------------------------------------
    /* Insert your own test methods here */
    // ----------------------------------------------------------
    /**
     * Tests the getProcessor method by calling it and asserting the value.
     */
    public void testGetProcessor() {
        assertEquals("AMD", comp.getProcessor());
    }

    // ----------------------------------------------------------
    /**
     * Tests the getProcessorSpeed method by calling it and asserting the value.
     */
    public void testGetProcessorSpeed() {
        assertEquals(3.6, comp.getProcessorSpeed(), 0.01);
    }

    // ----------------------------------------------------------
    /**
     * Tests the getNumCores method by calling it and asserting the value.
     */
    public void testGetNumCores() {
        assertEquals(8, comp.getNumCores());
    }

    // ----------------------------------------------------------
    /**
     * Tests the setNumCores method by calling it,
     * then using the getter and asserting the value was set.
     */
    public void testSetNumCores() {
        comp.setNumCores(8);
        assertEquals(8, comp.getNumCores());
    }

    // ----------------------------------------------------------
    /**
     * Tests the setProcessorSpeed method by calling it,
     * then using the getter and asserting the value was set.
     */
    public void testSetProcessorSpeed() {
        comp.setProcessorSpeed(3.6);
        assertEquals(3.6, comp.getProcessorSpeed(), 0.01);
    }

    // ----------------------------------------------------------
    /**
     * Tests the setProcessor method by calling it,
     * then using the getter and asserting the value was set.
     */
    public void testSetProcessor() {
        comp.setProcessor("AMD");
        assertEquals("AMD", comp.getProcessor());
    }

    // ----------------------------------------------------------
    /**
     * Tests the computePower method by getting multiplied values,
     * calling computePower, then comparing and asserting the value
     * is equal to the multiplication of the two.
     */
    public void testComputePower() {
        int a = comp.getNumCores();
        double b = comp.getProcessorSpeed();
        assertEquals(a * b, comp.computePower(), 0.01);
    }

    // ----------------------------------------------------------
    /**
     * Tests the toString method by calling it, then asserting the value
     * is equal to the correct, hard-coded statement.
     */
    public void testToString() {
        assertEquals("AMD, 8 cores at 3.6GHz", comp.toString());
    }
}