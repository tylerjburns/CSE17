import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link LinkedStack} class.
 *
 * @author Your name Tyler
 * @version 2016.03.31
 */
public class LinkedStackTest
    extends TestCase
{
    // ~ Fields ................................................................

    private LinkedStack<String> stack;
    private String              info1;
    private String              info2;

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new LinkedStack<String>();
        info1 = "hello1";
        info2 = "hello2";
    }


    // ----------------------------------------------------------
    /**
     * Tests the push method by performing relevant actions and asserting
     * correctness.
     */
    public void testPush()
    {
        stack.push(info1);
        assertEquals(info1, stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * Tests the pop method by performing relevant actions and asserting
     * correctness.
     */
    public void testPop()
    {
        stack.push(info1);
        stack.push(info2);
        stack.pop();
        assertEquals(info1, stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * Tests the peek method by performing relevant actions and asserting
     * correctness.
     */
    public void testPeek()
    {
        stack.push(info1);
        assertEquals("hello1", stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * Tests the isEmpty method by performing relevant actions and asserting
     * correctness.
     */
    public void testIsEmpty()
    {
        assertTrue(stack.isEmpty());
        stack.push(info1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}
