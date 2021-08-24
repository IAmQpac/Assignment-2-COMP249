/*
Christian Jerjian
ID: 40031909
COMP 249
Assignment 2 part 1
 */

package Package;

/**
 * Metal Crate Class extends Crate
 */
public class MetalCrate extends Crate {
    /**
     * The shipping cost of metal crate per lb
     */
    private final double SHIPPINGCOSTPERLB = 3;

    /**
     * Constructor of Metal Crate
     */
    public MetalCrate() {
    }

    /**
     * Parameterized constructor of Metal Crate
     * @param trackingNumber    tracking number of metal crate
     * @param weight    weight in lb
     */
    public MetalCrate(int trackingNumber, double weight) {
        super(trackingNumber, weight, 100);
        setShippingCost(SHIPPINGCOSTPERLB);
    }

    /**
     * The toString method returns a string when the Metal Crate Class is called to output something
     * @return String describing toString
     */
    @Override
    public String toString() {
        return "Package.MetalCrate{" +
                "SHIPPINGCOSTPERLB=" + SHIPPINGCOSTPERLB +
                '}' + super.toString();
    }
}
