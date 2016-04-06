import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link ArrayStack} class.
 *
 * @author Tyler
 * @version 2016.04.04
 */
public class ArrayStackTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    private Stack<String>    stack;
    private Iterator<String> iter;

    // ~ Constructor ...........................................................


    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public ArrayStackTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new ArrayStack<String>();
    }


    // ----------------------------------------------------------
    /**
     * Test the push() method.
     */
    public void testPush()
    {
        stack.push("hello");
        assertEquals(1, stack.size());
        assertEquals("hello", stack.top());

        stack.push("goodbye");
        assertEquals(2, stack.size());
        assertEquals("goodbye", stack.top());
    }


    // ----------------------------------------------------------
    /**
     * Test the pop() method.
     */
    public void testPop()
    {
        String word = "hello";
        stack.push(word);
        assertEquals(1, stack.size());

        stack.pop();

        // After removal, make sure the inserted object is no longer there.
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test the topAndPop() method.
     */
    public void testTopAndPop()
    {
        String word = "hello";
        stack.push(word);

        // Use assertSame() to ensure the specific object added is the
        // one returned here
        assertSame(word, stack.topAndPop());

        // After removal, make sure the inserted object is no longer there.
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test clear() with multiple values in the stack.
     */
    public void testRemove3()
    {
        String word1 = "hello";
        stack.push(word1);
        String word2 = "goodbye";
        stack.push(word2);
        assertEquals(2, stack.size());

        stack.clear();
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the hasNext() method by push values onto the stack and verifying
     * their presence, then popping and checking again.
     */
    public void testHasNext()
    {
        stack.push("hello");
        stack.push("world");
        iter = stack.iterator();
        assertEquals(true, iter.hasNext());
        stack.pop();
        assertEquals(false, iter.hasNext());
    }


    // ----------------------------------------------------------
    /**
     * Tests the next() method by pushing, then asserting that next() returns
     * the correct thing. It also checks a second next() call, asserting
     * that an exception is thrown.
     */
    public void testNext()
    {
        stack.push("hello");
        stack.push("world");
        iter = stack.iterator();
        assertEquals("world", iter.next());
        Exception problem = null;
        try
        {
            stack.pop();
            iter.next();
        }
        catch (NoSuchElementException a)
        {
            problem = a;
        }
        assertNotNull(problem);
        assertTrue(problem instanceof NoSuchElementException);
        assertEquals("The stack is empty.", problem.getMessage());
    }


    // ----------------------------------------------------------
    /**
     * Tests the remove() method by pushing things in, then removes an element
     * and asserts that the correct one was removed.
     */
    public void testRemove()
    {
        stack.push("hello");
        stack.push("world");
        stack.push("!");
        iter = stack.iterator();
        iter.next();
        iter.remove();
        assertEquals(2, stack.size());
        assertEquals("world", stack.top());
    }
}
