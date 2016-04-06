import java.util.EmptyStackException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link ArrayListStack} class.
 *
 * @author Tyler
 * @version 2016.03.15
 */
public class ArrayListStackTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    private ArrayListStack<String> stack;
    private String                 arrayItem1;
    private String                 arrayItem2;
    private String                 arrayItem3;

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new ArrayListStack<String>();
        arrayItem1 = "thing1";
        arrayItem2 = "thing2";
        arrayItem3 = "thing3";
    }


    // ----------------------------------------------------------
    /**
     * Tests the push method by sending two items to the stack and checking that
     * the size of the stack is correct.
     */
    public void testPush()
    {
        stack.push(arrayItem1);
        assertEquals(1, stack.size());
        stack.push(arrayItem2);
        assertEquals(2, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the pop method with an object and also when the stack is empty.
     */
    public void testPop()
    {
        stack.push(arrayItem1);
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
        Exception thrown = null;
        try
        {
            stack.pop();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    // ----------------------------------------------------------
    /**
     * Tests the top method with an object on the stack as well as with an empty
     * stack.
     */
    public void testTop()
    {
        Exception thrown = null;
        try
        {
            stack.top();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
        stack.push(arrayItem1);
        assertEquals(arrayItem1, stack.top());
        stack.push(arrayItem2);
        assertEquals(arrayItem2, stack.top());
    }


    // ----------------------------------------------------------
    /**
     * Tests the size method by changing stack contents and asserting that size
     * changes accordingly.
     */
    public void testSize()
    {
        assertEquals(0, stack.size());
        stack.push(arrayItem1);
        assertEquals(1, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the isEmpty method by asserting that stack is empty, adds an object
     * to stack and asserts that stack is no longer empty.
     */
    public void testIsEmpty()
    {
        assertTrue(stack.isEmpty());
        stack.push(arrayItem3);
        assertFalse(stack.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Performs multiple push, pop, and top operations, verifying size, and
     * isEmpty respond accordingly throughout the whole process.
     */
    public void testFillAndClear()
    {
        assertTrue(stack.isEmpty());
        Exception thrown = null;
        try
        {
            stack.top();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
        try
        {
            stack.pop();
        }
        catch (Exception exception2)
        {
            thrown = exception2;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
        stack.push(arrayItem1);
        assertEquals(arrayItem1, stack.top());
        stack.push(arrayItem2);
        assertEquals(arrayItem2, stack.top());
        stack.push(arrayItem3);
        assertEquals(arrayItem3, stack.top());
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        stack.pop();
        assertFalse(stack.isEmpty());
        assertEquals(arrayItem2, stack.top());
        assertEquals(2, stack.size());
        stack.pop();
        assertFalse(stack.isEmpty());
        assertEquals(arrayItem1, stack.top());
        assertEquals(1, stack.size());
        stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        try
        {
            stack.top();
        }
        catch (Exception exception3)
        {
            thrown = exception3;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
        try
        {
            stack.pop();
        }
        catch (Exception exception4)
        {
            thrown = exception4;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }
}
