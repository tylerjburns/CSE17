import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * An implementation of the Levenshtein distance algorithm.
 *
 * @author Your name Tyler
 * @version 2016.02.19
 */
public class Levenshtein
{

    // ~ Fields ..........................................................

    private String           a;
    private String           b;
    /**
     * HashMap declaration
     */
    HashMap<String, Integer> mem = new HashMap<String, Integer>();


    // ----------------------------------------------------------
    /**
     * Create a new Levenshtein object.
     *
     * @param a
     *            : String a
     * @param b
     *            : String b
     */
    // ~ Constructors ....................................................

    public Levenshtein(String a, String b)
    {
        this.a = a;
        this.b = b;
    }

    // ~ Methods .........................................................


    // ----------------------------------------------------------
    /**
     * Runs through recursive calls to generate a distance between two strings
     * using deletion, insertion, and change
     *
     * @param aStart
     * @param aSubLength
     * @param bStart
     * @param bSubLength
     * @return
     */
    private int distance(int aStart, int aSubLength, int bStart, int bSubLength)
    {
        String set =
            aStart + "," + aSubLength + "," + bStart + "," + bSubLength;
        if (mem.containsKey(set))
        {
            return mem.get(set);
        }
        // change method variable declaration
        int f;

        // deletion method
        if (aSubLength == 0)
        {
            return bSubLength;
        }
        if (bSubLength == 0)
        {
            return aSubLength;
        }
        int d = 1 + distance(aStart + 1, aSubLength - 1, bStart, bSubLength);

        // insertion method
        int e = 1 + distance(aStart, aSubLength, bStart + 1, bSubLength - 1);

        // change method
        if (a.charAt(aStart) == b.charAt(bStart))
        {
            f = distance(
                aStart + 1,
                aSubLength - 1,
                bStart + 1,
                bSubLength - 1);
        }
        else
        {
            f = 1 + distance(
                aStart + 1,
                aSubLength - 1,
                bStart + 1,
                bSubLength - 1);
        }

        int min = Math.min(d, Math.min(e, f));
        mem.put(set, min);
        return min;
    }


    // ----------------------------------------------------------
    /**
     * Calling wrapper for distance(int,int,int,int)
     *
     * @return : returns x
     */
    public int distance()
    {
        int x = distance(0, a.length(), 0, b.length());
        return x;
    }
}
