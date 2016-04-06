// -------------------------------------------------------------------------
/**
 * Represents an employee in a company or business.
 *
 * @author Your name Tyler
 * @version (2016.02.08)
 */
public abstract class Employee
    implements MeetingParticipant
{
    // ~ Fields ................................................................

    private String name;    // The employee's name.
    private double payRate; // The employee's pay rate.


    // ----------------------------------------------------------
    /**
     * Create a new Employee object.
     *
     * @param n
     *            : name String
     * @param pR
     *            : pay rate double
     */
    // ~ Constructor ...........................................................
    public Employee(String n, double pR)
    {
        this.name = n;
        this.payRate = pR;
    }

    // ~ Methods ...............................................................

    // ----------------------------------------------------------


    // ----------------------------------------------------------
    /**
     * Abstract method for determining weekly pay
     *
     * @return name : returns name
     */
    public abstract double weeklyPay();


    /**
     * Creates a notice that one employee is meeting with another
     *
     * @param nextParticipant
     *            : nextParticipant object, meetingParticipant type
     * @return the notice of meeting
     */
    public String meetWith(MeetingParticipant nextParticipant)
    {
        String meeting =
            this.getName() + " is meeting with " + nextParticipant.getName();
        return meeting;
    }


    /**
     * Gets the employee's name.
     *
     * @return the employee's name
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Gets the pay rate.
     *
     * @return the pay rate
     */
    public double getPayRate()
    {
        return payRate;
    }
}
