import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the {@link ListBasedBag} class.
 *
 * @author Tyler
 * @version 2013.03.07
 */
public class ListBasedBagTest
    extends TestCase
{
    // ~ Instance/static variables .............................................

    private ListBasedBag<Book>   bag1;
    private Book                 book1;
    private Book                 book2;

    // ~ Constructor ...........................................................


    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public ListBasedBagTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty bag and a new 6-sided die as the test fixture
     * for each test method.
     */
    public void setUp()
    {
        bag1 = new ListBasedBag<Book>();
        book1 = new Book(
            "Data Structures: Abstraction and Design Using Java",
            "Elliot B. Koffman and Paul A. T. Wolfgang",
            "978-0-470-12870-1");
        book2 = new Book(
            "Data Structures and Problem Solving Using Java",
            "Mark Allen Weiss",
            "0321541405");
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#ListBasedBag()}.
     */
    public void testArrayBag()
    {
        // Check that a new bag is empty

        // Initially, its size should be zero
        assertEquals(0, bag1.size());

        // It shouldn't contain our test die
        assertFalse(bag1.contains(book1));

        // If we try to pull out an element, nothing should come out
        assertNull(bag1.removeRandom());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#add(java.lang.Object)}.
     */
    public void testAdd()
    {
        bag1.add(book1);
        assertEquals(1, bag1.size());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#remove(java.lang.Object)}.
     */
    public void testRemove()
    {
        bag1.add(book1);
        assertEquals(null, bag1.remove(book2));
        bag1.add(book2);
        bag1.remove(book2);
        assertEquals(
            "{Data Structures: Abstraction and Design Using Java, "
            + "Elliot B. Koffman and Paul A. T. Wolfgang, 978-0-470-12870-1}",
            bag1.toString());

    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#removeRandom()}.
     */
    public void testRemoveRandom()
    {
        bag1.add(book1);
        bag1.add(book2);
        bag1.removeRandom();
        assertEquals(1, bag1.size());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#contains(java.lang.Object)}.
     */
    public void testContains()
    {
        bag1.add(book1);
        assertTrue(bag1.contains(book1));
        assertFalse(bag1.contains(book2));
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#isEmpty()}.
     */
    public void testIsEmpty()
    {
        assertEquals(true, bag1.isEmpty());
        bag1.add(book1);
        assertFalse(bag1.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#size()}.
     */
    public void testSize()
    {
        assertEquals(0, bag1.size());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#toString()}.
     */
    public void testToString()
    {
        bag1.add(book1);
        bag1.add(book1);
        assertEquals(
            "{Data Structures: Abstraction and Design Using Java, "
            + "Elliot B. Koffman and Paul A. T. Wolfgang, 978-0-470-12870-1, "
            + "Data Structures: Abstraction and Design Using Java, "
            + "Elliot B. Koffman and Paul A. T. Wolfgang, 978-0-470-12870-1}",
            bag1.toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests some arbitrary extra things, such as the effect of adding the
     * same object multiple times or removing an object that is in
     * the bag multiple times.
     */
    public void someTests()
    {
        bag1.add(book1);
        bag1.add(book2);
        bag1.add(book1);
        assertTrue(bag1.contains(book1));
        bag1.remove(book1);
        assertEquals(2, bag1.size());
// bag1.add("Hello");
// String bag = "a";
// bag += (String)bag1;
    }

}
