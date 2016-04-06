// -------------------------------------------------------------------------
/**
 *  This class holds methods that search an array for a given element
 *
 *  @author Tyler
 *  @version Feb 26, 2016
 */
public class EventFinder
{
    // ----------------------------------------------------------
    /**
     * Create a new EventFinder object.
     */
    public EventFinder() {

    }

    // ----------------------------------------------------------
    /**
     * Utilizes a recursive approach to binary search to find a specific
     * element in the array.
     * @param event to be searched for
     * @param allEvents array to be searched
     * @param startIndex lower bound for search
     * @param endIndex upper bound for search
     * @return position the element was found at
     */
    public int find(
        HistoricEvent event,
        HistoricEvent[] allEvents,
        int startIndex,
        int endIndex)
    {
        if (startIndex > endIndex)
        {
            return startIndex;
        }
        else
        {
            int position = (startIndex + endIndex) / 2;
            int compResult = event.compareTo(allEvents[position]);
            if (compResult == 0)
            {
                return position;
            }
            else if (compResult < 0)
            {
                return find(event, allEvents, startIndex, position - 1);
            }
            else
            {
                return find(event, allEvents, position + 1, endIndex);
            }
        }

    }


    // ----------------------------------------------------------
    /**
     * Wrapper method for find above. Takes only two parameters and infers the
     * other two, assuming the user wants to search the whole data set.
     * @param event to be searched for
     * @param allEvents array to be searched
     * @return position element was found
     */
    public int find(HistoricEvent event, HistoricEvent[] allEvents)
    {
        return find(event, allEvents, 0, allEvents.length - 1);
    }
}
