// -------------------------------------------------------------------------
/**
 * Represents an employee who is paid a yearly salary.
 *
 * @author Your name Tyler
 * @version (2016.02.08)
 */
public class SalariedEmployee
    extends Employee
{

    // ~ Fields ................................................................

    // ~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Create a new SalariedEmployee object.
     *
     * @param n
     *            : name String
     * @param pR
     *            : pay rate double
     */
    public SalariedEmployee(String n, double pR)
    {
        super(n, pR);
    }


    // ~ Methods ...............................................................

    /**
     * Returns the payrate of the employee in question
     *
     * @return the payrate
     */
    public double weeklyPay()
    {
        return super.getPayRate();
    }


    /**
     * Creates a notice that one employee is having a conference with another
     *
     * @param otherParticipant : SalariedEmployee type
     * @return the notice of conference
     */
    public String meetWith(SalariedEmployee otherParticipant)
    {
        String conference = otherParticipant.getName() + " is joining "
            + this.getName() + " in a conference";
        return conference;
    }
}
