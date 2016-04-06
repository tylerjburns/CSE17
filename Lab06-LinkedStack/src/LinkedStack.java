import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * An implementation of the stack data type that uses a linked chain of
 * {@code Node<E>} objects to store its contents. This is a PARTIAL
 * IMPLEMENTATION that needs completion.
 *
 * @param <E>
 *            the type of elements stored in the stack
 * @author Tony Allevato (authored class skeleton)
 * @author Your name Tyler
 * @version 2016.03.31
 */
public class LinkedStack<E>
    implements StackInterface<E>
{
    // ~ Fields ...............................................................
    private Node<E> last;
    private int     size;

    // ~ Constructors .........................................................


    // ----------------------------------------------------------
    /**
     * Create a new LinkedStack object.
     */
    public LinkedStack()
    {
        last = new Node<E>(null);
        size = 0;
    }

    // ~ Methods ..............................................................


    // ----------------------------------------------------------
    /**
     * Tests the push method by performing relevant actions and asserting
     * correctness.
     * @param item is the item to push into stack
     */
    public void push(E item)
    {
        Node<E> itemNode;
        itemNode = new Node<E>(null);
        itemNode.setData(item);
        last.join(itemNode);
        last = itemNode;
        size++;
    }


    // ----------------------------------------------------------
    /**
     * Tests the pop method by performing relevant actions and asserting
     * correctness.
     */
    public void pop()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        Node<E> a = last.previous();
        a.split();
        last = a;
        size--;
    }


    // ----------------------------------------------------------
    /**
     * Tests the peek method by performing relevant actions and asserting
     * correctness.
     * @return last.data() the data to be returned in the peek
     */
    public E peek()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        return last.data();
    }


    // ----------------------------------------------------------
    /**
     * Tests the isEmpty method by performing relevant actions and asserting
     * correctness.
     * @return boolean tat determines if the stack is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
}
