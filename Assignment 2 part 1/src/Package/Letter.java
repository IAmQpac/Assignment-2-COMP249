/*
Christian Jerjian
ID: 40031909
COMP 249
Assignment 2 part 1
 */
package Package;

/**
 * The Letter class extends package
 */
public class Letter extends Package {
    /**
     * Shipping cost of letter per ounce
     */
    private final double SHIPPINGCOSTLETTERPERONCE = 0.05; // 0.003125 in pounds

    /**
     * Default Constructor
     */
    public Letter() {
    }

    /**
     * Parameterized constructor
     * @param trackingNumber Tracking number of letter
     * @param weight weight of letter in ounces
     */
    public Letter(int trackingNumber, double weight) {
        super(trackingNumber, weight, "ounces", 32);
        setShippingCost(SHIPPINGCOSTLETTERPERONCE);
    }

    /**
     * The toString method returns a string when the Letter Class is called to output something
     * @return a String describing the Letter
     */
    @Override
    public String toString() {
        return "Package.Letter{" +
                "SHIPPINGCOSTLETTERPERONCE=" + SHIPPINGCOSTLETTERPERONCE +
                '}' + super.toString();
    }
}
