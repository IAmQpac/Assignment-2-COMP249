/*
Christian Jerjian
ID: 40031909
COMP 249
Assignment 2 part 1
 */
package Package;

/**
 * The Box class extends Package
 */
public class Box extends Package {
    /**
     * Shipping cost per pounds for boxes
     */
    private final double shippingCostBoxPerLb = 2;
    /**
     * Maximum weight on pounds for boxes
     */
    private final int MAXWEIGHT = 40;


    /**
     * Default constructor of Box
     */
    public Box() {
    }

    /**
     * Parameterized constructor of Box
     * @param trackingNumber Tracking number of the box
     * @param weight Weight in pounds for the box
     */
    public Box(int trackingNumber, double weight) {
        super(trackingNumber, weight, "lb", 40);
        setShippingCost(shippingCostBoxPerLb);
    }

    /**
     * The toString method returns a string when the Box Class is called to output something
     * @return a String describing the Box
     */
    @Override
    public String toString() {
        return "Package.Box{" +
                "shippingCostBoxPerLb=" + shippingCostBoxPerLb +
                ", MAXWEIGHT=" + MAXWEIGHT +
                '}' + super.toString();
    }
}
