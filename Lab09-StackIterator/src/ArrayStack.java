import java.util.Iterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 * A list-based implementation of a stack.
 *
 * @param <Item>
 *            The type of elements contained in the bag.
 * @author Stephen Edwards
 * @author Tyler
 * @version 2016.04.04
 */
public class ArrayStack<Item>
    implements Stack<Item>
{

    private class StackIterator
        implements Iterator<Item>
    {
        int  index;
        Item temp;

        public StackIterator()
        {
            index = size;
        }

        @Override
        public boolean hasNext()
        {
            return index > 0;
        }


        @Override
        public Item next()
        {
            if (this.hasNext())
            {
                index--;
                temp = contents[index];
                return temp;
            }
            NoSuchElementException e =
                new NoSuchElementException("The stack is empty.");
            throw e;
        }


        public void remove()
        {
            if (temp != null)
            {
                temp = null;
                for (int i = index; i < size; i++)
                {
                    contents[i] = contents[index + i];
                }
                size--;
            }
            else
            {
                IllegalStateException e = new IllegalStateException(
                    "Either next() has not been called yet, or remove() was "
                        + "called twice in a row, or there is no element to "
                        + "remove and the stack is empty");
                throw e;
            }

        }
    }
    // ~ Instance/static variables .............................................

    private static final int DEFAULT_CAPACITY = 10;

    private int              size;                 // the current number of
                                                   // items in the collection
    private Item[]           contents;             // the set's contents

    // ~ Constructor ...........................................................


    // ----------------------------------------------------------
    /**
     * Create an empty stack with the default capacity.
     */
    public ArrayStack()
    {
        size = 0;

        // It is not possible in Java to create a new array containing
        // objects of a generic type like Item, so we have to use a "trick",
        // creating an Object[] array and then telling the compiler to
        // treat it as a Item[] array instead:
        @SuppressWarnings("unchecked")
        Item[] newArray = (Item[])(new Object[DEFAULT_CAPACITY]);

        // Now that we have created the array, we can use it as the
        // initial value for our field
        contents = newArray;
    }

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * Test if the stack is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Make the stack logically empty.
     */
    public void clear()
    {
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Insert a new item into the stack.
     *
     * @param value
     *            the item to insert.
     */
    public void push(Item value)
    {
        if (size >= contents.length)
        {
            expandCapacity();
        }

        contents[size] = value;
        ++size;
    }


    // ----------------------------------------------------------
    /**
     * Remove the most recently inserted item from the stack.
     */
    public void pop()
    {
        --size;
    }


    // ----------------------------------------------------------
    /**
     * Get the most recently inserted item in the stack. Does not alter the
     * stack.
     *
     * @return the most recently inserted item in the stack.
     * @precondition The stack is not empty.
     */
    public Item top()
    {
        return contents[size - 1];
    }


    // ----------------------------------------------------------
    /**
     * Return and remove the most recently inserted item from the stack.
     *
     * @return the most recently inserted item in the stack.
     * @precondition The stack is not empty.
     */
    public Item topAndPop()
    {
        pop();
        return contents[size];
    }

    // ~ Private methods .......................................................


    // ----------------------------------------------------------
    /*
     * Creates a new array to store the contents of the collection with twice
     * the capacity of the old one.
     */
    private void expandCapacity()
    {
        @SuppressWarnings("unchecked")
        Item[] larger = (Item[])(new Object[contents.length * 2]);

        for (int i = 0; i < size; i++)
        {
            larger[i] = contents[i];
        }

        contents = larger;
    }


    @Override
    public Iterator<Item> iterator()
    {
        return new StackIterator();
    }

}
