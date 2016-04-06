import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test cases for the Levenshtein distance algorithm.
 *
 * @author Your name Tyler
 * @version 2016.02.22
 */
public class LevenshteinTests
    extends TestCase
{
    private Levenshtein p;
    // ~ Public methods ..................................................


    /**
     * Creates instance of Levenshtein type to use to test the Levenshtein
     * recursive methods
     */
    public void setUp()
    {
        p = new Levenshtein("this is a long sentence", "this sentence is long");
    }


    // ----------------------------------------------------------
    /**
     * Calls the distance method and asserts that it responds correctly
     */
    public void testDistance()
    {
        assertEquals(15, p.distance());
    }
}
