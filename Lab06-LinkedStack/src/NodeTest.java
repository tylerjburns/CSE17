import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link Node} class.
 *
 * @author Tyler
 * @version 2016.03.31
 */
public class NodeTest
    extends TestCase
{
    // ~ Fields ................................................................

    // TODO: Depending on how you test, you might need more, or fewer, of
    // these.
    private Node<String> node1;
    private Node<String> node2;
    private Node<String> node3;

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * Create some new nodes for each test method.
     */
    public void setUp()
    {
        node1 = new Node<String>("node1");
        node2 = new Node<String>("node2");
        node3 = new Node<String>("node3");
    }


    // ----------------------------------------------------------
    /**
     * Tests the join method by performing relevant actions.
     */
    public void testJoin()
    {
        node1.join(node2);
        assertEquals(node2, node1.next());
        Exception thrown = null;
        try
        {
            assertEquals(" ", node1.join(node3));
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalStateException);
        assertEquals(
            "The calling node does not have next node \"null\".",
            thrown.getMessage());
    }


    // ----------------------------------------------------------
    /**
     * Tests the split method by performing relevant actions.
     */
    public void testSplit()
    {
        node1.join(node2);
        assertEquals(node2, node1.split());
        assertEquals(null, node1.split());
    }
}
