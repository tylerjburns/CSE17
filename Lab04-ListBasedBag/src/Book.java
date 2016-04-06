// -------------------------------------------------------------------------
/**
 * The Book class represents a simple book with a title (string), author
 * (string), and ISBN number (string).
 *
 * @author John Lewis (authored class skeleton)
 * @author Tyler
 * @version 2016.03.07
 */
public class Book
{
    // ~ Instance/static variables .............................................

    /**
     * The book title.
     */
    protected String title;

    /**
     * The book author.
     */
    protected String author;

    /**
     * The book ISBN number.
     */
    protected String isbn;

    // ~ Constructors ..........................................................


    // ----------------------------------------------------------
    /**
     * Creates a new Book object using the specified data.
     *
     * @param title
     *            The book's title, which cannot be null
     * @param author
     *            The book's author, which cannot be null
     * @param isbn
     *            The book's ISBN, which cannot be null
     * @precondition parameter title is not null and parameter author is not
     *               null and parameter isbn is not null
     */
    public Book(String title, String author, String isbn)
    {
        // Note the use of this.* to refer to fields, when the constructor's
        // parameters have the same names.
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * Getter for the book title.
     *
     * @return the title of the book
     * @postcondition returned value is not null
     */
    public String getTitle()
    {
        return title;
    }


    // ----------------------------------------------------------
    /**
     * Setter for the book title.
     *
     * @param title
     *            the new title of the book
     * @precondition parameter title is not null
     */
    public void setTitle(String title)
    {
        this.title = title;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the author name.
     *
     * @return the author of the book
     * @postcondition returned value is not null
     */
    public String getAuthor()
    {
        return author;
    }


    // ----------------------------------------------------------
    /**
     * Setter for the author name.
     *
     * @param author
     *            the new author of the book
     * @precondition parameter author is not null
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the ISBN number.
     *
     * @return the ISBN of the book
     * @postcondition returned value is not null
     */
    public String getIsbn()
    {
        return isbn;
    }


    // ----------------------------------------------------------
    /**
     * Setter for the ISBN number.
     *
     * @param isbn
     *            the new isbn of the book
     * @precondition parameter isbn is not null
     */
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }


    // ----------------------------------------------------------
    /**
     * Returns a summary description of the book.
     *
     * @return a string representation of the book
     * @postcondition returned value is not null
     */
    public String toString()
    {
        return title + ", " + author + ", " + isbn;
    }


    // ----------------------------------------------------------
    /**
     * Determines if two objects are equivalent books or not.
     * @param a is the object passed to equals()
     * @return a bool dictating whether equal or not
     */
    public boolean equals(Object a)
    {
        if (a instanceof Book)
        {
            return this.getTitle().equals(((Book)a).getTitle());
        }
        return false;
    }
}
