/**
 * // -------------------------------------------------------------------------
/**
 *  This class defines a computer object with parameters:
 *  processor
 *  processorSpeed
 *  numCores
 *
 *  @author Tyler
 *  @version Jan 29, 2016
 */
public class Computer
{
    private String processor;
    private int numCores;
    private double processorSpeed;

    // ----------------------------------------------------------
    /**
     * Creates a new Computer object.
     * @param proc : represents the processor name
     * @param numCor : represent the number of cores in the processor
     * @param procSpeed : represents the speed of each core
     */
    public Computer(String proc, int numCor, double procSpeed) {
        this.processor = proc;
        this.numCores = numCor;
        this.processorSpeed = procSpeed;
    }

    // ----------------------------------------------------------
    /**
     * Returns the value of processor.
     * @return processor value
     */
    public String getProcessor() {
        return this.processor;
    }

    // ----------------------------------------------------------
    /**
     * Sets the value of processor.
     * @param c : name of the string that holds the processor name
     */
    public void setProcessor(String c) {
        this.processor = c;
    }

    // ----------------------------------------------------------
    /**
     * Returns the value of numCores.
     * @return numCores value
     */
    public int getNumCores() {
        return this.numCores;
    }

    // ----------------------------------------------------------
    /**
     * Sets the numCores value.
     * @param a : name of the integer that holds the number of cores
     */
    public void setNumCores(int a) {
        this.numCores = a;
    }

    // ----------------------------------------------------------
    /**
     * Returns the value of processorSpeed.
     * @return processorSpeed value
     */
    public double getProcessorSpeed() {
        return this.processorSpeed;
    }

    // ----------------------------------------------------------
    /**
     * Sets processorSpeed value.
     * @param b : name of the double that holds the processor speed
     */
    public void setProcessorSpeed(double b) {
        this.processorSpeed = b;
    }

    // ----------------------------------------------------------
    /**
     * Calculates computer power and returns as a double.
     * @return power
     */
    public double computePower() {
        double power = processorSpeed * numCores;
        return power;
    }

    // ----------------------------------------------------------
    /**
     * Puts the processor, core number and speed info into a string and returns
     * @return info
     */
    public String toString() {
        String info = processor + ", " + numCores + " cores at "
            + processorSpeed + "GHz";
        return info;
    }
}
