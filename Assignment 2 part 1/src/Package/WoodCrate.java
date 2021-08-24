/*
Christian Jerjian
ID: 40031909
COMP 249
Assignment 2 part 1
 */

package Package;

/**
 * WoodCrate class extends Crate
 */
public class WoodCrate extends Crate{
    /**
     * Shipping Cost
     */
    private final double SHIPPINGCOSTPERLB = 2.5;


    /**
     * Constructor
     */
    public WoodCrate() {
    }

    /**
     * Parameterized Constructor
     * @param trackingNumber Tracking Number of WoodCrate
     * @param weight   Weight of Wood Crate
     */
    public WoodCrate(int trackingNumber, double weight) {
        super(trackingNumber, weight, 80);
        setShippingCost(SHIPPINGCOSTPERLB);
    }

    /**
     * The toString method returns a string when the WoodCrate Class is called to output something
     * @return String describing the wood crate
     */
    @Override
    public String toString() {
        return "Package.WoodCrate{" +
                "SHIPPINGCOSTPERLB=" + SHIPPINGCOSTPERLB +
                '}' + super.toString();
    }
}
