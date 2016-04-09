import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This is the test class for Expressions and reads the console history to make
 * sure the proper things were written to the console.
 *
 * @author Tyler
 * @version Apr 9, 2016
 */
public class ExpressionsTest
    extends TestCase
{

    // ----------------------------------------------------------
    /**
     * Tests the main method of the Expressions class.
     */
    public void testMain()
    {
        Expressions.main(null);
        assertTrue(
            systemOut().getHistory()
                .contains("(*(-(a)(b))(/(+(c)(d))(e)))"));
        assertTrue(
            systemOut().getHistory()
                .contains("(((a)-(b))*(((c)+(d))/(e)))"));
        assertTrue(
            systemOut().getHistory()
                .contains("(((a) (b) -) (((c) (d) +) (e) /) *)"));
    }
}
