import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This is the binary tree class, which contains all of the parameters of and
 * function of the binary tree object.
 *
 * @author Tyler
 * @version Apr 8, 2016
 */
public class BinaryTreeTest
    extends TestCase
{

    private BinaryTree<Integer> tree1;
    private BinaryTree<Integer> tree2;
    private BinaryTree<Integer> tree3;


    // ----------------------------------------------------------
    /**
     * Set up method for the test class.
     */
    public void setUp()
    {
        tree1 = new BinaryTree<Integer>(1);
        tree2 = new BinaryTree<Integer>(2);
        tree3 = new BinaryTree<Integer>(3, tree1, tree2);
    }


    // ----------------------------------------------------------
    /**
     * Tests the size method by passing trees of known size and asserting that
     * they are correct.
     */
    public void testSize()
    {
        assertEquals(tree3.getLeft(), tree1);
        assertEquals(tree3.getRight(), tree2);
        assertEquals(3, tree3.size());
        assertEquals(1, tree1.size());
    }


    // ----------------------------------------------------------
    /**
     * Asserts that the height method works by passing trees of known height.
     */
    public void testHeight()
    {
        assertEquals(2, tree3.height());
    }


    // ----------------------------------------------------------
    /**
     * Asserts that the clone method works properly by
     */
    public void testClone()
    {
        BinaryTree<Integer> tree4 = tree3.clone();
        assertEquals(tree3.toPostOrderString(), tree4.toPostOrderString());
    }


    // ----------------------------------------------------------
    /**
     * Tests that the PreOrder toString method works properly.
     */
    public void testToPreOrderString()
    {
        System.out.println(tree3.toPreOrderString());
        assertEquals("(3(1)(2))", tree3.toPreOrderString());
    }


    // ----------------------------------------------------------
    /**
     * Tests that the InOrder toString method works properly.
     */
    public void testToInOrderString()
    {
        System.out.println(tree3.toInOrderString());
        assertEquals("((1)3(2))", tree3.toInOrderString());
    }


    // ----------------------------------------------------------
    /**
     * Tests that the PostOrder toString method works properly.
     */
    public void testToPostOrderString()
    {
        System.out.println(tree3.toPostOrderString());
        assertEquals("((1) (2) 3)", tree3.toPostOrderString());
    }
}
