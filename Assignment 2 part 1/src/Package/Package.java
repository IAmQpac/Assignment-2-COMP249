/*
Christian Jerjian
ID: 40031909
COMP 249
Assignment 2 part 1
 */

package Package;

/**
 * Package Class
 */
public abstract class Package {
    //if trackingNumber ends with 0 : package is a letter and weight is in ounces
    //if least significant digit is 1,2,or 3 then package is a box, woodencrate or metal metal, weight in pounds.
    /**
     * Tracking number of package
     */
    private int trackingNumber;
    /**
     * Weight Class of pakcage
     */
    private String weightClass;
    /**
     *Weight of package
     */
    private double weight;
    /**
     * Shipping cost ofpackage
     */
    private double shippingCost;
    /**
     * Maximum weight acceptable
     */
    private int maxWeight;

    /**
     * default constructor
     */
    public Package(){
    }

    /**
     * Parameterized constructor
     * @param trackingNumber trackingNumber
     * @param weight weight
     * @param weightClass weightClass
     * @param maxWeight maxWeight
     */
    public Package(int trackingNumber, double weight, String weightClass, int maxWeight) {
        //it is a Package.Letter
        if (this.getClass() == Letter.class){
            this.trackingNumber = (trackingNumber*10);
        }
        //it is a Package.Box
        else if (this.getClass() == Box.class){
            this.trackingNumber = (trackingNumber*10)+1;
        }

        //it is a Package.WoodCrate
        else if (this.getClass() == WoodCrate.class){
            this.trackingNumber = (trackingNumber*10)+2;
        }
        //it is a Package.MetalCrate
        else if (this.getClass() == MetalCrate.class){
            this.trackingNumber = (trackingNumber*10)+3;
        }

        this.weight = weight;
        this.weightClass = weightClass;
        this.maxWeight = maxWeight;
    }

    /**
     * getTrackingNumber
     * @return  Tracking Number
     */
    public int getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * setTrackingNumber
     * @param trackingNumber trackingNumber
     */
    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }


    /**
     * getWeightClass
     * @return weightClass
     */
    public String getWeightClass() {
        return weightClass;
    }

    /**
     * setWeightClass
     * @param weightClass weightClass
     */
    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }


    /**
     * getWeight
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * setWeight
     * @param weight weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }


    /**
     * getShippingCost
     * @return shippingCost
     */
    public double getShippingCost() {
        return shippingCost;
    }

    /**
     * set shipping cost based on weight
     * @param shippingCostPerWeight shippingCostPerWeight
     */
    //shippingCost is based on weight
    public void setShippingCost(double shippingCostPerWeight) {
        this.shippingCost = shippingCostPerWeight*weight;
    }

    /**
     * getMaxWeight
     * @return maxWeight
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * setMaxWeight
     * @param maxWeight maxWeight
     */
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Changes weight from KG to ounces
     * @param a weight in pounds
     * @return weight in ounces
     */
    public static double toOunces(double a){
        double ounces = a*16;
        return ounces;

    }

    /**
     * Changes the weight to pounds
     * @param a weight in ounces
     * @return weight in pounds
     */
    public static double toPounds(double a){
        double pounds = a/16;
        return pounds;
    }

    /**
     * Changes the weight to kilogram
     * @return Weight in kilogram
     */
    public double toKilogram(){
        if (this.getWeightClass().equals("ounces")){
            return (getWeight()/35.274);
        } else return getWeight()/ 2.205;
    }


    /**
     * The toString method returns a string when the Package class is called to output something
     * @return String describing a package
     */
    @Override
    public String toString() {
        return "Package.Package{" +
                "trackingNumber=" + trackingNumber +
                ", weightClass='" + weightClass + '\'' +
                ", weight=" + weight +
                ", shippingCost=" + shippingCost +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
