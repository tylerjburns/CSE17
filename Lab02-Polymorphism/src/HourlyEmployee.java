// -------------------------------------------------------------------------
/**
 * Represents an employee who is paid an hourly wage.
 *
 * @author Your name Tyler
 * @version (2016.02.08)
 */
public class HourlyEmployee
    extends Employee
{
    // ----------------------------------------------------------
    /**
     * Create a new HourlyEmployee object.
     *
     * @param n
     *            : name String
     * @param pR
     *            : pay rate double
     */
    // ~ Fields ................................................................

    // ~ Constructor ...........................................................
    public HourlyEmployee(String n, double pR)
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
        return 40 * super.getPayRate();
    }
}
