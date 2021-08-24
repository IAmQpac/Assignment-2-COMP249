/*
Christian Jerjian
ID: 40031909
COMP 249
Assignment 2 part 1
 */

package Package;

/**
 * The Crate class extends Package
 */
public class Crate extends Package {

    /**
     * The Crate default Constructor
     */
    public Crate() {
    }

    /**
     * The Parameterized constructor of Crate
     * @param trackingNumber    Tracking Number of Crate
     * @param weight    Weight in lb
     * @param MAXWEIGHT Max weight in lb
     */
    public Crate(int trackingNumber, double weight, int MAXWEIGHT) {
        super(trackingNumber, weight, "lb", MAXWEIGHT);
    }

    /**
     * The toString method returns a string when the Crate Class is called to output something
     * @return returns a string about information
     */
    @Override
    public String toString() {
        return "Package.Crate{}" + super.toString();
    }
}
