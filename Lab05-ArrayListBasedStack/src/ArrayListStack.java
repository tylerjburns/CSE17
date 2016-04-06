import java.util.ArrayList;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * An implementation of the stack data type that adapts an ArrayList to store
 * its contents. This is a PARTIAL IMPLEMENTATION that needs completion.
 *
 * @param <T>
 *            the type of elements stored in the stack
 * @author Tony Allevato (authored class skeleton)
 * @author Tyler
 * @version 2016.03.14
 */
public class ArrayListStack<T>
    implements SimpleStack<T>
{
    // ~ Instance/static variables ............................................

    private ArrayList<T>        aList;
    private EmptyStackException f = new EmptyStackException();

    // ~ Constructors .........................................................


    // ----------------------------------------------------------
    /**
     * Create a new ArrayListStack object.
     */
    public ArrayListStack()
    {
        aList = new ArrayList<T>();
    }

    // ~ Methods ..............................................................


    // ----------------------------------------------------------
    /**
     * Pushes the specified item onto the top of the stack.
     *
     * @param item
     *            the item to push onto the stack
     */
    public void push(T item)
    {
        aList.add(item);
    }


    // ----------------------------------------------------------
    /**
     * Pops an item off the top of the stack.
     *
     * @throws EmptyStackException
     *             if the stack is empty
     */
    public void pop()
        throws EmptyStackException
    {
        try
        {
            aList.remove(aList.size() - 1);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw f;
        }
    }


    // ----------------------------------------------------------
    /**
     * Gets the item at the top of the stack.
     *
     * @return the item at the top of the stack
     * @throws EmptyStackException
     *             if the stack is empty
     */
    public T top()
    {
        try
        {
            return aList.get(aList.size() - 1);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw f;
        }

    }


    // ----------------------------------------------------------
    /**
     * Gets the number of items in the stack.
     *
     * @return the number of items in the stack
     */
    public int size()
    {
        return aList.size();
    }


    // ----------------------------------------------------------
    /**
     * Gets a value indicating whether the stack is empty.
     *
     * @return true if the stack is empty, otherwise false
     */
    public boolean isEmpty()
    {
        return aList.isEmpty();
    }
}
